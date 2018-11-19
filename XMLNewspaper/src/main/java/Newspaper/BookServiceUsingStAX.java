package Newspaper;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class BookServiceUsingStAX {

    private ArrayList<Paper> paperList;
    private XMLInputFactory inputFactory;

    public BookServiceUsingStAX() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public ArrayList<Paper> getPaperList() {
        return paperList;
    }

    public void buildSetOfPapers(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = FileInputStream(File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_DOCUMENT) {
                    name = reader.getLocalName();
                    if (PaperEnum.valueOf(name.toUpperCase() == PaperEnum.LIBRARY)) {
                        Paper paper = new Paper();
                        paperList.add(paper);
                    }

                }
            }
        } catch(XMLStreamException e) {
            System.err.println("StAX parsing error! \" + ex.getMessage()");
        } catch (FileNotFoundException e) {
            System.err.println("File " + fileName + " not found! " + e);
        } catch (IOException e) {
            System.err.println("IO exeption " + e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
            }
        } catch (IOException e) {
            System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private Paper buildPaper(XMLStreamReader reader) throws XMLStreamException {
        Paper thePaper = new Paper();
        thePaper.setPaperTitle(reader.getAttributeValue(null, PaperEnum.TITLE.getValue()));
        thePaper.setTypeOfPaper(reader.getAttributeValue(null, PaperEnum.TYPE_OF_PAPER.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PaperEnum.valueOf(name.toUpperCase())) {
                        case TITLE:
                            thePaper.setPaperTitle(getXMLText(reader));
                            break;
                    }
            }
        }
        return null;
    }

}
