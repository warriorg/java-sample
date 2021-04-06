package com.warriorg.pdf.box;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author warrior
 */
public class EntryDemo {
    private static PDFont FONT = PDType1Font.HELVETICA;
    private static PDFont FONT_BOLD = PDType1Font.HELVETICA_BOLD;

    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();

        // 297 210
        PDPage page = new PDPage(new PDRectangle(0, 0, PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
        doc.addPage(page);

        InputStream inFont = PDFBoxDemo.class.getClassLoader().getResourceAsStream("MSYH.ttf");
        PDType0Font font = PDType0Font.load(doc, inFont);
        FONT = font;

        InputStream inFontBold = PDFBoxDemo.class.getClassLoader().getResourceAsStream("MSYHBD.ttf");
        PDType0Font fontBold = PDType0Font.load(doc, inFontBold);
        FONT_BOLD = fontBold;


        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        contentStream.setFont(FONT, 12);
        PDRectangle rect = page.getBBox();

        // 绘制4边
        int left = 36;
        int topSpace = 87;
        float bottom = 37;
        int width = (int)rect.getWidth();
        int height = (int)rect.getHeight();

        drawFirstPageBorder(contentStream, width, height);
        drawText(contentStream, "中华人民共和国海关进口报关单", 290, height - 36 - 10, FONT_BOLD, 18);
        drawHead(contentStream, left, height, topSpace);

        int ty =  height - topSpace - 138 - 46 - 9;
        drawBodyHeader(contentStream, left, ty);
        ty = height - topSpace - 138 - 46 - 21;

        int tx = left + 2;
        drawText(contentStream, "1", tx, ty);
        tx = left + 25;
        drawText(contentStream, "8098989871", tx, ty);
        tx = left + 80;
        drawText(contentStream, "晶体管晶片(客供免费)", tx, ty);
        drawText(contentStream, "4|3|耗散功率:≥1瓦|ON牌|DT6NSD065DD38AAIEA-WDQ等", tx, ty - 10);

        int rightTx = width - left - 375 - left;
        drawTextAlignRight(contentStream, "24千克", rightTx,  ty);
        drawTextAlignRight(contentStream, "1000", rightTx, ty - 10);

        rightTx = width - left - 280 - left;
        drawTextAlignRight(contentStream, "7.5470", rightTx,  ty);
        drawTextAlignRight(contentStream, "113205.0000", rightTx, ty - 10);
        drawTextAlignRight(contentStream, "日本元", rightTx, ty - 20);

        contentStream.close();

        doc.save(System.getProperty("user.dir") + "/test.pdf");
        doc.close();
    }

    static int getTextWidth(String text, PDFont font, int fontSize) throws IOException {
        return (int) (fontSize * font.getStringWidth(text) / 1000);
    }

    static void drawTitleValue (PDPageContentStream contentStream, String title, String value, int tx, int ty) throws IOException {
        drawText(contentStream, title, tx, ty, FONT_BOLD, 8);
        drawText(contentStream, value, tx +  getTextWidth(title, FONT_BOLD, 8), ty - 1, FONT, 8);
    }

    static void drawTextAlignRight(PDPageContentStream contentStream, String text, int rightTx, int ty) throws IOException {
        int tx = rightTx - getTextWidth(text, FONT, 8);
        drawText(contentStream, text, tx, ty);
    }

    static void drawText(PDPageContentStream contentStream, String text, int tx, int ty) throws IOException {
       drawText(contentStream, text, tx, ty, FONT, 8);
    }

    static void drawText(PDPageContentStream contentStream, String text, int tx, int ty, PDFont font) throws IOException {
        drawText(contentStream, text, tx, ty, font, 8);
    }

    static void drawText(PDPageContentStream contentStream, String text, int tx, int ty, PDFont font, int fontSize) throws IOException {
        contentStream.beginText();
        contentStream.newLineAtOffset(tx , ty);
        contentStream.setFont(font, fontSize);
        contentStream.showText(text);
        contentStream.endText();
    }

    static void drawBody(PDPageContentStream contentStream, int left,  int ty) throws IOException {
        int tx = left + 4;
        drawText(contentStream, "1", tx, ty);
        tx = left + 35;
        drawText(contentStream, "商品编号", tx, ty, FONT_BOLD);
        tx = left + 190;
        drawText(contentStream, "商品名称及规格型号", tx, ty, FONT_BOLD);
        tx = left + 310;
        drawText(contentStream, "数量及单位", tx, ty, FONT_BOLD);
        tx = left + 395;
        drawText(contentStream, "单价/总价/币制", tx, ty, FONT_BOLD);
        tx = left + 478;
        drawText(contentStream, "原产地(地区)", tx, ty, FONT_BOLD);
        tx = left + 542;
        drawText(contentStream, "最终目的国(地区)", tx, ty, FONT_BOLD);
        tx = left + 650;
        drawText(contentStream, "境内目的地", tx, ty, FONT_BOLD);
        tx = left + 735;
        drawText(contentStream, "征免", tx, ty, FONT_BOLD);
    }

    static void drawBodyHeader(PDPageContentStream contentStream, int left,  int ty) throws IOException {
        int tx = left + 4;
        drawText(contentStream, "项号", tx, ty, FONT_BOLD);
        tx = left + 35;
        drawText(contentStream, "商品编号", tx, ty, FONT_BOLD);
        tx = left + 190;
        drawText(contentStream, "商品名称及规格型号", tx, ty, FONT_BOLD);
        tx = left + 310;
        drawText(contentStream, "数量及单位", tx, ty, FONT_BOLD);
        tx = left + 395;
        drawText(contentStream, "单价/总价/币制", tx, ty, FONT_BOLD);
        tx = left + 478;
        drawText(contentStream, "原产地(地区)", tx, ty, FONT_BOLD);
        tx = left + 542;
        drawText(contentStream, "最终目的国(地区)", tx, ty, FONT_BOLD);
        tx = left + 650;
        drawText(contentStream, "境内目的地", tx, ty, FONT_BOLD);
        tx = left + 735;
        drawText(contentStream, "征免", tx, ty, FONT_BOLD);
    }

    static void drawHead(PDPageContentStream contentStream, int left, int height, int topSpace) throws IOException {
        int ty = height - 80;
        int tx = left + 4;
        drawTitleValue(contentStream, "预录入编号：", "212342342342342342", tx, ty);
        drawTitleValue(contentStream, "海关编号：", "222520191000153457", 260, ty);
        drawText(contentStream, "(外港海关)", 410, ty);
        drawTitleValue(contentStream, "页码/页数：", "1/1", 748, ty);

        ty = height - topSpace - 9;
        drawTitleValue(contentStream, "境内收货人", "（913301007654812994）", tx, ty);
        drawText(contentStream, "松下家电(中国)有限公司", tx, ty - 10);

        tx = tx + 220;
        drawTitleValue(contentStream, "进境关别", "（2225）", tx, ty);
        drawText(contentStream, "外港海关", tx, ty - 10);


        tx = left + 346 + 4;
        drawText(contentStream, "进口日期", tx, ty, FONT_BOLD);
        drawText(contentStream, "20190608", tx, ty - 10);

        tx = left + 480 + 4;
        drawText(contentStream, "申报日期", tx, ty, FONT_BOLD);
        drawText(contentStream, "20190608", tx, ty - 10);

        tx = left + 600 + 4;
        drawText(contentStream, "备案号", tx, ty, FONT_BOLD);
        drawText(contentStream, "E290919A0001", tx, ty - 10);

        ty = ty - 23 - 1;
        tx = left + 4;
        drawText(contentStream, "境外发货人", tx, ty, FONT_BOLD);
        drawText(contentStream, "PANASONIC PROCUREMENT(CHINA).CO.,LTD", tx, ty - 10);

        tx = tx + 220;
        drawTitleValue(contentStream, "运输方式", "（2）", tx, ty);
        drawText(contentStream, "水路运输", tx, ty - 10);

        tx = left + 346 + 4;
        drawText(contentStream, "运输工具名称及航次号", tx, ty, FONT_BOLD);
        drawText(contentStream, "HALCYON/335W", tx, ty - 10);

        tx = left + 480 + 4;
        drawText(contentStream, "提运单号", tx, ty, FONT_BOLD);
        drawText(contentStream, "PASU5140455830", tx, ty - 10);

        tx = left + 600 + 4;
        drawText(contentStream, "货物存放地点", tx, ty, FONT_BOLD);
        drawText(contentStream, "外五", tx, ty - 10);


        ty = ty - 23;
        tx = left + 4;
        drawTitleValue(contentStream, "消费使用单位", "（913301007654812994）", tx, ty);
        drawText(contentStream, "松下家电(中国)有限公司", tx, ty - 10);

        tx = tx + 220;
        drawTitleValue(contentStream, "监管方式", "（0615）", tx, ty);
        drawText(contentStream, "进料对口", tx, ty - 10);

        tx = left + 346 + 4;
        drawTitleValue(contentStream, "征免性质","（503）", tx, ty);
        drawText(contentStream, "进料加工", tx, ty - 10);

        tx = left + 480 + 4;
        drawText(contentStream, "许可证号", tx, ty, FONT_BOLD);
        drawText(contentStream, "", tx, ty - 10);

        tx = left + 600 + 4;
        drawTitleValue(contentStream, "启运港", "（JPN213）", tx, ty);
        drawText(contentStream, "神户(日本)", tx, ty - 10);

        ty = ty - 23;
        tx = left + 4;
        drawText(contentStream, "合同协议号", tx, ty, FONT_BOLD);
        drawText(contentStream, "8H21BUA01844", tx, ty - 10);

        tx = tx + 220;
        drawTitleValue(contentStream, "贸易国(地区)", "（CHN）", tx, ty);
        drawText(contentStream, "中国", tx, ty - 10);

        tx = left + 346 + 4;
        drawTitleValue(contentStream, "启运国(地区)","（JPN）", tx, ty);
        drawText(contentStream, "日本", tx, ty - 10);

        tx = left + 480 + 4;
        drawTitleValue(contentStream, "经停港","（JPN213）", tx, ty);
        drawText(contentStream, "神户(日本)", tx, ty - 10);

        tx = left + 600 + 4;
        drawTitleValue(contentStream, "入境口岸", "（310701）", tx, ty);
        drawText(contentStream, "外高桥", tx, ty - 10);

        ty = ty - 23;
        tx = left + 4;
        drawTitleValue(contentStream, "包装种类", "（99）", tx, ty);
        drawText(contentStream, "其他包装", tx, ty - 10);

        tx = tx + 220;
        drawText(contentStream, "件数", tx, ty, FONT_BOLD);
        drawText(contentStream, "6", tx, ty - 10);

        tx = left + 265 + 4;
        drawText(contentStream, "毛重(千克)", tx, ty, FONT_BOLD);
        drawText(contentStream, "2101.64", tx, ty - 10);

        tx = left + 346 + 4;
        drawText(contentStream, "净重(千克)", tx, ty, FONT_BOLD);
        drawText(contentStream, "2101.64", tx, ty - 10);

        tx = left + 400 + 4;
        drawTitleValue(contentStream, "成交方式", "（1）", tx, ty);
        drawText(contentStream, "2CIF", tx, ty - 10);

        tx = left + 480 + 4;
        drawText(contentStream, "运费", tx, ty, FONT_BOLD);
        drawText(contentStream, "", tx, ty - 10);

        tx = left + 570 + 4;
        drawText(contentStream, "保费", tx, ty, FONT_BOLD);
        drawText(contentStream, "", tx, ty - 10);

        tx = left + 662 + 4;
        drawText(contentStream, "杂费", tx, ty, FONT_BOLD);
        drawText(contentStream, "", tx, ty - 10);

        ty = ty - 23;
        tx = left + 4;
        drawText(contentStream, "随附单证及编号",  tx, ty, FONT_BOLD);
        drawText(contentStream, "保税核注清单:QD231419I000024655", tx, ty - 10);

        ty = ty - 23;
        tx = left + 4;
        drawText(contentStream, "标记唛码及备注",  tx, ty, FONT_BOLD);
        drawText(contentStream, "备注:共6拼 N/M 集装箱标箱数及号码:1;FCIU5071178;", tx, ty - 10);
    }

    private static void drawPageBorder(PDPageContentStream contentStream, int left, int top, int right, int bottom) throws IOException {
        contentStream.moveTo(left, top);
        contentStream.lineTo(right, top);
        contentStream.lineTo(right, bottom);
        contentStream.lineTo(left, bottom);
        contentStream.lineTo(left, top);
    }

    private static void drawFirstPageBorder(PDPageContentStream contentStream, int width, int height) throws IOException {
        int left = 36;
        int right = width - left;
        int topSpace = 87;
        int bottom = 37;
        contentStream.setLineWidth(1);

        drawPageBorder(contentStream, left, height - topSpace, right, bottom);

        // rowHeight = 23
        int top = height - topSpace;

        for (int i = 1; i < 7; i++) {
            int rowHeight = 23 * i;
            contentStream.moveTo(left, top - rowHeight);
            contentStream.lineTo(right, top - rowHeight);
        }

        int top4RowY = top - 23 * 4;
        contentStream.moveTo(left + 220, top);
        contentStream.lineTo(left + 220, top4RowY);

        contentStream.moveTo(left + 346, top);
        contentStream.lineTo(left + 346, top4RowY);

        contentStream.moveTo(left + 480, top);
        contentStream.lineTo(left + 480, top4RowY);

        contentStream.moveTo(left + 600, top);
        contentStream.lineTo(left + 600, top4RowY);

        contentStream.moveTo(left + 220, top4RowY);
        contentStream.lineTo(left + 220, top4RowY - 23);

        contentStream.moveTo(left + 265, top4RowY);
        contentStream.lineTo(left + 265, top4RowY - 23);

        contentStream.moveTo(left + 346, top4RowY);
        contentStream.lineTo(left + 346, top4RowY - 23);

        contentStream.moveTo(left + 400, top4RowY);
        contentStream.lineTo(left + 400, top4RowY - 23);

        contentStream.moveTo(left + 480, top4RowY);
        contentStream.lineTo(left + 480, top4RowY - 23);

        contentStream.moveTo(left + 570, top4RowY);
        contentStream.lineTo(left + 570, top4RowY - 23);
        contentStream.moveTo(left + 662, top4RowY);
        contentStream.lineTo(left + 662, top4RowY - 23);

        // 23 * 6 - 46
        top = top - 138 - 46;
        contentStream.moveTo(left, top);
        contentStream.lineTo(right, top);

        top = top - 13;
        contentStream.moveTo(left, top);
        contentStream.lineTo(right, top);
        contentStream.stroke();

        for (int i = 1; i < 7; i++) {
            int rowHeight = 33 * i;
            contentStream.moveTo(left, top - rowHeight);
            contentStream.lineTo(right, top - rowHeight);
        }
        contentStream.setLineDashPattern(new float[]{1}, 0);
        contentStream.stroke();
        contentStream.setLineDashPattern(new float[]{}, 0);

        // 33 * 6 - 22
        top = top - 198 - 22;
        contentStream.moveTo(left, top);
        contentStream.lineTo(right, top);

        contentStream.moveTo(left + 526, top);
        contentStream.lineTo(left + 526, bottom);
        contentStream.stroke();
    }

}
