package Newspaper;

import org.xml.sax.SAXException;
import java.io.File;
import javax.xml.parsers.SAXParser;



import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class App2 {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XMLStreamException {
        BookServiceUsingSAX booksService = new BookServiceUsingSAX();
        booksService.readXML("Papers.xml");
        System.out.println();
        //System.out.println(booksService.getPapersList().size());

    }



}
