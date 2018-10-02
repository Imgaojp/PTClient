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
 * Created by Imgaojp on 2018/9/2.
 */
public class RecentInfo {
    private final StringProperty site;
    private final StringProperty upload;
    private final StringProperty download;
    private final StringProperty shareRatio;
    private final StringProperty bonus;
    private final StringProperty uploadCount;
    private final StringProperty uploadTime;
    private final StringProperty date;


    public RecentInfo() {
        this(null, null, null, null, null, null, null, null);
    }

    public RecentInfo(String site, String upload, String download, String shareRatio, String bonus, String uploadCount, String uploadSize, String date) {
        this.site = new SimpleStringProperty(site);
        this.upload = new SimpleStringProperty(upload);
        this.download = new SimpleStringProperty(download);
        this.shareRatio = new SimpleStringProperty(shareRatio);
        this.bonus = new SimpleStringProperty(bonus);
        this.uploadCount = new SimpleStringProperty(uploadCount);
        this.uploadTime = new SimpleStringProperty(uploadSize);
        this.date = new SimpleStringProperty(date);
    }

    @Override
    public String toString() {
        return "RecentInfo{" +
                "site=" + site +
                ", upload=" + upload +
                ", download=" + download +
                ", shareRatio=" + shareRatio +
                ", bonus=" + bonus +
                ", uploadCount=" + uploadCount +
                ", uploadTime=" + uploadTime +
                ", date=" + date +
                '}';
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

    public String getUpload() {
        return upload.get();
    }

    public void setUpload(String upload) {
        this.upload.set(upload);
    }

    public StringProperty uploadProperty() {
        return upload;
    }

    public String getDownload() {
        return download.get();
    }

    public void setDownload(String download) {
        this.download.set(download);
    }

    public StringProperty downloadProperty() {
        return download;
    }

    public String getShareRatio() {
        return shareRatio.get();
    }

    public void setShareRatio(String shareRatio) {
        this.shareRatio.set(shareRatio);
    }

    public StringProperty shareRatioProperty() {
        return shareRatio;
    }

    public String getBonus() {
        return bonus.get();
    }

    public void setBonus(String bonus) {
        this.bonus.set(bonus);
    }

    public StringProperty bonusProperty() {
        return bonus;
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

    public String getUploadTime() {
        return uploadTime.get();
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime.set(uploadTime);
    }

    public StringProperty uploadTimeProperty() {
        return uploadTime;
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
}
