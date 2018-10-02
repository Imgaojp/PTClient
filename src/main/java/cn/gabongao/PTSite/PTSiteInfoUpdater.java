package cn.gabongao.PTSite;

import cn.gabongao.Context;
import cn.gabongao.model.Info;
import cn.gabongao.model.Rule;
import cn.gabongao.utils.downloader.HttpClientDownloader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
@Component
public class PTSiteInfoUpdater {

    private final HttpClientDownloader downloader;

    private final NetClassLoaderUtils classLoaderUtils;

    private Object infoParser;

    private Class<?> clazz;

    @Autowired
    public PTSiteInfoUpdater(NetClassLoaderUtils classLoaderUtils, HttpClientDownloader downloader) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        this.classLoaderUtils = classLoaderUtils;
        this.downloader = downloader;
        clazz = classLoaderUtils.findClass("cn.gabongao.PTSite.PTSiteInfoUpdateEngine");
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(HttpClientDownloader.class);
        this.infoParser = declaredConstructor.newInstance(downloader);

    }


    public void update(Info info) {
        Rule rule = Context.ruleMap.get(info.getSite());
        try {
            Method method = clazz.getMethod(rule.getUpdateMethod(), Info.class, Rule.class);
            method.invoke(infoParser, info, rule);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


}
