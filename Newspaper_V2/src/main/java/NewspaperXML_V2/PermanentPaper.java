package NewspaperXML_V2;

public class PermanentPaper extends Paper {

    PermanentPaper() {}

     PermanentPaper(int anID, String aPaperTitle, String aTypeOfPaper, boolean aPeriodicity, boolean color, int aNumOfPages) {
        super(anID, aPaperTitle, aTypeOfPaper, aPeriodicity, color, aNumOfPages, 0);
    }

}