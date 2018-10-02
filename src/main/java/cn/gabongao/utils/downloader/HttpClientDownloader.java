package cn.gabongao.utils.downloader;


import cn.gabongao.utils.CharsetUtils;
import cn.gabongao.utils.HttpClientUtils;
import cn.gabongao.utils.entity.Page;
import cn.gabongao.utils.entity.Request;
import cn.gabongao.utils.entity.Site;
import cn.gabongao.utils.entity.Task;
import cn.gabongao.utils.selector.PlainText;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


/**
 * The http downloader based on HttpClient.
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
//@Slf4j
@Component
public class HttpClientDownloader extends AbstractDownloader {

    private final Map<String, CloseableHttpClient> httpClients = new HashMap<String, CloseableHttpClient>();
    private Logger log = LoggerFactory.getLogger(getClass());
    private HttpClientGenerator httpClientGenerator = new HttpClientGenerator();

    private HttpUriRequestConverter httpUriRequestConverter = new HttpUriRequestConverter();


    private boolean responseHeader = true;


    public HttpClientDownloader() {
    }

    public void setHttpUriRequestConverter(HttpUriRequestConverter httpUriRequestConverter) {
        this.httpUriRequestConverter = httpUriRequestConverter;
    }


    private CloseableHttpClient getHttpClient(Site site) {
        if (site == null) {
            return httpClientGenerator.getClient(null);
        }
        String domain = site.getDomain();
        CloseableHttpClient httpClient = httpClients.get(domain);
        if (httpClient == null) {
            synchronized (this) {
                httpClient = httpClients.get(domain);
                if (httpClient == null) {
                    httpClient = httpClientGenerator.getClient(site);
                    httpClients.put(domain, httpClient);
                }
            }
        }
        return httpClient;
    }


    @Override
    public Page download(Request request, Task task) {
        if (task == null || task.getSite() == null) {
            throw new NullPointerException("task or site can not be null");
        }
        CloseableHttpResponse httpResponse = null;
        CloseableHttpClient httpClient = getHttpClient(task.getSite());
        HttpClientRequestContext requestContext = httpUriRequestConverter.convert(request, task.getSite());
        Page page = Page.fail();
        try {
            httpResponse = httpClient.execute(requestContext.getHttpUriRequest(), requestContext.getHttpClientContext());
            page = handleResponse(request, task.getSite().getCharset(), httpResponse, task);
            if (page.getStatusCode() == 403 || page.getStatusCode() == 414) {
                page.setDownloadSuccess(false);
            }
            onSuccess(request);
            log.info("downloading page success {}", request.getUrl());
            return page;
        } catch (IOException e) {
            page.setDownloadSuccess(false);
            log.warn("download page {} error {}", request.getUrl(), e);
            onError(request);
            return page;
        } finally {
            if (httpResponse != null) {
                //ensure the connection is released back to pool
                EntityUtils.consumeQuietly(httpResponse.getEntity());
            }
        }
    }


    public Page download(Request request) {
        CloseableHttpResponse httpResponse = null;
        CloseableHttpClient httpClient = httpClientGenerator.getClient(null);
        HttpClientRequestContext requestContext = httpUriRequestConverter.convert(request);
        Page page = Page.fail();
        try {
            httpResponse = httpClient.execute(requestContext.getHttpUriRequest(), requestContext.getHttpClientContext());
            page = handleResponse(request, httpResponse);
            if (page.getStatusCode() == 403 || page.getStatusCode() == 414) {
                page.setDownloadSuccess(false);
            }
            onSuccess(request);
            log.info("downloading page success {}", request.getUrl());
            return page;
        } catch (IOException e) {
            page.setDownloadSuccess(false);
            log.warn("download page {} error {}", request.getUrl(), e);
            onError(request);
            return page;
        } finally {
            if (httpResponse != null) {
                //ensure the connection is released back to pool
                EntityUtils.consumeQuietly(httpResponse.getEntity());
            }
        }
    }

    public byte[] downloadRaw(Request request) {
        CloseableHttpResponse httpResponse = null;
        CloseableHttpClient httpClient = httpClientGenerator.getClient(null);
        HttpClientRequestContext requestContext = httpUriRequestConverter.convert(request);
        try {
            httpResponse = httpClient.execute(requestContext.getHttpUriRequest(), requestContext.getHttpClientContext());

            log.info("downloading page success {}", request.getUrl());

            return EntityUtils.toByteArray(httpResponse.getEntity());
        } catch (IOException e) {
            log.warn("download page {} error {}", request.getUrl(), e);
            return null;
        } finally {
            if (httpResponse != null) {
                EntityUtils.consumeQuietly(httpResponse.getEntity());
            }
        }
    }

    @Override
    public void setThread(int thread) {
        httpClientGenerator.setPoolSize(thread);
    }

    protected Page handleResponse(Request request, String charset, HttpResponse httpResponse, Task task) throws IOException {
        String content = getResponseContent(charset, httpResponse);
        Page page = new Page();
        page.setRawText(content);
        page.setUrl(new PlainText(request.getUrl()));
        page.setRequest(request);
        page.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        page.setDownloadSuccess(true);
        if (responseHeader) {
            page.setHeaders(HttpClientUtils.convertHeaders(httpResponse.getAllHeaders()));
        }
        return page;
    }

    protected Page handleResponse(Request request, HttpResponse httpResponse) throws IOException {
        String content = getResponseContent(httpResponse);
        Page page = new Page();
        page.setRawText(content);
        page.setUrl(new PlainText(request.getUrl()));
        page.setRequest(request);
        page.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        page.setDownloadSuccess(true);
        if (responseHeader) {
            page.setHeaders(HttpClientUtils.convertHeaders(httpResponse.getAllHeaders()));
        }
        return page;
    }

    private String getResponseContent(String charset, HttpResponse httpResponse) throws IOException {
        if (charset == null) {
            return getResponseContent(httpResponse);
        } else {
            return IOUtils.toString(httpResponse.getEntity().getContent(), charset);
        }
    }

    private String getResponseContent(HttpResponse httpResponse) throws IOException {
        byte[] contentBytes = IOUtils.toByteArray(httpResponse.getEntity().getContent());
        String htmlCharset = getHtmlCharset(httpResponse, contentBytes);
        if (htmlCharset != null) {
            return new String(contentBytes, htmlCharset);
        } else {
            log.warn("Charset autodetect failed, use {} as charset. Please specify charset in Site.setCharset()", Charset.defaultCharset());
            return new String(contentBytes);
        }

    }

    private String getHtmlCharset(HttpResponse httpResponse, byte[] contentBytes) throws IOException {
        return CharsetUtils.detectCharset(httpResponse.getEntity().getContentType() == null ? "" : httpResponse.getEntity().getContentType().getValue(), contentBytes);
    }
}
