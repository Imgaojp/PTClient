package cn.gabongao.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

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
 * Created by Imgaojp on 2018/9/3.
 */
public class BrowserPageController extends AbstractRegisterController implements Initializable {

    @FXML
    private VBox box;

//    @FXML
//    private WebView browser;
//
//    @FXML
//    private Button cookie;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        register();
        Label label = new Label();
        label.setText("正在开发中");
        VBox.setVgrow(label, Priority.ALWAYS);
        box.getChildren().add(label);
//        BorderPane root = new BorderPane();
//        root.setTop(box);
//        root.setCenter(new WebBrowserController());
//        WebBrowserController browser = new WebBrowserController();
//        box.getChildren().add(browser);
//        VBox.setVgrow(browser, Priority.ALWAYS);
//        browser.getEngine().setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
//
//
//        browser.getEngine().getLoadWorker().stateProperty().addListener(
//                (ov, oldState, newState) -> {
//                    if (newState == Worker.State.SUCCEEDED) {
//                        System.out.println(browser.getEngine().executeScript("document.cookie"));
//                        try {
//                            URL url1 = new URL(browser.getEngine().getLocation());
//                            String host = url1.getHost();
//                            String cookie = (String) browser.getEngine().executeScript("document.cookie");
//                            CookiePOJO cookiePOJO1 = new CookiePOJO();
//                            cookiePOJO1.setCookies(cookie);
//                            cookiePOJO1.setUrl(host);
//                            (Context.ac.getBean(CookieDao.class)).insert(cookiePOJO1);
//                        } catch (MalformedURLException var6) {
//                            var6.printStackTrace();
//                        }
//                    }
//                });
//
//        for (CookiePOJO c :
//                Context.ac.getBean(CookieDao.class).selectAll()) {
//            URI uri = URI.create("http://" + c.getUrl());
//
//            String cookie = c.getCookies();
//            List<String> header = new ArrayList<>();
//            for (String s :
//                    cookie.split(";")) {
//                header.add(s.trim());
//            }
//
//            Map<String, List<String>> headers = new LinkedHashMap<>();
//            headers.put("Set-Cookie", header);
//
////            System.out.println(headers);
//            try {
//                java.net.CookieHandler.getDefault().put(uri, headers);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
////        browser.getEngine().load("https://www.baidu.com");
//        browser.getEngine().load("https://hdchina.org");
//
//
//        cookie.setOnAction(event -> {
//            System.out.println(browser.getEngine().executeScript("document.cookie"));
//        });
    }
}
