/**
 * Created by adliano on 11/4/17.
 * CS142 Fall 2017
 * HW4
 * XML program to Read a XML file
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLOne extends XMLUtils
{
    public static void main(String[] args)
    {
        try
        {
            Document w3cDoc = getW3CDocument("staff.xml");
            w3cDoc.getDocumentElement().normalize();
            // Print Root Element
            println("Root Element : "+w3cDoc.getDocumentElement().getNodeName());
            // Get the another Elements
            NodeList nodeList = w3cDoc.getElementsByTagName("staff");

            for(int i=0;i<nodeList.getLength();i++)
            {
                Node node = nodeList.item(i);
                println("Current Element : "+node.getNodeName());

                println("--------------------------------------");
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element el = (Element)node;
                    println("Staff id = "+el.getAttribute("id"));
                    println("First Name : "+el.getElementsByTagName("first_name").item(0).getTextContent());
                    println("Last Name : "+el.getElementsByTagName("last_name").item(0).getTextContent());
                    println("Nick Name : "+el.getElementsByTagName("nick_name").item(0).getTextContent());
                    println("Salary : "+el.getElementsByTagName("salary").item(0).getTextContent());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
