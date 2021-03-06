package org.jeecgframework.poi.html;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelToHtmlUtil;
import org.jeecgframework.poi.util.PoiPublicUtil;
import org.junit.Test;

public class ExcelToHtmlUtilTest {

    @Test
    public void testToTableHtmlWorkbook() {
        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream(new File(PoiPublicUtil
                .getWebRootPath("org/jeecgframework/poi/test/excel/doc/专项支出用款申请书.xls"))));
            String html = ExcelToHtmlUtil.toTableHtml(wb);
            FileWriter fw = new FileWriter("D:/excel/专项支出用款申请书_table.html");
            fw.write(html);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToTableHtmlWorkbookInt() {
        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream(new File(PoiPublicUtil
                .getWebRootPath("org/jeecgframework/poi/test/excel/doc/exportTemp.xls"))));
            String html = ExcelToHtmlUtil.toTableHtml(wb, 1);
            FileWriter fw = new FileWriter("D:/excel/exportTemp_table.html");
            fw.write(html);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToAllHtmlWorkbookAndImage() {

        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream(new File("D:/excel/tt.xls")));
            //            Workbook wb = new HSSFWorkbook(new FileInputStream(
            //                new File(
            //                    PoiPublicUtil
            //                    .getWebRootPath("org/jeecgframework/poi/test/excel/doc/专项支出用款申请书.xls"))));
            long d = System.nanoTime();
            String html = ExcelToHtmlUtil.toAllHtml(wb, "D:/excel/");
            FileWriter fw = new FileWriter("D:/excel/专项支出用款申请书_all.html");
            fw.write(html);
            fw.close();

            System.err.println(System.nanoTime() - d);
            d = System.nanoTime();
            html = ExcelToHtmlUtil.toAllHtml(wb, "D:/excel/");
            fw = new FileWriter("D:/excel/专项支出用款申请书_all_cache.html");
            fw.write(html);
            fw.close();
            System.err.println(System.nanoTime() - d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToAllHtmlWorkbook() {

        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream(new File("D:/excel/tt.xls")));
            //            Workbook wb = new HSSFWorkbook(new FileInputStream(
            //                new File(
            //                    PoiPublicUtil
            //                    .getWebRootPath("org/jeecgframework/poi/test/excel/doc/专项支出用款申请书.xls"))));
            String html = ExcelToHtmlUtil.toAllHtml(wb);
            FileWriter fw = new FileWriter("D:/excel/专项支出用款申请书_all.html");
            fw.write(html);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToAllHtmlWorkbookInt() {
        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream(new File(PoiPublicUtil
                .getWebRootPath("org/jeecgframework/poi/test/excel/doc/exportTemp.xls"))));
            String html = ExcelToHtmlUtil.toAllHtml(wb, 1);
            FileWriter fw = new FileWriter("D:/excel/exportTemp_all.html");
            fw.write(html);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
