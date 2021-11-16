package xpathfb8ypq1109;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class xPathFB8YPQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	         File inputFile = new File("studentFB8YPQ.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder;

	         dBuilder = dbFactory.newDocumentBuilder();

	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();

	         XPath xPath =  XPathFactory.newInstance().newXPath();
	         
	         System.out.println("------------------------");
	         System.out.println("1)");
	         String expression = "/class/student";	        
	         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
	            doc, XPathConstants.NODESET);

	         writeDatas(nodeList);
	         
	         
	         System.out.println("------------------------");
	         System.out.println("2)");
	         String expression2 = "/class/student[@id = '1']";
	         NodeList nodeList2 = (NodeList) xPath.compile(expression2).evaluate(
	            doc, XPathConstants.NODESET);
	         writeDatas(nodeList2);
	         
	         System.out.println("------------------------");
	         System.out.println("3):");
	         String expression3 = "//student";	        
	         NodeList nodeList3 = (NodeList) xPath.compile(expression3).evaluate(
	            doc, XPathConstants.NODESET);
	         writeDatas(nodeList3);
	         
	         
	         System.out.println("------------------------");
	         System.out.println("4)");
	         String expression4 = "/class/student[2]";
	         NodeList nodeList4 = (NodeList) xPath.compile(expression4).evaluate(
	            doc, XPathConstants.NODESET);
	         writeDatas(nodeList4);
	         
	         System.out.println("------------------------");
	         System.out.println("5)");
	         String expression5 = "/class/student[last()]";
	         NodeList nodeList5 = (NodeList) xPath.compile(expression5).evaluate(
	            doc, XPathConstants.NODESET);
	         writeDatas(nodeList5);
	         
	         System.out.println("------------------------");
	         System.out.println("6)");
	         String expression6 = "/class/student[last()-1]";
	         NodeList nodeList6 = (NodeList) xPath.compile(expression6).evaluate(
	            doc, XPathConstants.NODESET);
	         writeDatas(nodeList6);
	         
	         System.out.println("------------------------");
	         System.out.println("7)");
	         for (int i = 1; i < 3; i++) {
		         String expression7 = "/class/student[" + i + "]";
		         NodeList nodeList7 = (NodeList) xPath.compile(expression7).evaluate(
		            doc, XPathConstants.NODESET);
		         writeDatas(nodeList7);
			}
	         
	         
	         System.out.println("------------------------");
	         System.out.println("8)");
	         String expression8 = "/class/*";
	         NodeList nodeList8 = (NodeList) xPath.compile(expression8).evaluate(
	            doc, XPathConstants.NODESET);
	         writeDatas(nodeList8);
	         
	         
	         System.out.println("------------------------");
	         System.out.println("9)");
	         String expression9 = "/class/student[@*]";
	         NodeList nodeList9 = (NodeList) xPath.compile(expression9).evaluate(
	            doc, XPathConstants.NODESET);
	         writeDatas(nodeList9);
	         
	         System.out.println("------------------------");
	         System.out.println("10)");
	         String expression10 = "/*/*";
	         NodeList nodeList10 = (NodeList) xPath.compile(expression10).evaluate(
	            doc, XPathConstants.NODESET);
	         writeDatas(nodeList10);
	         
	         System.out.println("------------------------");
	         System.out.println("11)");
	         String expression11 = "/class/student[kor > 20]";
	         NodeList nodeList11 = (NodeList) xPath.compile(expression11).evaluate(
	            doc, XPathConstants.NODESET);
	         writeDatas(nodeList11);
	         
	         System.out.println("------------------------");
	         System.out.println("12)");
	         String expression12 = "/class/student[keresztnev]";
	         NodeList nodeList12 = (NodeList) xPath.compile(expression12).evaluate(
	            doc, XPathConstants.NODESET);
	         writeDatas(nodeList12);
	      } catch (ParserConfigurationException e) {
	         e.printStackTrace();
	      } catch (SAXException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (XPathExpressionException e) {
	         e.printStackTrace();
	      }
	}
	
	public static void writeDatas(NodeList nodeList) {
		for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("Student id : " + eElement.getAttribute("id"));
               System.out.println("Keresztnév : " 
                  + eElement
                  .getElementsByTagName("keresztnev")
                  .item(0)
                  .getTextContent());
               System.out.println("Vezetéknév : " 
                  + eElement
                  .getElementsByTagName("vezeteknev")
                  .item(0)
                  .getTextContent());
               System.out.println("Becenév : " 
                  + eElement
                  .getElementsByTagName("becenev")
                  .item(0)
                  .getTextContent());
               System.out.println("Kor : " 
                  + eElement
                  .getElementsByTagName("kor")
                  .item(0)
                  .getTextContent());
            }
         }
	}

}
