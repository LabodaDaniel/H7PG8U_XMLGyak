package domfb8ypq1026;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomQueryFB8YPQ {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException  {
		// TODO Auto-generated method stub
		File xmlFile = new File("carsFB8YPQ.xml"); //xml fájl bekérése
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //olvasás lehetõvé tétele
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();


        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        System.out.println("------------------------------");
        LoadQuery(doc);

	}
	
	public static void LoadQuery(Document doc) throws TransformerException {
		NodeList nodeList = doc.getElementsByTagName("supercars");

    	for (int i = 0; i < nodeList.getLength(); i++) {
    		Node nNode = nodeList.item(i);
    		Element element = (Element) nNode;
    		int db = element.getElementsByTagName("carname").getLength();
    		if(nNode.getNodeType() == Node.ELEMENT_NODE) {
    			
    			if(element.getAttribute("company").equals("Ferrari")) {
    				QueryXML(db, doc, element);

    			}
    			if(element.getAttribute("company").equals("Lamborgini")) {
    				QueryXML(db, doc, element);

    			}
    		}
    	}
		
	}
	
	public static void QueryXML(int db, Document doc, Element element) {
		String company = element.getAttribute("company");
		
		System.out.println("\nCurrent element:");
		System.out.println("supercarscompany: " + company);
		for (int i = 0; i < db; i++) {
			NodeList nodeList = element.getElementsByTagName("carname");
			Node nNode = nodeList.item(i);
			Element carElement = (Element) nNode;
	
			String name =  element.getElementsByTagName("carname").item(i).getTextContent();
			String type = carElement.getAttribute("type");
			System.out.println("car name: "+name+"\ncar type: "+type);
		}
	}

}
