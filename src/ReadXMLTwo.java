/**
 * Created by adliano on 11/5/17.
 * CS142 Fall 2017
 * HW4
 * ReadXMLTwo.java
 * XML program to Read a XML file
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ReadXMLTwo extends XMLUtils
{
    public static void main(String[] args)
    {
        try
        {
            Document w3cDoc = getW3CDocument("staff.xml");
            Element element = w3cDoc.getDocumentElement();

            println("Root Element : "+element.getNodeName());

            element.normalize();

            if(w3cDoc.hasChildNodes()) printNodes(element.getChildNodes());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
