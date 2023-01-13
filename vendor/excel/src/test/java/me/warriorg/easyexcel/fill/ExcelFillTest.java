package me.warriorg.easyexcel.fill;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import me.warriorg.model.BookHead;
import me.warriorg.model.BookList;
import me.warriorg.util.TestFileUtil;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

/**
 * @author gao shiyong
 * @since 2022/12/13 16:54
 */
public class ExcelFillTest {

    @Test
    public void compositeFill() throws IOException {
        String templateFileName = TestFileUtil.getPath() + "resources" + File.separator + "fill.xlsx";
        String stamp = TestFileUtil.getPath() + "resources" + File.separator + "stamp.png";
        String fileName = TestFileUtil.getPath() + "compositeFill" + System.currentTimeMillis() + ".xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            BookHead head = getHead();
            excelWriter.fill(head, writeSheet);
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            excelWriter.fill(new FillWrapper("list", head.getList()), fillConfig, writeSheet);

        }


        Workbook workbook = new XSSFWorkbook(fileName);
        Sheet sheet = workbook.getSheetAt(0);
        insertImageToCell(workbook, sheet, stamp);
        fileName = TestFileUtil.getPath() + "fill" + System.currentTimeMillis() + ".xlsx";
        try (OutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        }
    }


    /**
     * This Method loads the image from application resource and insert into the
     * Cell
     */
    private static void insertImageToCell(Workbook workbook, Sheet sheet, String imageName) throws IOException {
        try (final FileInputStream stream = new FileInputStream(imageName)) {
            byte[] inputImageBytes = IOUtils.toByteArray(stream);
            final CreationHelper helper = workbook.getCreationHelper();
            final Drawing drawing = sheet.createDrawingPatriarch();
            final ClientAnchor anchor = helper.createClientAnchor();
            anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
            anchor.setCol1(10);
            anchor.setRow1(16); // same row is okay

            int inputImagePictureID = workbook.addPicture(inputImageBytes, Workbook.PICTURE_TYPE_PNG);
            final Picture pict = drawing.createPicture(anchor, inputImagePictureID);
            pict.resize();
        }
    }

    private BookHead getHead() {
        BookHead head = new BookHead();
        head.setDate("20221213");
        head.setNo("NO20221213");
        head.setInvoiceNo("I20221213");

        BookList list1 = new BookList();
        list1.setSerialNo("1");
        list1.setMaterialNo("AA123456");

        BookList list2 = new BookList();
        list2.setSerialNo("2");
        list2.setMaterialNo("AA1234567");

        BookList list3 = new BookList();
        list3.setSerialNo("3");
        list3.setMaterialNo("AA12345673");

        BookList list4 = new BookList();
        list4.setSerialNo("4");
        list4.setMaterialNo("AA14345674");

        BookList list5 = new BookList();
        list5.setSerialNo("5");
        list5.setMaterialNo("AA1534567");

        BookList list6 = new BookList();
        list6.setSerialNo("6");
        list6.setMaterialNo("AA1634567");
        head.setList(List.of(list1, list2, list3, list4, list5, list6));

        return head;
    }

}
