package cn.gabongao.model;

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
 * Created by Imgaojp on 2018/9/7.
 */
public class Rule {

    private String site;
    private String baseUrl;
    private String baseRule;
    private String detailRule;
    private String bonusRule;

    public Rule() {
    }

    public String getTimeIndex() {
        return timeIndex;
    }

    private String timeIndex;
    private String gradeRule;
    private Integer isHttpOnly;
    private String searchUrl;
    private String searchMethod;
    private String updateMethod;

    public Rule(String site, String baseUrl, String baseRule, String detailRule, String bonusRule, String timeIndex, String gradeRule, Integer isHttpOnly, String searchUrl, String searchMethod, String updateMethod) {
        this.site = site;
        this.baseUrl = baseUrl;
        this.baseRule = baseRule;
        this.detailRule = detailRule;
        this.bonusRule = bonusRule;
        this.timeIndex = timeIndex;
        this.gradeRule = gradeRule;
        this.isHttpOnly = isHttpOnly;
        this.searchUrl = searchUrl;
        this.searchMethod = searchMethod;
        this.updateMethod = updateMethod;
    }

    public void setTimeIndex(String timeIndex) {
        this.timeIndex = timeIndex;
    }



    public String getUpdateMethod() {
        return updateMethod;
    }

    public void setUpdateMethod(String updateMethod) {
        this.updateMethod = updateMethod;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public String getSearchMethod() {
        return searchMethod;
    }

    public void setSearchMethod(String searchMethod) {
        this.searchMethod = searchMethod;
    }

    public Integer getIsHttpOnly() {
        return isHttpOnly;
    }

    public void setIsHttpOnly(Integer isHttpOnly) {
        this.isHttpOnly = isHttpOnly;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseRule() {
        return baseRule;
    }

    public void setBaseRule(String baseRule) {
        this.baseRule = baseRule;
    }

    public String getGradeRule() {
        return gradeRule;
    }

    public void setGradeRule(String gradeRule) {
        this.gradeRule = gradeRule;
    }

    public String getDetailRule() {
        return detailRule;
    }

    public void setDetailRule(String detailRule) {
        this.detailRule = detailRule;
    }

    public String getBonusRule() {
        return bonusRule;
    }

    public void setBonusRule(String bonusRule) {
        this.bonusRule = bonusRule;
    }

    @Override
    public String toString() {
        return "{" +
                "\"site=\": \"" + site + "\"," +
                "\"baseUrl=\": \"" + baseUrl + "\"," +
                "\"baseRule=\": \"" + baseRule + "\"," +
                "\"detailRule=\": \"" + detailRule + "\"," +
                "\"bonusRule=\": \"" + bonusRule.replace("\"", "\\\"") + "\"," +
                "\"timeIndex=\": \"" + timeIndex + "\"," +
                "\"gradeRule=\": \"" + gradeRule + "\"," +
                "\"isHttpOnly=\": \"" + isHttpOnly + "\"," +
                "\"searchUrl=\": \"" + searchUrl + "\"," +
                "\"searchMethod=\": \"" + searchMethod + "\"," +
                "\"updateMethod=\": \"" + updateMethod + "\"" +
                '}';
    }
}
