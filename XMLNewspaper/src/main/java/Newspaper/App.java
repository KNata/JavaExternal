package Newspaper;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SAXException, ParserConfigurationException, IOException, TransformerException {
        System.out.println("Using SAX parser");
        BookServiceUsingSAX bs = new BookServiceUsingSAX();
        bs.readXML("Papers.xml");
        bs.sortPapers();
        System.out.println();
        System.out.println("List of periodic papers");
        Iterator<PeriodicPaper> periodicPaperIterator = bs.getPeriodicPaperList().iterator();
        while (periodicPaperIterator.hasNext()) {
            System.out.println(periodicPaperIterator.next().toString());
        }
        System.out.println();
        System.out.println("List of books");
        Iterator<PermanentPaper> bookIterator = bs.getBooksList().iterator();
        while (bookIterator.hasNext()) {
            System.out.println(bookIterator.next().toString());
        }

        System.out.println("Using DOM parser");
        BookShop theShop = new BookShop();
        ArrayList<Paper> paperList = theShop.readPapers("Papers.xml");
        theShop.sortPapers();
        theShop.createPermanentPapersXML();
        theShop.createPeriodicPapersList();


    }
}
