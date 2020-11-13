package com.warriorg.pdf.box.util;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author warrior
 */
public class PdfUtil {
    private static PDFont FONT = PDType1Font.HELVETICA;
    private static  float FONT_SIZE = 10;
    private static final float LEADING = -1.5f * FONT_SIZE;

    /**
     * 增加一段文本
     * @param contentStream
     * @param width
     * @param sx
     * @param sy
     * @param text
     * @param justify
     * @throws IOException
     */
    private static void addParagraph(PDPageContentStream contentStream, float width, float sx,
                                     float sy, String text, boolean justify) throws IOException {
        List<String> lines = new ArrayList<>();
        parseLinesRecursive(text, width, lines);

        contentStream.setFont(FONT, FONT_SIZE);
        contentStream.newLineAtOffset(sx, sy);
        for (String line: lines) {
            float charSpacing = 0;
            if (justify){
                if (line.length() > 1) {
                    float size = FONT_SIZE * FONT.getStringWidth(line) / 1000;
                    float free = width - size;
                    if (free > 0 && !lines.get(lines.size() - 1).equals(line)) {
                        charSpacing = free / (line.length() - 1);
                    }
                }
            }
            contentStream.setCharacterSpacing(charSpacing);
            contentStream.showText(line);
            contentStream.newLineAtOffset(0, LEADING);
        }
    }

    /**
     * 递归分析文本，并按宽度分割成N行
     * @param text
     * @param width
     * @param lines
     * @return
     * @throws IOException
     */
    private static List<String> parseLinesRecursive(String text, float width, List<String> lines) throws IOException {
        String tmpText = text;
        for (int i=0; i<text.length(); i++) {
            tmpText = text.substring(0, text.length() - i);

            float realWidth = FONT_SIZE * FONT.getStringWidth(tmpText) / 1000;

            if (realWidth > width) {
                continue;
            } else {
                lines.add(tmpText);

                if (0 != i) {
                    parseLinesRecursive(text.substring(text.length() - i), width, lines);
                }

                break;
            }
        }

        return lines;
    }
}
