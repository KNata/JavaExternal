package Newspaper;

import java.util.Comparator;
import java.util.HashMap;

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

    public static Comparator<PeriodicPaper> periodicPaperComparator = new Comparator<PeriodicPaper>() {
        public int compare(PeriodicPaper paper1, PeriodicPaper paper2) {
            return (paper1.getPaperTitle().compareTo(paper2.getPaperTitle()));
        }
    };
}
