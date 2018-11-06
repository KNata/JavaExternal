package Newspaper;

import java.util.Comparator;

public abstract class Paper {

    private int paperID;
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

        paperID++;
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

    public int getPaperID() {
        return paperID;
    }

    public void setPaperID(int paperID) {
        this.paperID = paperID;
    }

    public boolean isColoful() {
        return isColoful;
    }

    public void setColoful(boolean coloful) {
        isColoful = coloful;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperID = " + paperID +
                ", paperTitle = '" + paperTitle + '\'' +
                ", typeOfPaper = '" + typeOfPaper + '\'' +
                ", isPeriodic = " + isPeriodic +
                ", isColoful = " + isColoful +
                ", numberOfPages = " + numberOfPages +
                '}';
    }

    public static Comparator<Paper> paperComparator = new Comparator<Paper>() {
        public int compare(Paper paper1, Paper paper2) {
            return (paper1.getPaperTitle().compareTo(paper2.getPaperTitle()));
        }
    };
}
