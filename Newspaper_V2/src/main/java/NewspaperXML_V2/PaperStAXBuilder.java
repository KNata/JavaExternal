package NewspaperXML_V2;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class PaperStAXBuilder {

    private List<Paper> paperList;
    private ArrayList<PeriodicPaper> periodicPaperList;
    private ArrayList<PermanentPaper> permanenPaperList;

    PaperStAXBuilder() {
        periodicPaperList = new ArrayList<PeriodicPaper>();
        permanenPaperList = new ArrayList<PermanentPaper>();
    }

    public List<Paper> parseXML(String fileName) {
        paperList = new ArrayList<>();
        Paper thePaper = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("staff")) {

                        thePaper = new Paper();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            thePaper.setPaperID(Integer.parseInt(idAttr.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals("Title")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        thePaper.setPaperTitle(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("TypeofPaper")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        thePaper.setTypeOfPaper(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("Periodicity")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        thePaper.setPeriodic(Boolean.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("Color")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        thePaper.setColoful(Boolean.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("NumberofPages")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        thePaper.setNumberOfPages(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("Zip")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        thePaper.setZipCode(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("staff")) {
                        paperList.add(thePaper);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return paperList;
    }

    public void sortPapers() {
        PeriodicPaper magazine;
        PermanentPaper book = new PermanentPaper();
        for (int i = 0; i < paperList.size(); i++) {
            if (paperList.get(i).isPeriodic()) {
                magazine = new PeriodicPaper(paperList.get(i).getPaperID(), paperList.get(i).getPaperTitle(),
                        paperList.get(i).getTypeOfPaper(), paperList.get(i).isPeriodic(),
                        paperList.get(i).isColoful(), paperList.get(i).getNumberOfPages(),
                        paperList.get(i).getZipCode());
                periodicPaperList.add(magazine);
            } else if (!paperList.get(i).isPeriodic()) {
                book = new PermanentPaper(paperList.get(i).getPaperID(), paperList.get(i).getPaperTitle(),
                        paperList.get(i).getTypeOfPaper(), paperList.get(i).isPeriodic(),
                        paperList.get(i).isColoful(), paperList.get(i).getNumberOfPages());
                permanenPaperList.add(book);
            }
        }
    }

    public ArrayList<PeriodicPaper> getPeriodicPaperList() {
        return periodicPaperList;
    }

    public void setPeriodicPaperList(ArrayList<PeriodicPaper> periodicPaperList) {
        this.periodicPaperList = periodicPaperList;
    }

    public ArrayList<PermanentPaper> getPermanenPaperList() {
        return permanenPaperList;
    }

    public void setPermanenPaperList(ArrayList<PermanentPaper> permanenPaperList) {
        this.permanenPaperList = permanenPaperList;
    }
}



