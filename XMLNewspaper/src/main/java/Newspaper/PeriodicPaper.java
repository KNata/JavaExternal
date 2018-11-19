package Newspaper;

import java.util.Comparator;

public class PeriodicPaper extends Paper {

    private int index;


    PeriodicPaper(String aPaperTitle, String aTypeOfPaper, boolean aPeriodicity, boolean color, int aNumOfPages, int anIndex) {
        super(aPaperTitle, aTypeOfPaper, aPeriodicity, color, aNumOfPages);
        index = anIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }



}
