package Insurance;

public class Issue {

    private String issueTitle;
    private String typeOfIssue;
    private int moneyToRefund;
    private boolean confirmationDocuments;

    Issue(String anIssueTitle, String aTypeOfIssue, int aMoneyToRefund, boolean aConfirmationDocuments) {
        issueTitle = anIssueTitle;
        typeOfIssue = aTypeOfIssue;
        moneyToRefund = aMoneyToRefund;
        confirmationDocuments = aConfirmationDocuments;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getTypeOfIssue() {
        return typeOfIssue;
    }

    public void setTypeOfIssue(String typeOfIssue) {
        this.typeOfIssue = typeOfIssue;
    }

    public int getMoneyToRefund() {
        return moneyToRefund;
    }

    public void setMoneyToRefund(int moneyToRefund) {
        this.moneyToRefund = moneyToRefund;
    }

    public boolean isConfirmationDocuments() {
        return confirmationDocuments;
    }

    public void setConfirmationDocuments(boolean confirmationDocuments) {
        this.confirmationDocuments = confirmationDocuments;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueTitle='" + issueTitle + '\'' +
                ", typeOfIssue='" + typeOfIssue + '\'' +
                ", moneyToRefund=" + moneyToRefund +
                ", confirmationDocuments=" + confirmationDocuments +
                '}';
    }
}
