package jvm;

import java.text.DecimalFormat;

/**
 * @Author: zl
 * @Date: 2019/9/14 10:59
 */
public class HeapSize {
    public static void main(String[] args) {
        long l = Runtime.getRuntime().maxMemory();
        System.out.println(l);
        System.out.println("maxMemory:" + FormetFileSize(l));
        System.out.println("totalMemory:" + FormetFileSize(Runtime.getRuntime().totalMemory()));
        System.out.println("freeMemory:" + FormetFileSize(Runtime.getRuntime().freeMemory()));
    }
    public static String FormetFileSize(long file) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (file < 1024) {
            fileSizeString = df.format((double) file) + "B";
        } else if (file < 1048576) {
            fileSizeString = df.format((double) file / 1024) + "K";
        } else if (file < 1073741824) {
            fileSizeString = df.format((double) file / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) file / 1073741824) + "G";
        }
        return fileSizeString;
    }
}
