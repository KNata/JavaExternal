package Newspaper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.ArrayList;

public class BookShop {

    private ArrayList<PeriodicPaper> periodicPaperList;
    private ArrayList<PermanentPaper> booksList;
    private ArrayList<Paper> papersList;

    private Element staff;

    private static final String PERIODIC = "periodic";
    private static final String PERMANENT = "permanent";

    BookShop(ArrayList<Paper> papers) {
        periodicPaperList = new ArrayList<PeriodicPaper>();
        booksList = new ArrayList<PermanentPaper>();
        papersList = papers;
    }

    public void readAllPapers (String theFileToRead) throws ParserConfigurationException, IOException, SAXException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(theFileToRead));
        collectInformation(document, PERIODIC);
        collectInformation(document, PERMANENT);
    }

    private void collectInformation(Document document, final String element) {
        NodeList elements = document.getElementsByTagName(element);
        for (int i = 0; i < elements.getLength(); i++) {
            NamedNodeMap attributes = elements.item(i).getAttributes();
            String library = attributes.getNamedItem("Library").getNodeValue();
            switch (element) {
                case PERIODIC: {
                    String title = attributes.getNamedItem("Title").getNodeValue();
                    String typeOfPaper = attributes.getNamedItem("Type of Paper").getNodeValue();
                    boolean periodicity = Boolean.valueOf(attributes.getNamedItem("Periodicity").getNodeValue());
                    boolean color = Boolean.valueOf(attributes.getNamedItem("Color").getNodeValue());
                    int numberOfPages = Integer.getInteger(attributes.getNamedItem("Number of Pages").getNodeValue());
                    int zipIndex = Integer.getInteger(attributes.getNamedItem("Zip Index for subscription").getNodeValue());

                    papersList.add(new PeriodicPaper(title, typeOfPaper, periodicity, color, numberOfPages, zipIndex));
                }
                break;
                case PERMANENT: {
                    String title = attributes.getNamedItem("Title").getNodeValue();
                    String typeOfPaper = attributes.getNamedItem("Type of Paper").getNodeValue();
                    boolean periodicity = Boolean.valueOf(attributes.getNamedItem("Periodicity").getNodeValue());
                    boolean color = Boolean.valueOf(attributes.getNamedItem("Color").getNodeValue());
                    int numberOfPages = Integer.getInteger(attributes.getNamedItem("Number of Pages").getNodeValue());

                    papersList.add(new PermanentPaper(title, typeOfPaper, periodicity, color, numberOfPages));
                }
                break;
            }
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

        public void createNewspapersXML () {
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("Newspapers");
                doc.appendChild(rootElement);
                staff = doc.createElement("Newspapers");
                rootElement.appendChild(staff);
                for (int i = 0; i < periodicPaperList.size(); i++) {
                    Attr id = doc.createAttribute("id");
                    id.setValue(String.valueOf(periodicPaperList.get(i).getPaperID()));
                    staff.setAttributeNode(id);

                    Attr title = doc.createAttribute("Title");
                    title.setValue(periodicPaperList.get(i).getPaperTitle());
                    staff.setAttributeNode(title);

                    Attr typeOfPaper = doc.createAttribute("TypeofPaper");
                    typeOfPaper.setValue(String.valueOf((periodicPaperList.get(i).getTypeOfPaper())));
                    staff.setAttributeNode(typeOfPaper);

                    Attr peiodicity = doc.createAttribute("Periodicity");
                    peiodicity.setValue(String.valueOf(periodicPaperList.get(i).isPeriodic()));
                    staff.setAttributeNode(peiodicity);

                    Attr color = doc.createAttribute("Color");
                    color.setValue(String.valueOf(periodicPaperList.get(i).isColoful()));
                    staff.setAttributeNode(color);

                    Attr numberOfPages = doc.createAttribute("NumberofPages");
                    numberOfPages.setValue(String.valueOf(periodicPaperList.get(i).getNumberOfPages()));
                    staff.setAttributeNode(numberOfPages);

                    Attr zipCode = doc.createAttribute("Zip");
                    zipCode.setValue(String.valueOf(periodicPaperList.get(i).getIndex()));
                    staff.setAttributeNode(zipCode);
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("periodicList.xml"));

                transformer.transform(source, result);

                System.out.println("File saved!");

            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }

        }

        public void createPermanentPapersXML () {
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("Newspapers");
                doc.appendChild(rootElement);
                staff = doc.createElement("Newspapers");
                rootElement.appendChild(staff);
                for (int i = 0; i < booksList.size(); i++) {

                    Attr id = doc.createAttribute("id");
                    id.setValue(String.valueOf(booksList.get(i).getPaperID()));
                    staff.setAttributeNode(id);

                    Attr title = doc.createAttribute("Title");
                    title.setValue(booksList.get(i).getPaperTitle());
                    staff.setAttributeNode(title);

                    Attr typeOfPaper = doc.createAttribute("TypeofPaper");
                    typeOfPaper.setValue(String.valueOf((booksList.get(i).getTypeOfPaper())));
                    staff.setAttributeNode(typeOfPaper);

                    Attr peiodicity = doc.createAttribute("Periodicity");
                    peiodicity.setValue(String.valueOf(booksList.get(i).isPeriodic()));
                    staff.setAttributeNode(peiodicity);

                    Attr color = doc.createAttribute("Color");
                    color.setValue(String.valueOf(booksList.get(i).isColoful()));
                    staff.setAttributeNode(color);

                    Attr numberOfPages = doc.createAttribute("NumberofPages");
                    numberOfPages.setValue(String.valueOf(booksList.get(i).getNumberOfPages()));
                    staff.setAttributeNode(numberOfPages);
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("books.xml"));

                transformer.transform(source, result);

                System.out.println("File saved!");

            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }
        }


    public ArrayList<PeriodicPaper> getPeriodicPaperList() {
        return periodicPaperList;
    }

    public void setPeriodicPaperList(ArrayList<PeriodicPaper> periodicPaperList) {
        this.periodicPaperList = periodicPaperList;
    }

    public ArrayList<PermanentPaper> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<PermanentPaper> booksList) {
        this.booksList = booksList;
    }

    public ArrayList<Paper> getPapersList() {
        return papersList;
    }

    public void setPapersList(ArrayList<Paper> papersList) {
        this.papersList = papersList;
    }
}
