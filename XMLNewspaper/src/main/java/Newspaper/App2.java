package Newspaper;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;

public class App2 {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XMLStreamException {
        BookServiceUsingStAX bookShop = new BookServiceUsingStAX();
        ArrayList<Paper> paperList = bookShop.readAllPapersWithStAX("Papers.xml");
        //("Papers.xml");

    }
}
