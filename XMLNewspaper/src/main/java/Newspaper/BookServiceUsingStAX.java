package Newspaper;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
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
        String title = "";
        String paperType = "";
        boolean isPeriodicP = false;
        boolean hasColor = false;
        int numberOfPages = 0;
        int zipCode = 0;
        Paper thePaper = null;
        PermanentPaper employee = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader(fileName));


        while(streamReader.hasNext())
        {
            //Move to next event
            streamReader.next();

            //Check if its 'START_ELEMENT'
            if(streamReader.getEventType() == XMLStreamReader.START_ELEMENT)
            {
                //employee tag - opened
                if(streamReader.getLocalName().equalsIgnoreCase("employee")) {

                    //Create new employee object asap tag is open
                    employee = new PermanentPaper("", "", false, false, 0);

                    //Read attributes within employee tag
                    if(streamReader.getAttributeCount() > 0) {
                        String id = streamReader.getAttributeValue(null,"id");
                       // employee.setId(Integer.valueOf(id));
                    }
                }

                //Read name data
                if(streamReader.getLocalName().equalsIgnoreCase("Title")) {
                   // employee.setPaperTitle(streamReader.getElementText());
                    System.out.println(streamReader.getElementText());
                }

                //Read title data
                if(streamReader.getLocalName().equalsIgnoreCase("title")) {
                  //  employee.setTypeOfPaper(streamReader.getElementText());
                    System.out.println(streamReader.getElementText());
                }
            }

            //If employee tag is closed then add the employee object to list
            if(streamReader.getEventType() == XMLStreamReader.END_ELEMENT)
            {
                if(streamReader.getLocalName().equalsIgnoreCase("staff")) {
                    papersList.add(employee);
                }
            }
        }
        //Verify read data
        System.out.println(papersList.toArray());
    //}
        return papersList;
    }

    public ArrayList<Paper> getPapersList() {
        return papersList;
    }
}
