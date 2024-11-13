package com.freedom.cn.pdfparse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import technology.tabula.*;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class pdfparse {

    public static void main(String[] args) {

    }

    public void pdfBox(){
        String pdfPath = "/home/liming/code/python/pythonProject/report/600006_20240831_FBS5.pdf"; // 替换为您的 PDF 文件路径

        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            System.out.println(text); // 打印提取的文本
            // 进一步处理提取的文本以识别表格
            String[] lines = text.split("\n");
            for (String line : lines) {
                // 简单处理来识别表格行
                System.out.println("Row: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
