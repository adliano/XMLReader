/**
 * Created by adliano on 11/1/17.
 * CS142 Fall 2017
 * HW4
 * XML program to Read a XML file
 * XMLUtils.java
 * class that will hold all useful methods
 */

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

class XMLUtils
{
    /**
     * ****************************** getW3CDocument() ************************
     *
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
     * ********************* println() ***********************
     *
     * @param str String to be displayed
     */
    static void println(String str)
    {
        System.out.println(str);
    }

    /**
     * ********************** print() *************************
     *
     * @param str String to be displayed
     */
    private static void print(String str)
    {
        System.out.print(str);
    }

    /**
     * *********************** printNodes() ***************************
     * Method to print Nodes
     * @param nodeList List with XML node data
     */
    static void printNodes(NodeList nodeList)
    {
        for(int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                println("Element : " + node.getNodeName());

                // Check for available Attributes and print it
                NamedNodeMap attMap = element.getAttributes();
                StringBuilder strAttributes = new StringBuilder("Attributes : ");
                // loop tru the attributes and print it on a single line
                for(int j = 0; j < attMap.getLength(); j++)
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
                            print("Element : " + child.getNodeName() + "\t");
                            println("Value : " + child.getTextContent());
                        }
                    }
                }
            }

        }
    }

    /**
     * *************** visitChildNodes() **********************
     * Method to print all Child Nodes if available
     * @param nodeList List with the XML Node Data
     */
    static void visitChildNodes(NodeList nodeList)
    {
        for(int i = 0; i < nodeList.getLength(); i++)
        {
            Node childNode = nodeList.item(i);

            switch(childNode.getNodeType())
            {
                case Node.ELEMENT_NODE:
                    println(childNode.getNodeName());
                    printAttributes(childNode);
                    break;
                case Node.TEXT_NODE:
                    println(childNode.getTextContent().trim());
                    break;
            }

            if(childNode.hasChildNodes()) visitChildNodes(childNode.getChildNodes());
        }
    }

    /** ************************* printAttributes() *******************************
     * Method to print available attributes on a given Node
     * @param node node that may have attributes
     */
    private static void printAttributes(Node node)
    {
        NamedNodeMap nodeMap = node.getAttributes();

        for(int j = 0; j < nodeMap.getLength(); j++)
        {
            println(nodeMap.item(j).getNodeName() + "=" + nodeMap.item(j).getTextContent());
        }
    }
}
//END