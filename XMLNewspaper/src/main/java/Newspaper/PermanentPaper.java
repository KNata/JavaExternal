package Newspaper;


import java.util.Comparator;

public class PermanentPaper extends Paper {

    public PermanentPaper(String aPaperTitle, String aTypeOfPaper, boolean aPeriodicity, boolean color, int aNumOfPages) {
        super(aPaperTitle, aTypeOfPaper, aPeriodicity, color, aNumOfPages);
    }

    public static Comparator<PermanentPaper> permanentPaperComparator = new Comparator<PermanentPaper>() {
        public int compare(PermanentPaper paper1, PermanentPaper paper2) {
            return (paper1.getPaperTitle().compareTo(paper2.getPaperTitle()));
        }
    };
}
