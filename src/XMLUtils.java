import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by adliano on 11/1/17.
 *
 */

class XMLUtils
{
    /**
     * @param fileName input file name
     * @return org.w3c.dom.Document
     * @throws ParserConfigurationException by newDocumentBuilder()
     * @throws IOException                  by documentBuilder.parse()
     * @throws SAXException                 by documentBuilder.parse()
     */
    static Document getW3CDocument(String fileName)
            throws ParserConfigurationException, IOException, SAXException
    {
        return (DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(new File(fileName)));
    }

    /**
     * @param str String to be displayed
     */
    static void println(String str)
    {
        System.out.println(str);
    }

    /**
     * @param str String to be displayed
     */
    static void print(String str)
    {
        System.out.print(str);
    }

    /**
     * @param nodeList List with XML node data
     */
    static void printNodes(NodeList nodeList)
    {
        for(int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE )
            {
                Element element = (Element)node;

                println("Element : "+node.getNodeName());

                // Check for available Attributes and print it
                NamedNodeMap attMap = element.getAttributes();
                StringBuilder strAttributes = new StringBuilder("Attributes : ");
                // loop tru the attributes and print it on a single line
                for(int j=0; j < attMap.getLength(); j++)
                {
                    strAttributes.append(attMap.item(j).getNodeName())
                            .append("=")
                            .append(attMap.item(j).getTextContent())
                            .append("\t");
                }
                println(String.valueOf(strAttributes));
                // check if the Node has children elements
                if(node.hasChildNodes())
                {
                    NodeList childNodes = node.getChildNodes();
                    for(int c = 0; c < childNodes.getLength(); c++)
                    {
                        Node child = childNodes.item(c);
                        if(child.getNodeType() == Node.ELEMENT_NODE)
                        {
                            print("Element : "+child.getNodeName()+"\t");
                            println("Value : "+child.getTextContent());
                        }
                    }
                }
            }

        }
    }
}
//END