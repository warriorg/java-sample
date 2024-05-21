package me.warriorg.jackson;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class JacksonXmlTest {

    @Test
    public void whenUsingXmlMapper_thenXMLRootName()
            throws IOException, ParserConfigurationException, SAXException, XMLStreamException, JDOMException {
        String xmlString = "<?xml version='1.0' encoding='utf-8'?>\n"
                + "<DEC_RESULT><CUS_CIQ_NO>I20240001243258893</CUS_CIQ_NO><ENTRY_ID>900120241000000851</ENTRY_ID><NOTICE_DATE>2024-04-17T09:15:03</NOTICE_DATE><CHANNEL>K</CHANNEL><NOTE>报关单担保放行</NOTE><CUSTOM_MASTER>9001</CUSTOM_MASTER><I_E_DATE>20240417</I_E_DATE><D_DATE>2024-04-17T00:00:00</D_DATE></DEC_RESULT>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
        Element root = doc.getDocumentElement();
        System.out.println(root.getNodeName());

        SAXBuilder saxBuilder = new SAXBuilder();
        org.jdom2.Document document = saxBuilder.build(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
        org.jdom2.Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
    }

}
