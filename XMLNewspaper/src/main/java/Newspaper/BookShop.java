package Newspaper;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BookShop {

    private ArrayList<PeriodicPaper> periodicPaperList;
    private ArrayList<PermanentPaper> booksList;
    private static ArrayList<Paper> papersList;


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


    public void createPermanentPapersXML () throws IOException, TransformerException, TransformerConfigurationException,
            ParserConfigurationException {
        Collections.sort(booksList, PermanentPaper.permanentPaperComparator);

        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        Document doc = build.newDocument();

        Element root = doc.createElement("Books");
        doc.appendChild(root);

        Element details = doc.createElement("Details");
        root.appendChild(details);

        for (PermanentPaper theBook : booksList) {
            Element name = doc.createElement("Title");
            name.appendChild(doc.createTextNode(String.valueOf(theBook
                    .getPaperTitle())));
            details.appendChild(name);

            Element typeOfPaper = doc.createElement("TypeOfPaper");
            typeOfPaper.appendChild(doc.createTextNode(String.valueOf(theBook.getTypeOfPaper())));
            details.appendChild(typeOfPaper);

            Element peridicity = doc.createElement("Periodicity");
            peridicity.appendChild(doc.createTextNode(String.valueOf(theBook.isPeriodic())));
            details.appendChild(peridicity);

            Element color = doc.createElement("Color");
            color.appendChild(doc.createTextNode(String.valueOf(theBook.isColoful())));
            details.appendChild(color);

            Element numbOfPages = doc.createElement("NumberofPages");
            numbOfPages.appendChild(doc.createTextNode(String.valueOf(theBook.getNumberOfPages())));
            details.appendChild(numbOfPages);

        }

        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();
        aTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        aTransformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        FileWriter fos = new FileWriter("./books.xml");
        StreamResult result = new StreamResult(fos);
        aTransformer.transform(source, result);
        System.out.println("File was successfully saved");
    }

    public void createPeriodicPapersList() throws  IOException, ParserConfigurationException, TransformerConfigurationException,
                TransformerException {
            Collections.sort(periodicPaperList, PeriodicPaper.periodicPaperComparator);
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();

            Element root = doc.createElement("PeriodicPapers");
            doc.appendChild(root);

            Element details = doc.createElement("Details");
            root.appendChild(details);

            for (PeriodicPaper magazine : periodicPaperList) {
                Element name = doc.createElement("Title");
                name.appendChild(doc.createTextNode(String.valueOf(magazine.getPaperTitle())));
                details.appendChild(name);

                Element typeOfPaper = doc.createElement("TypeOfPaper");
                typeOfPaper.appendChild(doc.createTextNode(String.valueOf(magazine.getTypeOfPaper())));
                details.appendChild(typeOfPaper);

                Element periodicity = doc.createElement("Periodicity");
                periodicity.appendChild(doc.createTextNode(String.valueOf(magazine.isPeriodic())));
                details.appendChild(periodicity);

                Element color = doc.createElement("Color");
                color.appendChild(doc.createTextNode(String.valueOf(magazine.isColoful())));
                details.appendChild(color);

                Element numbOfPages = doc.createElement("NumberofPages");
                numbOfPages.appendChild(doc.createTextNode(String.valueOf(magazine.getNumberOfPages())));
                details.appendChild(numbOfPages);

                Element zipIndex = doc.createElement("Zip");
                zipIndex.appendChild(doc.createTextNode(String.valueOf(magazine.getIndex())));
                details.appendChild(zipIndex);
            }

                TransformerFactory tranFactory = TransformerFactory.newInstance();
                Transformer aTransformer = tranFactory.newTransformer();
                aTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                aTransformer.setOutputProperty(
                        "{http://xml.apache.org/xslt}indent-amount", "4");
                aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                FileWriter fos = new FileWriter("./magazines.xml");
                StreamResult result = new StreamResult(fos);
                aTransformer.transform(source, result);
                System.out.println("File was successfully saved");
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
