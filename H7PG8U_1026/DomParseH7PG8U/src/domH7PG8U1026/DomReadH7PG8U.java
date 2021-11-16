package domfb8ypq1026;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomReadFB8YPQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File xmlFile = new File("usersFB8YPQ.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Személyek lekérdezése: ");
			System.out.println("Root element: "+ doc.getDocumentElement().getNodeName());
			ReadCurrentElement(doc);
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(SAXException sae) {
			sae.printStackTrace();
		}
	}
	
	public static void ReadCurrentElement(Document doc) {
		NodeList nList = doc.getElementsByTagName("user");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					String index = element.getAttribute("id");
					String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
					String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
					String profession = element.getElementsByTagName("profession").item(0).getTextContent();
					
					System.out.println("-------");
					System.out.println("Current element: "+ nNode.getNodeName());
					System.out.println("\n\tId\t "+ index + "\n\tFirstName:\t"+firstname+"\n\tLastName:\t"+lastname+"\n\tProfession:\t"+profession);
				
			}
		}
	}

}
