package cn.gabongao.utils;

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
 * Created by Imgaojp on 2018/9/27.
 */
public class FileSizeUtils {
    public static Double convertToMB(String size) {
        double aDouble = 1d;
        size = size.toLowerCase().replace((char) 12288, ' ').replaceAll("[\\u00A0]+", "");
        if (size.contains("tb")) {
            String tb = size.replaceAll("tb", "").replaceAll("\\s+", "");
            aDouble = aDouble * Double.valueOf(tb) * 1024 * 1024;
        } else if (size.contains("gb")) {
            String tb = size.replaceAll("gb", "").replaceAll("\\s+", "");
            aDouble = aDouble * Double.valueOf(tb) * 1024;
        } else if (size.contains("kb")) {
            String tb = size.replaceAll("kb", "").replaceAll("\\s+", "");
            aDouble = aDouble * Double.valueOf(tb) / 1024;
        } else if (size.contains("pb")) {
            String tb = size.replaceAll("pb", "").replaceAll("\\s+", "");
            aDouble = aDouble * Double.valueOf(tb) * 1024 * 1024 * 1024;
        }
        return aDouble;
    }

    public static Double convertToGB(String size) {
        return convertToMB(size) / 1024;
    }

    public static Double convertToTB(String size) {
        return convertToGB(size) / 1024;
    }
}
