package cn.gabongao.utils;

import cn.gabongao.model.RecentInfo;

import java.util.ArrayList;
import java.util.List;

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
 * Created by Imgaojp on 2018/10/2.
 */
public class EchartsUtils {
    public static String renderChartHtml(List<String> data, List<String> uploadData, List<String> downloadData, List<String> bonus) {
        String standard = "<!DOCTYPE html>\n" +
                "<html style=\"height: 100%\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <style>\n" +
                "        .left {\n" +
                "            text-align: center;\n" +
                "            float: left;\n" +
                "            width: 50%;\n" +
                "        }\n" +
                "\n" +
                "        .right {\n" +
                "            text-align: center;\n" +
                "            float: right;\n" +
                "            width: 50%;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style=\"height: 100%; margin: 0\">\n" +
                "<div id=\"container\" class=\"left\" style=\"height: 100%\"></div>\n" +
                "<div id=\"container2\" class=\"right\" style=\"height: 100%\"></div>\n" +
                "<script type=\"text/javascript\" src=\"http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "    var dom = document.getElementById(\"container\");\n" +
                "    var myChart = echarts.init(dom, null, {renderer: 'svg'});\n" +
                "    var app = {};\n" +
                "    option = null;\n" +
                "    option = {\n" +
                "        title: {\n" +
                "            text: '上传/下载量(TB)'\n," +
                "        textStyle:{\n" +
                "　　　　 fontSize:12\n" +
                "        }" +
                "        },\n" +
                "        tooltip: {\n" +
                "            trigger: 'axis'\n" +
                "        },\n" +
                "        legend: {\n" +
                "            data: ['上传量', '下载量']\n" +
                "        },\n" +
                "        grid: {\n" +
                "            left: '8%',\n" +
                "            right: '8%',\n" +
                "            bottom: '5%',\n" +
                "            containLabel: true\n" +
                "        },\n" +
                "        toolbox: {},\n" +
                "        xAxis: {\n" +
                "            type: 'category',\n" +
                "            boundaryGap: false,\n" +
                "data: " + data +
                "        },\n" +
                "        yAxis: {\n" +
                "            type: 'value'\n" +
                "        },\n" +

                "        series: [\n" +
                "            {\n" +
                "                name: '上传量',\n" +
                "                type: 'line',\n" +
                "data: " + uploadData + "  ,\n" +
                "                smooth: true\n" +
                "            },\n" +
                "            {\n" +
                "                name: '下载量',\n" +
                "                type: 'line',\n" +
                "data: " + downloadData + "  ,\n" +
                "                smooth: true\n" +
                "            }\n" +
                "        ]\n" +
                "    };\n" +
                "    ;\n" +
                "    if (option && typeof option === \"object\") {\n" +
                "        myChart.setOption(option, true);\n" +
                "    }\n" +
                "</script>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "    var dom = document.getElementById(\"container2\");\n" +
                "    var myChart = echarts.init(dom, null, {renderer: 'svg'});\n" +
                "    var app = {};\n" +
                "    option = null;\n" +
                "    option = {\n" +
                "        title: {\n" +
                "            text: '魔力值'\n," +
                "        textStyle:{\n" +
                "　　　　 fontSize:12\n" +
                "        }" +
                "        },\n" +
                "        xAxis: {\n" +
                "            type: 'category',\n" +
                "            data: " + data + "\n" +
                "        },\n" +
                "        tooltip: {\n" +
                "            trigger: 'axis'\n" +
                "        },\n" +
                "        yAxis: {\n" +
                "            type: 'value'\n" +
                "        },\n" +
                "        grid: {\n" +
                "            left: '8%',\n" +
                "            right: '8%',\n" +
                "            bottom: '5%',\n" +
                "            containLabel: true\n" +
                "        },\n" +
                "        series: [{\n" +
                "            data: " + bonus + ",\n " +
                "            type: 'line',\n" +
                "            smooth: true\n" +
                "        }]\n" +
                "    };\n" +
                "    if (option && typeof option === \"object\") {\n" +
                "        myChart.setOption(option, true);\n" +
                "    }\n" +
                "</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return standard;
    }

    public static String render(List<RecentInfo> recentInfos) {
        List<String> uploadData = parseRecentUploadData(recentInfos);
        List<String> downloadData = parseRecentDownloadData(recentInfos);
        List<String> bonusData = parseRecentBonusData(recentInfos);
        List<String> dateData = parseRecentDateData(recentInfos);
        return renderChartHtml(dateData, uploadData, downloadData, bonusData);
    }

    public static List<String> parseRecentDateData(List<RecentInfo> recentInfos) {
        List<String> result = new ArrayList<>();

        for (RecentInfo recent :
                recentInfos) {
            result.add("'" + recent.getDate() + "'");
        }
        return result;
    }

    public static List<String> parseRecentBonusData(List<RecentInfo> recentInfos) {
        List<String> result = new ArrayList<>();

        for (RecentInfo recent :
                recentInfos) {
            result.add(recent.getBonus());
        }
        return result;
    }

    public static List<String> parseRecentDownloadData(List<RecentInfo> recentInfos) {
        List<String> result = new ArrayList<>();

        for (RecentInfo recent :
                recentInfos) {
            result.add(parseTBGB(recent.getDownload()));
        }
        return result;
    }

    public static List<String> parseRecentUploadData(List<RecentInfo> recentInfos) {
        List<String> result = new ArrayList<>();

        for (RecentInfo recent :
                recentInfos) {
            result.add(parseTBGB(recent.getUpload()));
        }
        return result;
    }

    private static String parseTBGB(String upload) {
        double ans = 0;
        if (upload.toUpperCase().endsWith("TB")) {
            ans = Double.valueOf(upload.toUpperCase().replaceAll("TB", "").trim());
        } else if (upload.toUpperCase().endsWith("GB")) {
            ans = Double.valueOf(upload.toUpperCase().replaceAll("GB", "").trim()) / 1024;
        } else if (upload.toUpperCase().endsWith("MB")) {
            ans = Double.valueOf(upload.toUpperCase().replaceAll("MB", "").trim()) / 1024 / 1024;
        } else if (upload.toUpperCase().endsWith("KB")) {
            ans = Double.valueOf(upload.toUpperCase().replaceAll("KB", "").trim()) / 1024 / 1024 / 1024;
        }

        return String.format("%.3f", ans);
    }

}
