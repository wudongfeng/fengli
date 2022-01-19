package com.example.zw.fengli.util;


import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;

/**
 * 参考教程：https://www.cnblogs.com/hongwz/p/6245874.html
 */
public class PdfMergeUtil {
    private static String[] getFiles(String folder) throws IOException {
        File _folder = new File(folder);
        String[] filesInFolder;

        if(_folder.isDirectory()){
            filesInFolder = _folder.list();
            return filesInFolder;
        } else {
            throw new IOException("Path is not a directory");
        }
    }

    public static void main(String[] args) throws Exception {

        //pdf合并工具类
        PDFMergerUtility mergePdf = new PDFMergerUtility();

        String folder = "/Users/wudongfeng/Desktop/01丨基础平台篇 (21讲)";
        String destinationFileName = "mergedTestAAAAAAAAAA.pdf";

        String[] filesInFolder = getFiles(folder);

        for(int i = 0; i < filesInFolder.length; i++){
            //循环添加要合并的pdf存放的路径
            mergePdf.addSource(folder + File.separator + filesInFolder[i]);
        }

        //设置合并生成pdf文件名称
        mergePdf.setDestinationFileName(folder + File.separator + destinationFileName);
        //合并pdf
        mergePdf.mergeDocuments();
    }
}
