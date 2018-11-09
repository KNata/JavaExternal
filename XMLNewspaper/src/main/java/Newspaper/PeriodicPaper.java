package Newspaper;

import java.util.Comparator;

public class PeriodicPaper extends Paper {

    private String paperTitle;
    private String typeOfPaper;
    private boolean isPeriodic;
    private boolean isColoful;
    private int numberOfPages;

    private int index;


    PeriodicPaper(String aPaperTitle, String aTypeOfPaper, boolean aPeriodicity, boolean color, int aNumOfPages, int anIndex) {
        super(aPaperTitle, aTypeOfPaper, aPeriodicity, color, aNumOfPages);
        index = anIndex;
        paperTitle = aPaperTitle;
        typeOfPaper = aTypeOfPaper;
        isPeriodic = aPeriodicity;
        isColoful = color;
        numberOfPages = aNumOfPages;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String getPaperTitle() {
        return paperTitle;
    }

    @Override
    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    @Override
    public String getTypeOfPaper() {
        return typeOfPaper;
    }

    @Override
    public void setTypeOfPaper(String typeOfPaper) {
        this.typeOfPaper = typeOfPaper;
    }

    @Override
    public boolean isPeriodic() {
        return isPeriodic;
    }

    @Override
    public void setPeriodic(boolean periodic) {
        isPeriodic = periodic;
    }

    @Override
    public boolean isColoful() {
        return isColoful;
    }

    @Override
    public void setColoful(boolean coloful) {
        isColoful = coloful;
    }

    @Override
    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public static Comparator<PeriodicPaper> periodicPaperComparator = new Comparator<PeriodicPaper>() {
        public int compare(PeriodicPaper paper1, PeriodicPaper paper2) {
            return (paper1.getPaperTitle().compareTo(paper2.getPaperTitle()));
        }
    };


}
