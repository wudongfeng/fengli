package com.example.zw.fengli.util;


import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * Description:
 *
 * @Author wudongfeng wudongfeng@baidu.com
 * @Date 2022/1/18 9:41 AM
 * @Version 0.0.1
 */
public class SplitFileUtil {
    private static final String originPath = "/Volumes/Seagate Backup Plus Drive/极客时间";
    private static final String targetPath = "/Volumes/Seagate Backup Plus Drive/极客时间-html";

    public static void main(String[] args) throws Exception {
        File originFile = new File(originPath);
        doCopyFile(originFile);
    }

    public static void doCopyFile(File file) throws Exception {
        /**
         * 如果是文件的话，才进行处理
         * 注意，本方法只适用于是两级的类型，例如：课程/课节/具体的课件
         */
        if (file.isFile()) {

            /**
             * 要进行复制的文件类型
             */
            if (!file.getName().contains(".html")) {
                return;
            }
            // 课节文件
            File parentFile = file.getParentFile();
            // 课程文件
            File grandFatherFile = parentFile.getParentFile();

            // 新的课程文件路径
            String newGrandFatherPath = targetPath + "/" + grandFatherFile.getName();
            // 新的课节文件路径
            String newParentFilePath = newGrandFatherPath + "/" + parentFile.getName();

            // 创建新的课程文件及课节文件
            FileUtils.forceMkdir(new File(newGrandFatherPath));
            FileUtils.forceMkdir(new File(newParentFilePath));

            // 复制文件到新的目录中
            FileUtils.copyFile(file, new File(newParentFilePath + "/" + file.getName()));

        }
        /**
         * 如果是文件夹，依次重新遍历即可
         */
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File childFile : files) {
                doCopyFile(childFile);
            }
        }
    }
}
