package Newspaper;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class BookServiceUsingSAX {

    private ArrayList<PeriodicPaper> periodicPaperList;
    private ArrayList<PermanentPaper> booksList;
    private ArrayList<Paper> papersList;

    BookServiceUsingSAX() {

    }

    public void readXML() throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {
            boolean isTitlePresent = false;
            boolean whatType = false;
            boolean isPeriodic = false;
            boolean isColorful = false;
            boolean hasZipCode = false;
            boolean hasNumberOfPages = false;


            public void startElement(String uri, String localName,String qName,
                                     Attributes attributes) throws SAXException {

              //  System.out.println("Start Element :" + qName);

                if (qName.equalsIgnoreCase("Title")) {
                    isTitlePresent = true;
                }

                if (qName.equalsIgnoreCase("TypeofPaperr")) {
                    whatType = true;
                }

                if (qName.equalsIgnoreCase("Periodicity")) {
                    isPeriodic = true;
                }

                if (qName.equalsIgnoreCase("Color")) {
                    isColorful = true;
                }
                if (qName.equalsIgnoreCase("NumberofPages")) {
                    hasNumberOfPages = true;
                }
                if (qName.equalsIgnoreCase("Zip")) {
                    hasZipCode = true;
                }

            }

            public void endElement(String uri, String localName,
                                   String qName) throws SAXException {

               //System.out.println("End Element :" + qName);
                System.out.println();

            }

            public void characters(char ch[], int start, int length) throws SAXException {

                if () {}

                if (isTitlePresent) {
                    System.out.println("First Name : " + new String(ch, start, length));
                    isTitlePresent = false;
                    System.out.println();
                }

                if (whatType) {
                    System.out.println("Last Name : " + new String(ch, start, length));
                    whatType = false;
                    System.out.println();
                }

                if (isPeriodic) {
                    System.out.println("Nick Name : " + new String(ch, start, length));
                    isPeriodic = false;
                    System.out.println();
                }

                if (isColorful) {
                    System.out.println("Salary : " + new String(ch, start, length));
                    isColorful = false;
                    System.out.println();
                }

            }

        };
        saxParser.parse("Papers.xml", handler);
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



}
