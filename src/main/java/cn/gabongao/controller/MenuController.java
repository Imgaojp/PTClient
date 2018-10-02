package cn.gabongao.controller;

import cn.gabongao.Context;
import cn.gabongao.model.Info;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import javax.annotation.PostConstruct;
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
 * Created by Imgaojp on 2018/9/1.
 */
public class MenuController extends AbstractRegisterController implements Initializable {

    @FXML
    private Button hide;
    @FXML
    private Button info;
    @FXML
    private Button browser;
    @FXML
    private Button search;
    @FXML
    private Button settings;
    @FXML
    private Button snapshot;
    @FXML
    private Button discuss;

    @FXML
    private Button refresh;

    @FXML
    private Button help;

    @FXML
    private Label test;

    private InfoPageController infoPageController = ((InfoPageController) Context.controllers.get("InfoPageController"));
    private SearchPageController searchPageController = ((SearchPageController) Context.controllers.get("SearchPageController"));
    private RootController rootController = (RootController) Context.controllers.get("RootController");
    private HelpPageController helpPageController = (HelpPageController) Context.controllers.get("HelpPageController");

    private TableColumn<Info, String> userName;
    private TableColumn<Info, String> userID;
    private TableColumn<Info, String> inviteCount;

    private boolean isHide = false;

    @FXML
    public void update() {
        ((InfoPageController) Context.controllers.get("InfoPageController")).update();
    }

    @PostConstruct
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        register();

        info.setOnAction(event -> {

            if (rootController == null) {
                infoPageController = ((InfoPageController) Context.controllers.get("InfoPageController"));
                searchPageController = ((SearchPageController) Context.controllers.get("SearchPageController"));
                rootController = (RootController) Context.controllers.get("RootController");
                helpPageController = (HelpPageController) Context.controllers.get("HelpPageController");
            }
            rootController.getSearchPage().setVisible(false);
            rootController.getInfoPage().setVisible(true);
            rootController.getBrowserPage().setVisible(false);
            rootController.getHelpPage().setVisible(false);
        });

        browser.setOnAction(event -> {
            if (rootController == null) {
                infoPageController = ((InfoPageController) Context.controllers.get("InfoPageController"));
                searchPageController = ((SearchPageController) Context.controllers.get("SearchPageController"));
                rootController = (RootController) Context.controllers.get("RootController");
                helpPageController = (HelpPageController) Context.controllers.get("HelpPageController");

            }
            rootController.getBrowserPage().setVisible(true);
            rootController.getSearchPage().setVisible(false);
            rootController.getInfoPage().setVisible(false);
            rootController.getHelpPage().setVisible(false);


        });

        search.setOnAction((ActionEvent event) -> {
            if (rootController == null) {
                infoPageController = ((InfoPageController) Context.controllers.get("InfoPageController"));
                searchPageController = ((SearchPageController) Context.controllers.get("SearchPageController"));
                rootController = (RootController) Context.controllers.get("RootController");
                helpPageController = (HelpPageController) Context.controllers.get("HelpPageController");

            }
            rootController.getSearchPage().setVisible(true);
            rootController.getInfoPage().setVisible(false);
            rootController.getBrowserPage().setVisible(false);
            rootController.getHelpPage().setVisible(false);
            searchPageController.getKeyword().requestFocus();
        });
        help.setOnAction((ActionEvent event) -> {
            if (rootController == null) {
                infoPageController = ((InfoPageController) Context.controllers.get("InfoPageController"));
                searchPageController = ((SearchPageController) Context.controllers.get("SearchPageController"));
                rootController = (RootController) Context.controllers.get("RootController");
                helpPageController = (HelpPageController) Context.controllers.get("HelpPageController");

            }
            rootController.getSearchPage().setVisible(false);
            rootController.getInfoPage().setVisible(false);
            rootController.getBrowserPage().setVisible(false);
            rootController.getHelpPage().setVisible(true);
        });

        hide.setOnAction((ActionEvent event) -> {

            if (userName == null) {
                userName = ((InfoPageController) Context.controllers.get("InfoPageController")).getUserName();
                userID = ((InfoPageController) Context.controllers.get("InfoPageController")).getUserID();
                inviteCount = ((InfoPageController) Context.controllers.get("InfoPageController")).getInviteCount();
            }

            if (isHide) {
                isHide = false;
                hide.setText("Hide");
                userName.setVisible(true);
                inviteCount.setVisible(true);
                userID.setVisible(true);
                hide.setStyle("-fx-background-image: url('/img/hide.png')");
            } else {
                isHide = true;
                hide.setText("Show");
                userName.setVisible(false);
                inviteCount.setVisible(false);
                userID.setVisible(false);
                hide.setStyle("-fx-background-image: url('/img/show.png')");
            }

        });

        snapshot.setOnAction(event -> {
            ((RootController) Context.controllers.get("RootController")).snapShot();
        });

        settings.setOnAction((ActionEvent event) -> {
            if (rootController == null) {
                infoPageController = ((InfoPageController) Context.controllers.get("InfoPageController"));
                searchPageController = ((SearchPageController) Context.controllers.get("SearchPageController"));
                rootController = (RootController) Context.controllers.get("RootController");
                helpPageController = (HelpPageController) Context.controllers.get("HelpPageController");

            }
            rootController.getSearchPage().setVisible(false);
            rootController.getInfoPage().setVisible(false);
            rootController.getBrowserPage().setVisible(true);
            rootController.getHelpPage().setVisible(false);


        });

        discuss.setOnAction((ActionEvent event) -> {
            if (rootController == null) {
                infoPageController = ((InfoPageController) Context.controllers.get("InfoPageController"));
                searchPageController = ((SearchPageController) Context.controllers.get("SearchPageController"));
                rootController = (RootController) Context.controllers.get("RootController");
                helpPageController = (HelpPageController) Context.controllers.get("HelpPageController");

            }
            rootController.getSearchPage().setVisible(false);
            rootController.getInfoPage().setVisible(false);
            rootController.getBrowserPage().setVisible(true);
            rootController.getHelpPage().setVisible(false);


        });



    }
}
