package cn.gabongao.PTSite;

import cn.gabongao.model.Rule;
import cn.gabongao.model.SearchResult;
import cn.gabongao.utils.downloader.HttpClientDownloader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static cn.gabongao.Context.ruleMap;


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
 * Created by Imgaojp on 2018/9/26.
 */
@Component
public class Searcher {
    private final HttpClientDownloader downloader;

    private final NetClassLoaderUtils classLoaderUtils;
    private final Class<?> clazz;
    private final Object searchEngine;


    @Autowired
    public Searcher(HttpClientDownloader downloader, NetClassLoaderUtils classLoaderUtils) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        this.downloader = downloader;
        this.classLoaderUtils = classLoaderUtils;
        clazz = classLoaderUtils.findClass("cn.gabongao.PTSite.SearchEngine");
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(HttpClientDownloader.class);
        this.searchEngine = declaredConstructor.newInstance(downloader);

    }

    @SuppressWarnings("unchecked")
    public List<SearchResult> search(String site, String word, String cookie) {
        Rule rule = ruleMap.get(site);
        String url = String.format(rule.getSearchUrl(), word);
        String baseurl = rule.getBaseUrl();
        try {
            Method method = clazz.getMethod(rule.getSearchMethod(), String.class, String.class, String.class, String.class);
            return (List<SearchResult>) method.invoke(searchEngine, url, cookie, baseurl, site);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
