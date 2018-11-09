package Newspaper;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class App2 {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        BookShop bookShop = new BookShop();
        ArrayList<Paper> paperList = bookShop.readPapers("Papers.xml");
        bookShop.sortPapers();
        bookShop.createNewspapersXML();
        bookShop.createPermanentPapersXML();

    }
}
