package cn.gabongao.controller;

import cn.gabongao.Context;
import cn.gabongao.PTSite.PTSiteInfoUpdater;
import cn.gabongao.dao.CookieDao;
import cn.gabongao.dao.InfoDao;
import cn.gabongao.dao.RecentInfoDao;
import cn.gabongao.model.CookiePOJO;
import cn.gabongao.model.Info;
import cn.gabongao.model.RecentInfo;
import cn.gabongao.model.Rule;
import cn.gabongao.utils.EchartsUtils;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;

import static cn.gabongao.Main.executor;

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

@Component
public class InfoPageController extends AbstractRegisterController implements Initializable {


    @FXML
    private TableColumn<Info, String> site;

    @FXML
    private TableColumn<Info, String> userName;

    @FXML
    private TableColumn<Info, String> userID;

    @FXML
    private TableColumn<Info, String> upload;

    @FXML
    private TableColumn<Info, String> download;

    @FXML
    private TableColumn<Info, String> shareRatio;

    @FXML
    private TableColumn<Info, String> bonus;

    @FXML
    private TableColumn<Info, String> uploadCount;

    @FXML
    private TableColumn<Info, String> uploadTime;

    @FXML
    private TableColumn<Info, String> downloadTime;

    @FXML
    private TableColumn<Info, String> joinDate;

    @FXML
    private TableColumn<Info, String> grade;

    @FXML
    private TableColumn<Info, String> inviteCount;

    @FXML
    private TableColumn<Info, String> state;
//
//    @FXML
//    private TableColumn<Info, String> uploadSize;

    @FXML
    private TableView<Info> table;

    @FXML
    private TableView<RecentInfo> recentTable;

    @FXML
    private TableColumn<RecentInfo, String> site2;
    @FXML
    private TableColumn<RecentInfo, String> upload2;
    @FXML
    private TableColumn<RecentInfo, String> download2;
    @FXML
    private TableColumn<RecentInfo, String> shareRatio2;
    @FXML
    private TableColumn<RecentInfo, String> bonus2;
    @FXML
    private TableColumn<RecentInfo, String> uploadCount2;
    @FXML
    private TableColumn<RecentInfo, String> uploadTime2;
    @FXML
    private TableColumn<RecentInfo, String> date;

    @FXML
    private WebView chart;

    @FXML
    private SplitPane pane1;

    @FXML
    private Label test;

    @FXML
    private ChoiceBox<String> chooseDate;

    @FXML
    private ObservableList<RecentInfo> recentData = FXCollections.observableArrayList();

    public ObservableList<Info> getInfoData() {
        return infoData;
    }

    @FXML
    private ObservableList<Info> infoData = FXCollections.observableArrayList();


    //render只应该把存储在数据的上次的info提取出来，再调用update函数更新数据。
    public void loadData() {
        for (Info info :
                Context.ac.getBean(InfoDao.class).getAll()) {
//            Info info = new Info(infoPOJO);
            info.setState("上次同步");

            infoData.add(info);
        }


    }

    public void update() {
        for (Info i :
                infoData) {
            registePasskeyAndCookie(i);

            update(i);
        }
    }

    private void registePasskeyAndCookie(Info i) {
        try {
            URL url = new URL(i.getUrl());
            Context.urlPasskeyMap.put(url.getHost(), i.getPasskey());
            Context.urlCookieMap.put(url.getHost(), i.getCookie());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void update(Info info) {
        executor.submit(() -> {
            info.setState("同步中");
            try {
                Context.ac.getBean(PTSiteInfoUpdater.class).update(info);
            } catch (Exception e) {
                e.printStackTrace();
                info.setState("同步失败");
            }
            info.setState("同步完成");

            registePasskeyAndCookie(info);


            Context.ac.getBean(InfoDao.class).insert(info);
            try {
                URL url1;
                url1 = new URL(info.getUrl());
                String host = url1.getHost();
                Context.ac.getBean(CookieDao.class).insert(new CookiePOJO(host, info.getCookie()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Context.ac.getBean(RecentInfoDao.class).insert(info.buildRecentInfo());
        });
    }


    public TableColumn<Info, String> getUserName() {
        return userName;
    }

    public TableColumn<Info, String> getUserID() {
        return userID;
    }

    public TableColumn<Info, String> getInviteCount() {
        return inviteCount;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //向Context注册，方便通信
        register();
//        site.setStyle("-fx-alignment: CENTER-RIGHT;");
        userName.setStyle("-fx-alignment: CENTER-RIGHT;");
        userID.setStyle("-fx-alignment: CENTER-RIGHT;");
        upload.setStyle("-fx-alignment: CENTER-RIGHT;");
        download.setStyle("-fx-alignment: CENTER-RIGHT;");
        shareRatio.setStyle("-fx-alignment: CENTER-RIGHT;");
        bonus.setStyle("-fx-alignment: CENTER-RIGHT;");
        uploadCount.setStyle("-fx-alignment: CENTER-RIGHT;");
        uploadTime.setStyle("-fx-alignment: CENTER-RIGHT;");
        joinDate.setStyle("-fx-alignment: CENTER-RIGHT;");
        grade.setStyle("-fx-alignment: CENTER-RIGHT;");
        inviteCount.setStyle("-fx-alignment: CENTER-RIGHT;");
        state.setStyle("-fx-alignment: CENTER-RIGHT;");
        downloadTime.setStyle("-fx-alignment: CENTER-RIGHT;");

        //绑定数据到表格
        site.setCellValueFactory(cellData -> cellData.getValue().siteProperty());
        userName.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());
        userID.setCellValueFactory(cellData -> cellData.getValue().userIDProperty());
        upload.setCellValueFactory(cellData -> cellData.getValue().uploadProperty());
        download.setCellValueFactory(cellData -> cellData.getValue().downloadProperty());
        shareRatio.setCellValueFactory(cellData -> cellData.getValue().shareRatioProperty());
        bonus.setCellValueFactory(cellData -> cellData.getValue().bonusProperty());
        uploadCount.setCellValueFactory(cellData -> cellData.getValue().uploadCountProperty());
//        uploadSize.setCellValueFactory(cellData -> cellData.getValue().uploadSizeProperty());
        uploadTime.setCellValueFactory(cellData -> cellData.getValue().uploadTimeProperty());
        joinDate.setCellValueFactory(cellData -> cellData.getValue().joinDateProperty());
        grade.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());
        inviteCount.setCellValueFactory(cellData -> cellData.getValue().inviteCountProperty());
        state.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        downloadTime.setCellValueFactory(cellData -> cellData.getValue().downloadTimeProperty());

        site2.setCellValueFactory(cellData -> cellData.getValue().siteProperty());
        upload2.setCellValueFactory(cellData -> cellData.getValue().uploadProperty());
        download2.setCellValueFactory(cellData -> cellData.getValue().downloadProperty());
        shareRatio2.setCellValueFactory(cellData -> cellData.getValue().shareRatioProperty());
        bonus2.setCellValueFactory(cellData -> cellData.getValue().bonusProperty());
        uploadCount2.setCellValueFactory(cellData -> cellData.getValue().uploadCountProperty());
        uploadTime2.setCellValueFactory(cellData -> cellData.getValue().uploadTimeProperty());
        date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        //空白表格添加右键菜单
        final ContextMenu rowMenu3 = new ContextMenu();
        Menu addMenu2 = new Menu("添加站点");
        addSiteMenu(addMenu2);
        rowMenu3.getItems().addAll(addMenu2);
        table.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            if (infoData.size() == 0) {
                if (t.getButton() == MouseButton.SECONDARY) {
                    rowMenu3.show(table, t.getScreenX(), t.getScreenY());
                }
            }
        });


        //设置rowFactory
        table.setRowFactory(tv -> {
            TableRow<Info> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && event.getButton() == MouseButton.PRIMARY && (!row.isEmpty())) {
                    Info info = row.getItem();

                    recentData.clear();
                    List<RecentInfo> siteRecentInfo = Context.ac.getBean(RecentInfoDao.class).getSiteRecentInfo(info);
                    Collections.reverse(siteRecentInfo);
                    recentData.addAll(siteRecentInfo);
                    Collections.reverse(siteRecentInfo);
                    String standard = EchartsUtils.render(siteRecentInfo);
                    chart.getEngine().loadContent(standard, "text/html");

                    //todo

                }

            });

            final ContextMenu rowMenu = new ContextMenu();
            MenuItem editItem = new MenuItem("同步");
            editItem.setOnAction(event -> {
                Info info = row.getItem();
                update(info);
            });
//            MenuItem openSite = new MenuItem("打开网站");
//            editItem.setOnAction(event -> {
//                Info info = row.getItem();
//                String url = info.getUrl();
//                //todo open site in browser
//
//            });
            MenuItem removeItem = new MenuItem("删除");
            removeItem.setOnAction(event -> {
                Info info = row.getItem();
                table.getItems().remove(row.getItem());
                Context.ac.getBean(InfoDao.class).remove(info);
                Context.ac.getBean(RecentInfoDao.class).remove(info);
                try {
                    URL url1;
                    url1 = new URL(info.getUrl());
                    String host = url1.getHost();
                    Context.ac.getBean(CookieDao.class).remove(host);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            });
            rowMenu.getItems().addAll(editItem, removeItem);

            final ContextMenu rowMenu2 = new ContextMenu();
            Menu addMenu = new Menu("添加站点");
            addSiteMenu(addMenu);

            rowMenu2.getItems().addAll(addMenu);

            // only display context menu for non-null items:
            row.contextMenuProperty().bind(
                    Bindings.when(Bindings.isNotNull(row.itemProperty()))
                            .then(rowMenu)
                            .otherwise(rowMenu2));
            return row;
        });


        //绑定数据
        table.setItems(infoData);
        recentTable.setItems(recentData);


        loadData();
        update();
    }


    private void addSiteMenu(Menu addMenu) {

        for (Rule rule :
                Context.ruleMap.values()) {
            MenuItem menuItem = new MenuItem(rule.getSite());
            menuItem.setOnAction(event -> {
                Parent target;//载入窗口B的定义文件；
                try {

                    if (rule.getIsHttpOnly() == 0) {

                        target = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
                        Scene scene = new Scene(target); //创建场景；
                        Stage stg = new Stage();//创建舞台；
                        stg.setScene(scene); //将场景载入舞台；

                        WebView webView = ((LoginController) Context.controllers.get("LoginController")).getWebView();

                        webView.getEngine().load(rule.getBaseUrl());

                        for (CookiePOJO c :
                                Context.ac.getBean(CookieDao.class).selectAll()) {
                            URI uri = URI.create("http://" + c.getUrl());

                            String cookie = c.getCookies();
                            List<String> header = new ArrayList<>();
                            for (String s :
                                    cookie.split(";")) {
                                header.add(s.trim());
                            }

                            Map<String, List<String>> headers = new LinkedHashMap<>();
                            headers.put("Set-Cookie", header);

//            System.out.println(headers);
                            try {
                                java.net.CookieHandler.getDefault().put(uri, headers);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        Button button = ((LoginController) Context.controllers.get("LoginController")).getButton();
                        button.setOnAction(e -> {
                            String cookie = (String) webView.getEngine().executeScript("document.cookie");
                            //todo if success
                            Info info = new Info();
                            info.setSite(rule.getSite());

                            info.setCookie(cookie);
                            info.setUrl(rule.getBaseUrl());
                            Context.ac.getBean(InfoDao.class).insert(info);
                            infoData.add(info);
                            update(info);
                            button.setText("登录成功！");
                            button.setDisable(true);
                        });

                        stg.show(); //显示窗口；
                    } else {
                        target = FXMLLoader.load(getClass().getResource("/fxml/AddHttpOnly.fxml"));
                        Scene scene = new Scene(target); //创建场景；
                        Stage stg = new Stage();//创建舞台；
                        stg.setScene(scene); //将场景载入舞台；
                        stg.setResizable(false);
                        AddHttpOnlyController addHttpOnlyController = (AddHttpOnlyController) Context.controllers.get("AddHttpOnlyController");
                        Button button = addHttpOnlyController.getButton();
                        TextField cookieField = addHttpOnlyController.getCookie();
                        button.setOnAction(event1 -> {
                            String cookie = cookieField.getText();
                            if (cookie == null || cookie.equals("")) {
                                Notifications.create()
                                        .graphic(null)
                                        .hideAfter(Duration.seconds(5))
                                        .text("请输入Cookie")
                                        .darkStyle()
                                        .position(Pos.CENTER)
                                        .showError();
                            } else {
                                Info info = new Info();
                                info.setSite(rule.getSite());

                                info.setCookie(cookie);
                                info.setUrl(rule.getBaseUrl());
                                Context.ac.getBean(InfoDao.class).insert(info);
                                infoData.add(info);
                                update(info);
                                button.setText("登录成功！");
                                button.setDisable(true);
                            }

                        });
                        stg.show();
                        //todo 手动添加cookies
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
            addMenu.getItems().add(menuItem);
        }
    }

}
