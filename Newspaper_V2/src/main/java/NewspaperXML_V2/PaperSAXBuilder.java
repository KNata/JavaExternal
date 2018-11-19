package NewspaperXML_V2;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

public class PaperSAXBuilder {

    private ArrayList<Paper> paperList;
    private PaperHandler sh;
    private XMLReader reader;

    public PaperSAXBuilder() {
        sh = new PaperHandler();

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }


    public ArrayList<Paper> getPapers() {
        return paperList;
    }

    public void buildSetStudents(String fileName) {
        try {
            reader.parse(fileName); } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
            paperList = sh.getPaperList();
        }
    }
}