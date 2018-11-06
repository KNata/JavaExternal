package Newspaper;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SAXException, ParserConfigurationException, IOException {
        System.out.println("Hello World!");
        BookServiceUsingSAX bs = new BookServiceUsingSAX();
        bs.readXML();

    }
}
