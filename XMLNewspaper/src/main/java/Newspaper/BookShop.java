package Newspaper;

import java.util.ArrayList;

public class BookShop {

    private ArrayList<Newspaper> newspapersList;
    private ArrayList<Magazine> magazinesList;
    private ArrayList<PermanentPaper> booksList;

    BookShop() {
        newspapersList = new ArrayList<Newspaper>();
        magazinesList = new ArrayList<Magazine>();
        booksList = new ArrayList<PermanentPaper>();
    }

    public void readAllPapers () {}

    public void sortPapersByType() {}

    public void addNewPaperToNeededListAndFile(String aPaperTitleToAdd) {}

    public void removeAPaperFromXML(String aPaperTitleToRemove) {}

    public void createNewspapersXML() {}

    public void createMagazinesXML() {}

    public void createPermanentPapersXML() {}

}
