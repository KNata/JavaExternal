package NewspaperXML_V2;

public class PeriodicPaper extends Paper {

    private int index;

    PeriodicPaper() {}

    PeriodicPaper(int aPaperID, String aPaperTitle, String aTypeOfPaper, boolean aPeriodicity, boolean color, int aNumOfPages, int anIndex) {
        super(aPaperID, aPaperTitle, aTypeOfPaper, aPeriodicity, color, aNumOfPages, anIndex);
    }

}

