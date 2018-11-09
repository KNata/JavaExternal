package Newspaper;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BookServiceUsingStAX {

    private static PeriodicPaper periodicPapers;
    private static PermanentPaper book;

    private ArrayList<PeriodicPaper> periodicPaperList;
    private ArrayList<PermanentPaper> booksList;
    private static ArrayList<Paper> papersList;


    BookServiceUsingStAX() {
        periodicPaperList = new ArrayList<PeriodicPaper>();
        booksList = new ArrayList<PermanentPaper>();
        papersList = new ArrayList<Paper>();
    }

    public ArrayList<Paper> readAllPapersWithStAX(String fileName) throws XMLStreamException, IOException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        String title = "";
        String paperType = "";
        boolean isPeriodicP = false;
        boolean hasColor = false;
        int numberOfPages = 0;
        int zipCode = 0;
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if (startElement.getName().getLocalPart().equals("staff")) {
                    Attribute idAttr = startElement.getAttributeByName(new QName("Title"));
                    System.out.println(idAttr);
                    if (Boolean.valueOf(idAttr.getValue())) {
                        if (startElement.getName().getLocalPart().equals("Title")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            title = xmlEvent.asCharacters().getData();
                        } else if (startElement.getName().getLocalPart().equals("TypeofPaper")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            paperType = xmlEvent.asCharacters().getData();
                        } else if (startElement.getName().getLocalPart().equals("Periodicity")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            isPeriodicP = Boolean.valueOf(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("Color")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            hasColor = Boolean.valueOf(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("NumberofPages")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            numberOfPages = Integer.valueOf(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("Zip")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            zipCode = Integer.valueOf(xmlEvent.asCharacters().getData());
                        }
                        periodicPapers = new PeriodicPaper(title, paperType, isPeriodicP, hasColor, numberOfPages, zipCode);
                        papersList.add(periodicPapers);
                    } else {
                        if (startElement.getName().getLocalPart().equals("Title")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            title = xmlEvent.asCharacters().getData();
                        } else if (startElement.getName().getLocalPart().equals("TypeofPaper")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            paperType = xmlEvent.asCharacters().getData();
                        } else if (startElement.getName().getLocalPart().equals("Periodicity")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            isPeriodicP = Boolean.valueOf(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("Color")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            hasColor = Boolean.valueOf(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("NumberofPages")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            numberOfPages = Integer.valueOf(xmlEvent.asCharacters().getData());
                        }
                        book = new PermanentPaper(title, paperType, isPeriodicP, hasColor, numberOfPages);
                        papersList.add(book);
                    }
                }

            }

        }
        return papersList;
    }
}
