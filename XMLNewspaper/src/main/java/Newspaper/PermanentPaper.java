package Newspaper;


import java.util.Comparator;

public class PermanentPaper extends Paper {

    private String paperTitle;
    private String typeOfPaper;
    private boolean isPeriodic;
    private boolean isColoful;
    private int numberOfPages;

    public PermanentPaper(String aPaperTitle, String aTypeOfPaper, boolean aPeriodicity, boolean color, int aNumOfPages) {
        super(aPaperTitle, aTypeOfPaper, aPeriodicity, color, aNumOfPages);
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

    public static Comparator<PermanentPaper> getPermanentPaperComparator() {
        return permanentPaperComparator;
    }

    public static void setPermanentPaperComparator(Comparator<PermanentPaper> permanentPaperComparator) {
        PermanentPaper.permanentPaperComparator = permanentPaperComparator;
    }

    public static Comparator<PermanentPaper> permanentPaperComparator = new Comparator<PermanentPaper>() {
        public int compare(PermanentPaper paper1, PermanentPaper paper2) {
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
        result = prime * result + ((numberOfPages == 0) ? 0 : numberOfPages);
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
        PermanentPaper otherPaper = (PermanentPaper) obj;
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
