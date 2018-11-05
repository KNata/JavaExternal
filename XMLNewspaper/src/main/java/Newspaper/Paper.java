package Newspaper;

import java.util.HashMap;

public abstract class Paper {

    private String paperTitle;
    private String typeOfPaper;
    private boolean isPeriodic;
    private boolean isColoful;
    private int numberOfPages;

    Paper (String aPaperTitle, String aTypeOfPaper, boolean aPeriodicity, boolean color, int aNumOfPages) {
        paperTitle = aPaperTitle;
        typeOfPaper = aTypeOfPaper;
        isPeriodic = aPeriodicity;
        isPeriodic = color;
        numberOfPages = aNumOfPages;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getTypeOfPaper() {
        return typeOfPaper;
    }

    public void setTypeOfPaper(String typeOfPaper) {
        this.typeOfPaper = typeOfPaper;
    }

    public boolean isPeriodic() {
        return isPeriodic;
    }

    public void setPeriodic(boolean periodic) {
        isPeriodic = periodic;
    }


    @Override
    public String toString() {
        return "Paper {" +
                "paperTitle = '" + paperTitle + '\'' +
                ", typeOfPaper = '" + typeOfPaper + '\'' +
                ", isPeriodic = " + isPeriodic +
                '}';
    }
}
