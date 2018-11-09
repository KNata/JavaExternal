package Newspaper;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BookShop {

    private ArrayList<PeriodicPaper> periodicPaperList;
    private ArrayList<PermanentPaper> booksList;
    private static ArrayList<Paper> papersList;

    private Element staff;

   BookShop() {
        periodicPaperList = new ArrayList<PeriodicPaper>();
        booksList = new ArrayList<PermanentPaper>();
        papersList = new ArrayList<Paper>();

    }

    public static ArrayList<Paper> readPapers(String fileName) throws ParserConfigurationException, SAXException, IOException {
        PermanentPaper book = null;
        PeriodicPaper periodicPaper = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(fileName));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("staff");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                //Create new Employee Object
                boolean isPeriodic = Boolean.valueOf(eElement.getElementsByTagName("Periodicity").item(0).getTextContent());
                if (isPeriodic) {
                    String periodicPaperTitle = eElement.getElementsByTagName("Title").item(0).getTextContent();
                    String periodicPaperType = eElement.getElementsByTagName("TypeofPaper").item(0).getTextContent();
                    boolean isPeriodicP = Boolean.valueOf(eElement.getElementsByTagName("Periodicity").item(0).getTextContent());
                    boolean hasColor = Boolean.valueOf(eElement.getElementsByTagName("Color").item(0).getTextContent());
                    int numberOfPages = Integer.valueOf(eElement.getElementsByTagName("NumberofPages").item(0).getTextContent());
                    int zipCode = Integer.valueOf(eElement.getElementsByTagName("NumberofPages").item(0).getTextContent());
                    periodicPaper = new PeriodicPaper(periodicPaperTitle, periodicPaperType, isPeriodicP, hasColor, numberOfPages, zipCode);
                    papersList.add(periodicPaper);
                } else {
                    String periodicPaperTitle = eElement.getElementsByTagName("Title").item(0).getTextContent();
                    String periodicPaperType = eElement.getElementsByTagName("TypeofPaper").item(0).getTextContent();
                    boolean isPeriodicP = Boolean.valueOf(eElement.getElementsByTagName("Periodicity").item(0).getTextContent());
                    boolean hasColor = Boolean.valueOf(eElement.getElementsByTagName("Color").item(0).getTextContent());
                    int numberOfPages = Integer.valueOf(eElement.getElementsByTagName("NumberofPages").item(0).getTextContent());
                    book = new PermanentPaper(periodicPaperTitle, periodicPaperType, isPeriodicP, hasColor, numberOfPages);
                    papersList.add(book);
                }
            }
        }
        return papersList;
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
