package Newspaper;

import java.util.Comparator;

public class Paper {

    private int paperID;
    private String paperTitle;
    private String typeOfPaper;
    private boolean isPeriodic;
    private boolean isColoful;
    private int numberOfPages;

    Paper(){}

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((paperTitle == null) ? 0 : paperTitle.hashCode());
        result = prime * result + ((typeOfPaper == null) ? 0 : typeOfPaper.hashCode());
        result = prime * result + ((numberOfPages == 0) ? 0 : numberOfPages);
        result = prime * result + (isPeriodic ? 1 : 0);
        result = prime * result + (isColoful ? 1 : 0);
        result = prime * result + numberOfPages;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Paper otherPaper = (Paper) obj;
        if (paperTitle == null) {
            if (otherPaper.paperTitle != null)
                return false;
        } else if (!paperTitle.equals(otherPaper.paperTitle))
            return false;
        if (numberOfPages == 0) {
            if (otherPaper.numberOfPages != 0)
                return false;
        } else if (numberOfPages != otherPaper.numberOfPages)
            return false;
        if (isColoful != otherPaper.isColoful)
            return false;
        if (isPeriodic != otherPaper.isPeriodic)
            return false;
        return true;
    }

}
