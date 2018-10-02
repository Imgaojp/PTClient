package cn.gabongao.utils.downloader;


import cn.gabongao.Context;
import cn.gabongao.dao.ProxyDao;
import cn.gabongao.utils.entity.Request;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * Created by Imgaojp on 2018/9/28.
 */
@Aspect
@Component
public class ProxyAspect {


    private final ProxyDao dao;

    @Autowired
    public ProxyAspect(ProxyDao dao) {
        this.dao = dao;
    }

    @Pointcut(value = "execution(* cn.gabongao.utils.downloader.HttpClientDownloader.download*(..)) &&" + "args(request)", argNames = "request")
    public void download(Request request) {
    }

    @Before(value = "download(request)", argNames = "request")
    public void addCookieViaAOP(Request request) {
        URL url;
        try {
            url = new URL(request.getUrl());
            String host = url.getHost();
            String cookie = Context.urlCookieMap.get(host);
            if (cookie != null) {
                request.addCookies(cookie);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Before("execution(* cn.gabongao.utils.downloader.HttpClientDownloader.download*(..)) &&" + "args(request)")
    public void addProxy(Request request) {
        try {
            URL url = new URL(request.getUrl());
            String host = url.getHost();
            if (Context.useProxy.contains(host)) {
                request.setProxy(dao.getProxy());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
