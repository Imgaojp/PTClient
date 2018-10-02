package cn.gabongao.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
public class SearchResult {
    private StringProperty site;
    private StringProperty name;
    private StringProperty date;
    private StringProperty size;
    private StringProperty discount;
    private StringProperty uploadCount;
    private StringProperty downloadCount;
    private StringProperty downloaded;

    private StringProperty url;
    private StringProperty downloadUrl;
    private StringProperty cat;

    public SearchResult() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public SearchResult(String site, String name, String date, String size, String discount, String uploadCount, String downloadCount, String downloaded, String url, String downloadUrl, String cat) {
        this.site = new SimpleStringProperty(site);
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
        this.size = new SimpleStringProperty(size);
        this.discount = new SimpleStringProperty(discount);
        this.uploadCount = new SimpleStringProperty(uploadCount);
        this.downloadCount = new SimpleStringProperty(downloadCount);
        this.downloaded = new SimpleStringProperty(downloaded);
        this.url = new SimpleStringProperty(url);
        this.downloadUrl = new SimpleStringProperty(downloadUrl);
        this.cat = new SimpleStringProperty(cat);
    }

    public String getCat() {
        return cat.get();
    }

    public void setCat(String cat) {
        this.cat.set(cat);
    }

    public StringProperty catProperty() {
        return cat;
    }

    public String getUrl() {
        return url.get();
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public StringProperty urlProperty() {
        return url;
    }

    public String getDownloadUrl() {
        return downloadUrl.get();
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl.set(downloadUrl);
    }

    public StringProperty downloadUrlProperty() {
        return downloadUrl;
    }

    public String getDiscount() {
        return discount.get();
    }

    public void setDiscount(String discount) {
        this.discount.set(discount);
    }

    public StringProperty discountProperty() {
        return discount;
    }

    public String getSite() {
        return site.get();
    }

    public void setSite(String site) {
        this.site.set(site);
    }

    public StringProperty siteProperty() {
        return site;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getSize() {
        return size.get();
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public String getUploadCount() {
        return uploadCount.get();
    }

    public void setUploadCount(String uploadCount) {
        this.uploadCount.set(uploadCount);
    }

    public StringProperty uploadCountProperty() {
        return uploadCount;
    }

    public String getDownloadCount() {
        return downloadCount.get();
    }

    public void setDownloadCount(String downloadCount) {
        this.downloadCount.set(downloadCount);
    }

    public StringProperty downloadCountProperty() {
        return downloadCount;
    }

    public String getDownloaded() {
        return downloaded.get();
    }

    public void setDownloaded(String downloaded) {
        this.downloaded.set(downloaded);
    }

    public StringProperty downloadedProperty() {
        return downloaded;
    }
}
