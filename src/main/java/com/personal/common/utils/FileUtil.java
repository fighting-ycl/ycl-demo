package com.personal.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class FileUtil {
    public static void writeMessage(String path, String msg) {
        try {
            File file = new File(path);

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(path, true);
            fw.append(msg + "\r\n");

            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    //1493203147340095
    public static String getFileName() {
        long l = System.currentTimeMillis();
        Random random = new Random();
        String s = String.format("%06d", random.nextInt(1000000));
        return l + s;
    }

    public static String getFolderName(String filename) {
        StringBuffer folderName = new StringBuffer();
        if (StringUtils.isNotBlank(filename)) {
            String name = filename.substring(filename.length() - 4);
            folderName.append(name.substring(2)).append("/").append(name.substring(0, 2));
        }
        return folderName.toString();
    }

    public static String getFileExtension(String filename) {
        String extension = "";
        if (StringUtils.isNotBlank(filename)) {
            extension = filename.substring(filename.lastIndexOf(".") + 1);
        }
        return extension;
    }

    public static void main(String[] args) throws Exception {
//		String path = "/Users/HONGZHEN/Downloads/images.json";
//		String msg = "3个人";
//		writeMessage(path, msg);
        String aa = "http://thirdwx.qlogo.cn/mmopen/vi_32/Dmc5xial2OBdaVqKuTNQpwP5SXJOe9hPw5yPgvggicnTA9j8KiaXulH5m67bUkRxv4dSA5Ec3Yzl7Oog0W8icWck2A/132";
        String name = FileUtil.getFileName();
        String folderName = FileUtil.getFolderName(name);
        String resultFileName = name + ".jpg";
        System.out.println(resultFileName);
    }
}
