package api.other;

import javafx.scene.control.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class excelToCsv {
    public static void main(String[] args) throws InterruptedException {
        xlsToCsv("hourglass");
    }
    /*
     * xls转换为csv文件
     */
    public static void xlsToCsv(String caseName) {
        String buffer = "";
        try {
            String fileName = "D:\\testFile\\"+caseName +".xls";
            File file = new File(fileName);
            // 设置读文件编码
            WorkbookSettings setEncode = new WorkbookSettings();
            setEncode.setEncoding("GB2312");
            // 从文件流中获取Excel工作区对象（WorkBook）
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sheet = wb.getSheet(0);
            for (int i = 0; i < sheet.getRows(); i++) {
                for (int j = 0; j < sheet.getColumns(); j++) {
                    jxl.Cell cell = sheet.getCell(j, i);
                    buffer += cell.getContents().replaceAll("\n", "") + ",";
                }
                buffer = buffer.substring(0, buffer.lastIndexOf(","))
                        .toString();
                buffer += "\n";
            }
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // write the string into the file
        //默认路径：D:\Progrom Files\apache-jmeter-3.1\bin
        String savePath = "D:\\testFile\\"+caseName +".csv";
        File saveCSV = new File(savePath);
        try {
            if (!saveCSV.exists())
                saveCSV.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveCSV));
            writer.write(buffer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
