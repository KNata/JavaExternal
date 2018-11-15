package Newspaper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class BookServiceUsingSAX extends DefaultHandler {

    private PeriodicPaper periodicPapers;
    private Paper book;

    private ArrayList<PeriodicPaper> periodicPaperList;
    private ArrayList<PermanentPaper> booksList;
    private ArrayList<Paper> papersList;

    private String temp;


    BookServiceUsingSAX() {
        papersList = new ArrayList<Paper>();
        periodicPaperList = new ArrayList<PeriodicPaper>();
        booksList = new ArrayList<PermanentPaper>();

    }

    boolean bAge = false;
    boolean bName = false;
    boolean bGender = false;
    boolean bRole = false;
    boolean bPages = false;

    public void readXML(String aFile) throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        BookServiceUsingSAX handler = new BookServiceUsingSAX();
        saxParser.parse(aFile, handler);
        //handler.readList();
    }

    public void characters(char[] buffer, int start, int length) {
        temp = new String(buffer, start, length);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        temp = "";
        book = new Paper();
//        if (qName.equalsIgnoreCase("Periodicity")) {
//            periodicPapers = new PeriodicPaper(null, null, false, false, 0,0);
//        } else {
//            book = new PermanentPaper(null, null, false, false, 0);
//        }
    }


    public void endElement(String uri, String localName, String qName) throws SAXException {
//        if (qName.equalsIgnoreCase("Periodicity")) {
//            if (qName.equalsIgnoreCase("Title")) {
//                periodicPapers.setPaperTitle(temp);
//            } else if (qName.equalsIgnoreCase("TypeofPaper")) {
//                periodicPapers.setTypeOfPaper(temp);
//            } else if (qName.equalsIgnoreCase("Periodicity")) {
//                periodicPapers.setPeriodic(Boolean.valueOf(temp));
//            } else if (qName.equalsIgnoreCase("Color")) {
//                periodicPapers.setColoful(Boolean.valueOf(temp));
//            } else if (qName.equalsIgnoreCase("NumberofPages")) {
//                periodicPapers.setNumberOfPages(Integer.valueOf(temp));
//            } else if (qName.equalsIgnoreCase("Zip")) {
//                periodicPapers.setIndex(Integer.parseInt(temp));
//            }
//            papersList.add(periodicPapers);
//        } else {
            if (qName.equalsIgnoreCase("Title")) {
                book.setPaperTitle(temp);

            } else if (qName.equalsIgnoreCase("TypeofPaper")) {
                book.setTypeOfPaper(temp);
            } else if (qName.equalsIgnoreCase("Periodicity")) {
                book.setPeriodic(Boolean.valueOf(temp));
            } else if (qName.equalsIgnoreCase("Color")) {
                book.setColoful(Boolean.valueOf(temp));
            } else if (qName.equalsIgnoreCase("NumberofPages")) {
                book.setNumberOfPages(Integer.valueOf(temp));
            }
            System.out.println(book.toString());
            papersList.add(book);
        //}
    }

    private void readList() {
        System.out.println("Paper's count: " + papersList.size());
        Iterator<Paper> it = papersList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void sortPapers() {
        for (int i = 0; i < papersList.size(); i++) {
            if (papersList.get(i) instanceof PeriodicPaper) {
                periodicPaperList.add((PeriodicPaper) papersList.get(i));
            } else if (papersList.get(i) instanceof PermanentPaper) {
                booksList.add((PermanentPaper) papersList.get(i));
            }
        }
    }

    public ArrayList<PeriodicPaper> getPeriodicPaperList() {
        return periodicPaperList;
    }

    public ArrayList<PermanentPaper> getBooksList() {
        return booksList;
    }

    public ArrayList<Paper> getPapersList() {
        return papersList;
    }
}
