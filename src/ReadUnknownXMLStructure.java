/**
 * Created by adliano on 11/5/17.
 * CS142 Fall 2017
 * HW4
 * ReadUnknownXMLStructure.java
 * XML program to Read any XML file
 */

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ReadUnknownXMLStructure extends XMLUtils
{
    public static void main(String[] args)
            throws IOException, SAXException, ParserConfigurationException
    {
        Document w3cDocument = getW3CDocument("staff_three.xml");
        w3cDocument.getDocumentElement().normalize();
        NodeList nodeList = w3cDocument.getElementsByTagName("staff");
        visitChildNodes(nodeList);
    }
}
