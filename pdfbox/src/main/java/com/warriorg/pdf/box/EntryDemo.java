package com.warriorg.pdf.box;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author warrior
 */
public class EntryDemo {
    private static PDFont FONT = PDType1Font.HELVETICA;

    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();

        // 297 210
        PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
        doc.addPage(page);

        InputStream inFont = PDFBoxDemo.class.getClassLoader().getResourceAsStream("simfang.ttf");
        PDType0Font font = PDType0Font.load(doc, inFont);
        FONT = font;

        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        contentStream.setFont(FONT, 12);
        PDRectangle rect = page.getBBox();

        contentStream.setLineWidth(0.5f);
        contentStream.moveTo(rect.getLowerLeftX() + 20, rect.getUpperRightY() - 20);
        contentStream.lineTo(rect.getUpperRightX() - 20, rect.getUpperRightY() - 20);

        contentStream.moveTo(rect.getUpperRightX() - 20, rect.getLowerLeftY() + 20);
        contentStream.lineTo(rect.getUpperRightX() - 20, rect.getUpperRightY() - 20);

        contentStream.moveTo(rect.getLowerLeftX() + 20, rect.getLowerLeftY() + 20);
        contentStream.lineTo(rect.getLowerLeftX() + 20, rect.getUpperRightY() - 20);

        contentStream.moveTo(rect.getLowerLeftX() + 20, rect.getLowerLeftY() + 20);
        contentStream.lineTo(rect.getUpperRightX() - 20, rect.getLowerLeftY() + 20);
//        contentStream.stroke();
        contentStream.fillAndStroke();




//        contentStream.beginText();
//        contentStream.newLineAtOffset(10, 10);
//
//        contentStream.showText("中国dsfdskljflsdjkflsdjflsdj中国史蒂夫收到了房价快速的了解中国dsfdskljflsdjkflsdjflsdj中国史蒂夫收到了房价快速的了解,中国dsfdskljflsdjkflsdjflsdj中国史蒂夫收到了房价快速的了解,中国dsfdskljflsdjkflsdjflsdj中国史蒂夫收到了房价快速的了解");
//        contentStream.endText();

        contentStream.close();

        doc.save(System.getProperty("user.dir") + "/pdfbox/test.pdf");
        doc.close();
    }
}
