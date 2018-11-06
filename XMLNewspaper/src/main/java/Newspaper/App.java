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
    public static void main( String[] args ) throws ParserConfigurationException, IOException, SAXException {
        System.out.println( "Hello World!" );
       // theShop.readAllPapers("Papers.xml");

        ArrayList<Paper> papers = new ArrayList<Paper>();
        PeriodicPaper p1 = new PeriodicPaper("reee", "Magazine", true, false, 700, 89009);
        PeriodicPaper p2 = new PeriodicPaper("Hi", "Newsletter", true, true, 80, 90887);
        PeriodicPaper p3 = new PeriodicPaper("fghj", "Magazine", true, false, 34, 10000);

        PermanentPaper pm1 = new PermanentPaper("kkkk", "Book", false, false, 100);
        PermanentPaper pm2 = new PermanentPaper("ert", "Book", false, true, 500);
        PermanentPaper pm3 = new PermanentPaper("One", "Book", false, false, 789);

        BookShop theShop = new BookShop(papers);

        papers.add(p1);
        papers.add(p2);
        papers.add(p3);
        papers.add(pm1);
        papers.add(pm2);
        papers.add(pm3);
       // System.out.println(theShop.getPapersList().toString());
        theShop.sortPapers();
        System.out.println();
        System.out.println( "Periodic" );
//        for (int i = 0; i < theShop.getPeriodicPaperList().size(); i++) {
//            System.out.println(theShop.getPeriodicPaperList().get(i).toString() + "\n");
//        }
        System.out.println();
        System.out.println( "Books" );
//        for (int i = 0; i < theShop.getBooksList().size(); i++) {
//            System.out.println(theShop.getBooksList().get(i).toString() + "\n");
//        }

        theShop.createNewspapersXML();
        System.out.println("Permament list size: " + theShop.getBooksList().size() + " elements");
        System.out.println("Periodic list size: " + theShop.getPeriodicPaperList().size() + " elements");
        theShop.createPermanentPapersXML();
    }
}
