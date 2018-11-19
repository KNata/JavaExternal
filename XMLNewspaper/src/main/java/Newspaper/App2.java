package Newspaper;

import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class App2 {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XMLStreamException {
        BookServiceUsingSAX booksService = new BookServiceUsingSAX();
        System.out.println();
        //System.out.println(booksService.getPapersList().size());

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            BookServiceUsingSAX handler = new BookServiceUsingSAX();
            saxParser.parse(new File("Papers.xml"), handler);
            //Get Employees list
            List<Paper> empList = handler.getPapersList();
            //print employee information
            for(Paper emp : empList)
                System.out.println(emp);
    }



}
