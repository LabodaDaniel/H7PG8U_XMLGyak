package SaxH7PG8U1019;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxH7PG8U {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try{
            SAXParserFactory saxParseFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParseFactory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            
            saxParser.parse(new File("szemelyekH7PG8U.xml"), handler);
            
        }catch(ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }  
	}

}
