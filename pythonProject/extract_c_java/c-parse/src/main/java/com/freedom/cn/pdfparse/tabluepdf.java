package com.freedom.cn.pdfparse;


import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.*;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class tabluepdf {

    public static void main(String[] args) {
        tabPdf();
    }


    public static void tabPdf() {
        String pdfPath = "/home/liming/code/python/pythonProject/report/600006_20240831_FBS5.pdf"; // 替换为您的 PDF 文件路径

        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
            SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();
            Page page = new ObjectExtractor(document).extract(4);
            List<Table> tables = sea.extract(page);
            for(Table table: tables) {
                List<List<RectangularTextContainer>> rows = table.getRows();
                // iterate over the rows of the table
                for (List<RectangularTextContainer> cells : rows) {
                    // print all column-cells of the row plus linefeed
                    for (RectangularTextContainer content : cells) {
                        // Note: Cell.getText() uses \r to concat text chunks
                        String text = content.getText().replace("\r", " ");
                        System.out.print(text + "|");
                    }
                    System.out.println();
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}