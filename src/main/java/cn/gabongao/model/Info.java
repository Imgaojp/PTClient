package cn.gabongao.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class Info {
    private final StringProperty site;             //站点名称
    private final StringProperty url;               //url
    private final StringProperty cookie;               //cookie
    private final StringProperty userName;         //用户名
    private final StringProperty userID;         //用户ID
    private final StringProperty upload;            //上传量
    private final StringProperty download;          //下载量
    private final StringProperty shareRatio;        //分享率
    private final StringProperty bonus;             //魔力值
    private final StringProperty uploadCount;     //做种数
    private final StringProperty uploadSize;     //做种体积
    private final StringProperty uploadTime;      //做种时间
    private final StringProperty downloadTime;    //下载时间
    private final StringProperty joinDate;        //加入天数
    private final StringProperty grade;            //等级
    private final StringProperty inviteCount;     //邀请数
    private final StringProperty state;           //当前状态
    private final StringProperty passkey;

    public Info() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }


    public Info(String site, String url, String cookie, String userName, String userID, String upload, String download, String shareRatio, String bonus, String uploadCount, String uploadSize, String uploadTime, String downloadTime, String joinDate, String grade, String inviteCount, String state, String passkey) {
        this.site = new SimpleStringProperty(site);
        this.url = new SimpleStringProperty(url);
        this.cookie = new SimpleStringProperty(cookie);
        this.userName = new SimpleStringProperty(userName);
        this.userID = new SimpleStringProperty(userID);
        this.uploadCount = new SimpleStringProperty(uploadCount);
        this.uploadSize = new SimpleStringProperty(uploadSize);
        this.inviteCount = new SimpleStringProperty(inviteCount);
        this.joinDate = new SimpleStringProperty(joinDate);
        this.shareRatio = new SimpleStringProperty(shareRatio);
        this.upload = new SimpleStringProperty(upload);
        this.download = new SimpleStringProperty(download);
        this.uploadTime = new SimpleStringProperty(uploadTime);
        this.downloadTime = new SimpleStringProperty(downloadTime);
        this.grade = new SimpleStringProperty(grade);
        this.bonus = new SimpleStringProperty(bonus);
        this.state = new SimpleStringProperty(state);
        this.passkey = new SimpleStringProperty(passkey);
    }

    public String getPasskey() {
        return passkey.get();
    }

    public void setPasskey(String passkey) {
        this.passkey.set(passkey);
    }

    public StringProperty passkeyProperty() {
        return passkey;
    }

    public String getUploadSize() {
        return uploadSize.get();
    }

    public void setUploadSize(String uploadSize) {
        this.uploadSize.set(uploadSize);
    }

    public StringProperty uploadSizeProperty() {
        return uploadSize;
    }

    public String getUserID() {
        return userID.get();
    }

    public void setUserID(String userID) {
        this.userID.set(userID);
    }

    public StringProperty userIDProperty() {
        return userID;
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

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public StringProperty userNameProperty() {
        return userName;
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

    public String getInviteCount() {
        return inviteCount.get();
    }

    public void setInviteCount(String inviteCount) {
        this.inviteCount.set(inviteCount);
    }

    public StringProperty inviteCountProperty() {
        return inviteCount;
    }

    public String getJoinDate() {
        return joinDate.get();
    }

    public void setJoinDate(String joinDate) {
        this.joinDate.set(joinDate);
    }

    public StringProperty joinDateProperty() {
        return joinDate;
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

    public String getUploadTime() {
        return uploadTime.get();
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime.set(uploadTime);
    }

    public StringProperty uploadTimeProperty() {
        return uploadTime;
    }

    public String getDownloadTime() {
        return downloadTime.get();
    }

    public void setDownloadTime(String downloadTime) {
        this.downloadTime.set(downloadTime);
    }

    public StringProperty downloadTimeProperty() {
        return downloadTime;
    }

    public String getGrade() {
        return grade.get();
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public StringProperty gradeProperty() {
        return grade;
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

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public StringProperty stateProperty() {
        return state;
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

    public String getCookie() {
        return cookie.get();
    }

    public void setCookie(String cookie) {
        this.cookie.set(cookie);
    }

    public StringProperty cookieProperty() {
        return cookie;
    }

    public RecentInfo buildRecentInfo() {
        RecentInfo recentInfo = new RecentInfo();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        recentInfo.setSite(this.getSite());
        recentInfo.setBonus(this.getBonus());
        recentInfo.setDate(simpleDateFormat.format(new Date()));
        recentInfo.setDownload(this.getDownload());
        recentInfo.setShareRatio(this.getShareRatio());
        recentInfo.setUpload(this.getUpload());
        recentInfo.setUploadCount(this.getUploadCount());
        recentInfo.setUploadTime(this.getUploadTime());

        return recentInfo;
    }

    @Override
    public String toString() {
        return "Info{" +
                "site=" + site +
                ", url=" + url +
                ", cookie=" + cookie +
                ", userName=" + userName +
                ", userID=" + userID +
                ", upload=" + upload +
                ", download=" + download +
                ", shareRatio=" + shareRatio +
                ", bonus=" + bonus +
                ", uploadCount=" + uploadCount +
                ", uploadSize=" + uploadSize +
                ", uploadTime=" + uploadTime +
                ", downloadTime=" + downloadTime +
                ", joinDate=" + joinDate +
                ", grade=" + grade +
                ", inviteCount=" + inviteCount +
                ", state=" + state +
                ", passkey=" + passkey +
                '}';
    }
}
