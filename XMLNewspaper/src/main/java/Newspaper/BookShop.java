package Newspaper;

import java.util.ArrayList;

public class BookShop {

    private ArrayList<Newspaper> newspapersList;
    private ArrayList<Magazine> magazinesList;
    private ArrayList<PermanentPaper> booksList;

    BookShop(ArrayList<Newspaper> aNewspapersList, ArrayList<Magazine> aMagazinesList, ArrayList<PermanentPaper> aBooksList) {
        newspapersList = aNewspapersList;
        magazinesList = aMagazinesList;
        booksList = aBooksList;
    }

    

}
