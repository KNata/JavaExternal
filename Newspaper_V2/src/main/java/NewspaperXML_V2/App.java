package NewspaperXML_V2;

import com.sun.javafx.tools.packager.PackagerException;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class App 
{
    public static void main( String[] args ) throws SAXException, IOException, XMLStreamException, ParserConfigurationException {

        String fileName = "Papers.xml";

        System.out.println("DOM parser");

        PaperDOMBuilder domBuilder = new PaperDOMBuilder();
        ArrayList<Paper> papers = domBuilder.readPapers(fileName);
        domBuilder.sortPapers();
        System.out.println("Permament paper's list");
        for (PermanentPaper p : domBuilder.getBooksList()) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println("Periodic paper's list");
        for(PeriodicPaper perPaper : domBuilder.getPeriodicPaperList()){
            System.out.println(perPaper.toString());
        }

        System.out.println();
        System.out.println();

        System.out.println("StAX parser");

        PaperStAXBuilder staxParser = new PaperStAXBuilder();
        List<Paper> empList = staxParser.parseXML(fileName);
        staxParser.sortPapers();
        System.out.println("Periodic paper's list");
        for(PeriodicPaper emp : staxParser.getPeriodicPaperList()){
            System.out.println(emp.toString());
        }
        System.out.println();
        System.out.println("Permanent paper's list");
        for(PermanentPaper emp : staxParser.getPermanenPaperList()){
            System.out.println(emp.toString());
        }

        System.out.println();
        System.out.println();

        System.out.println("SAX parser");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        PaperSAXBuilder handler = new PaperSAXBuilder();
        saxParser.parse(new File(fileName), handler);
        List<Paper> paperList = handler.getEmpList();
        handler.sortPapers();
        System.out.println("Periodic paper's list");
        for (PeriodicPaper periodicPaper : handler.getPeriodicPaperList()) {
            System.out.println(periodicPaper.toString());
        }
        System.out.println();
        System.out.println("Permanent paper's list");
        for (PermanentPaper permanentPaper : handler.getPermanenPaperList()) {
            System.out.println(permanentPaper.toString());
        }


    }
}
