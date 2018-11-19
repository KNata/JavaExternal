package NewspaperXML_V2;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class PaperSAXBuilder extends DefaultHandler {

    //List to hold Employees object
    private ArrayList<PeriodicPaper> periodicPaperList;
    private ArrayList<PermanentPaper> permanenPaperList;
    private List<Paper> paperList;
    private Paper thePaper;
    private boolean bTypeOfPaper;
    private boolean bTitle;
    private boolean bPeriodicity;
    private boolean bColor;
    private boolean bCountOfPages;
    private boolean bZip;

    PaperSAXBuilder() {
        paperList = new ArrayList<>();
        periodicPaperList = new ArrayList<PeriodicPaper>();
        permanenPaperList = new ArrayList<PermanentPaper>();
        thePaper = null;
        bTypeOfPaper = false;
        bTitle = false;
        bPeriodicity = false;
        bColor = false;
        bCountOfPages = false;
        bZip = false;
    }

    //getter method for employee list
    public List<Paper> getEmpList() {
        return paperList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("staff")) {
            //create a new Employee and put it in Map
            String id = attributes.getValue("id");
            //initialize Employee object and set id attribute
            thePaper = new Paper();
            thePaper.setPaperID(Integer.parseInt(id));
            //initialize list
            if (paperList == null)
                paperList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("Title")) {
            //set boolean values for fields, will be used in setting Employee variables
            bTitle = true;
        } else if (qName.equalsIgnoreCase("TypeofPaper")) {
            bTypeOfPaper = true;
        } else if (qName.equalsIgnoreCase("Periodicity")) {
            bPeriodicity = true;
        } else if (qName.equalsIgnoreCase("Color")) {
            bColor = true;
        } else if (qName.equalsIgnoreCase("NumberofPages")) {
            bCountOfPages = true;
        } else if (qName.equalsIgnoreCase("Zip")) {
            bZip = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("staff")) {
            //add Employee object to list
            paperList.add(thePaper);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bTypeOfPaper) {
            //age element, set Employee age
            thePaper.setTypeOfPaper(new String(ch, start, length));
            bTypeOfPaper = false;
        } else if (bTitle) {
            thePaper.setPaperTitle(new String(ch, start, length));
            bTitle = false;
        } else if (bColor) {
            thePaper.setColoful(Boolean.valueOf(new String(ch, start, length)));
            bColor = false;
        } else if (bPeriodicity) {
            thePaper.setPeriodic(Boolean.valueOf(new String(ch, start, length)));
            bPeriodicity = false;
        } else if (bCountOfPages) {
            thePaper.setNumberOfPages(Integer.valueOf(new String(ch, start, length)));
            bCountOfPages = false;
        } else if (bZip) {
            thePaper.setZipCode(Integer.valueOf(new String(ch, start, length)));
            bZip = false;
        }
    }

    public void sortPapers() {
        PeriodicPaper magazine;
        PermanentPaper book;
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

    public ArrayList<PermanentPaper> getPermanenPaperList() {
        return permanenPaperList;
    }
}

