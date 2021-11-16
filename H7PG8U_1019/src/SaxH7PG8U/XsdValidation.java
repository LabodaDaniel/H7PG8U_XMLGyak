package SaxFB8YPQ1019;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class XsdValidation {
	
	public static final String XMLPATH = "/SaxFB8YPQ/szemelyekFB8YPQ.xml";
	public static final String XSDPATH = "/SaxFB8YPQ/szemelyekFB8YPQ.xsd";
	
	public static void main(String[] args) {

		File schemaFile = new File(XSDPATH);
		Source xmlFile = new StreamSource(new File(XMLPATH));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);
			System.out.println("XSD Validation successful");
		} catch (SAXException e) {
			System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
		} catch (IOException e) {
		}

	}

}
