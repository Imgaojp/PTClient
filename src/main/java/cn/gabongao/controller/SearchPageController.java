package cn.gabongao.controller;

import cn.gabongao.Context;
import cn.gabongao.Main;
import cn.gabongao.PTSite.RSSList;
import cn.gabongao.PTSite.Searcher;
import cn.gabongao.dao.InfoDao;
import cn.gabongao.model.Info;
import cn.gabongao.model.RSSItem;
import cn.gabongao.model.SearchResult;
import cn.gabongao.utils.FileSizeUtils;
import cn.gabongao.utils.downloader.HttpClientDownloader;
import cn.gabongao.utils.entity.Request;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
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
@Controller
public class SearchPageController extends AbstractRegisterController implements Initializable {

    @Autowired
    private Searcher searcher;

    @FXML
    private TableView<SearchResult> table;

    @FXML
    private TableColumn<SearchResult, String> site;

    @FXML
    private TableColumn<SearchResult, String> name;
    @FXML
    private TableColumn<SearchResult, String> date;
    @FXML
    private TableColumn<SearchResult, String> size;
    @FXML
    private TableColumn<SearchResult, String> discount;
    @FXML
    private TableColumn<SearchResult, String> uploadCount;
    @FXML
    private TableColumn<SearchResult, String> downloadCount;
    @FXML
    private TableColumn<SearchResult, String> downloaded;
    @FXML
    private TableColumn<SearchResult, String> cat;
    @FXML
    private TextField keyword;
    @FXML
    private Button searchButton;
    private CloseableHttpClient client = HttpClients.createDefault();
    @Autowired
    private HttpClientDownloader downloader;
    @FXML
    private ObservableList<SearchResult> searchData = FXCollections.observableArrayList();

    public TextField getKeyword() {
        return keyword;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        register();

        site.setCellValueFactory(cellData -> cellData.getValue().siteProperty());
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        size.setCellValueFactory(cellData -> cellData.getValue().sizeProperty());
        discount.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
        uploadCount.setCellValueFactory(cellData -> cellData.getValue().uploadCountProperty());
        downloadCount.setCellValueFactory(cellData -> cellData.getValue().downloadCountProperty());
        downloaded.setCellValueFactory(cellData -> cellData.getValue().downloadedProperty());
        cat.setCellValueFactory(cellData -> cellData.getValue().catProperty());

        table.setItems(searchData);

        table.setRowFactory(tv -> {
            TableRow<SearchResult> row = new TableRow<>();

            //on double click
            row.setOnMouseClicked(event -> {
                SearchResult item = row.getItem();
                if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY && (!row.isEmpty())) {

                    System.out.println(item.getUrl());
                    //todo

                }

            });

            //on right click
            final ContextMenu rowMenu = new ContextMenu();
            MenuItem openItem = new MenuItem("打开页面");
            openItem.setOnAction(event -> {
                SearchResult item = row.getItem();
                System.out.println(item.getUrl());
            });

            MenuItem downloadItem = new MenuItem("下载");
            downloadItem.setOnAction(event -> {
                SearchResult item = row.getItem();

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("保存种子");
                fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
                fileChooser.setInitialFileName(item.getName().replaceAll("/", " ") + ".torrent");
                File file = fileChooser.showSaveDialog(new Stage());
                if (file != null) {
                    Main.executor.submit(() -> {
                        if (downloader == null) {
                            downloader = Context.ac.getBean(HttpClientDownloader.class);
                        }
                        byte[] raw = downloader.downloadRaw(new Request(item.getDownloadUrl()));
                        downloader.downloadRaw(new Request(item.getDownloadUrl()));
                        if (raw != null) {
                            try {
                                FileUtils.writeByteArrayToFile(file, raw);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        Platform.runLater(() -> Notifications.create()
                                .title("下载种子")
                                .text(item.getName() + " 下载完成")
                                .graphic(null)
                                .hideAfter(Duration.seconds(2))
                                .position(Pos.CENTER)
                                .hideCloseButton()
//                                .darkStyle()
                                .showInformation());
                    });


                }
            });

            MenuItem copyItem = new MenuItem("复制原文链接");
            copyItem.setOnAction(event -> {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                SearchResult item = row.getItem();
                ClipboardContent content = new ClipboardContent();
                content.putString(item.getUrl());
                clipboard.setContent(content);
            });

            MenuItem copyDownloadItem = new MenuItem("复制种子链接");
            copyDownloadItem.setOnAction(event -> {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                SearchResult item = row.getItem();
                ClipboardContent content = new ClipboardContent();
                content.putString(item.getDownloadUrl());
                clipboard.setContent(content);
            });

            MenuItem rssItem = new MenuItem("添加到本地RSS");
            rssItem.setOnAction(event -> {
                SearchResult item = row.getItem();
                RSSItem rssItem1 = new RSSItem();
                rssItem1.setLink(item.getUrl().replaceAll("&hit=\\d*", ""));
                rssItem1.setTitle(item.getName());

                try {
                    URL url = new URL(item.getDownloadUrl());
                    String host = url.getHost();
                    rssItem1.setUrl(item.getDownloadUrl() + "&amp;passkey=" + Context.urlPasskeyMap.get(host));
                } catch (MalformedURLException e) {
                    rssItem1.setUrl(item.getDownloadUrl());
                }

                rssItem1.setDate(item.getDate());
                RSSList.addToRSS(rssItem1);
            });


            rowMenu.getItems().addAll(openItem, downloadItem, rssItem, copyItem, copyDownloadItem);

            row.contextMenuProperty().bind(
                    Bindings.when(Bindings.isNotNull(row.itemProperty()))
                            .then(rowMenu).otherwise(new ContextMenu()));


            return row;
        });

        size.setComparator((o1, o2) -> {
            double d1 = FileSizeUtils.convertToMB(o1);
            double d2 = FileSizeUtils.convertToMB(o2);
            return (int) (d2 - d1);
        });

        uploadCount.setComparator(Comparator.comparingInt(o -> (Integer.parseInt(o))));
        downloaded.setComparator(Comparator.comparingInt(o -> (Integer.parseInt(o))));
        downloadCount.setComparator(Comparator.comparingInt(o -> (Integer.parseInt(o))));

        searchButton.setOnAction(event -> {
            search();

        });

        keyword.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                search();
            }
        });
    }


    private void search() {
        String word = keyword.getText().trim().replaceAll("\\s+", "+");
        searchData.clear();
        if (searcher == null) {
            searcher = Context.ac.getBean(Searcher.class);
        }

        List<Info> infoList = Context.ac.getBean(InfoDao.class).getAll();
        for (Info i :
                infoList) {
            Main.executor.submit(() -> {
                List<SearchResult> searchResult = searcher.search(i.getSite(), word, i.getCookie());
                if (searchResult != null) {
                    searchData.addAll(searchResult);
                }
            });
        }
    }

}
