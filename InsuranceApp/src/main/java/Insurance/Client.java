package Insurance;

public class Client {

    private String clientName;
    private boolean isInshuranced;
    private String policeID;
    private int moneyNeedToPay;
    private Issue issue;

    Client(String aClientName, boolean hasInsurance, String aPoliceID, int aMoneyNeedToPay, Issue anIssue) {
        clientName = aClientName;
        isInshuranced = hasInsurance;
        policeID = aPoliceID;
        moneyNeedToPay = aMoneyNeedToPay;
        issue = anIssue;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public boolean isInshuranced() {
        return isInshuranced;
    }

    public void setInshuranced(boolean inshuranced) {
        isInshuranced = inshuranced;
    }

    public String getPoliceID() {
        return policeID;
    }

    public void setPoliceID(String policeID) {
        this.policeID = policeID;
    }

    public int getMoneyNeedToPay() {
        return moneyNeedToPay;
    }

    public void setMoneyNeedToPay(int moneyNeedToPay) {
        this.moneyNeedToPay = moneyNeedToPay;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", isInshuranced=" + isInshuranced +
                ", policeID='" + policeID + '\'' +
                ", moneyNeedToPay=" + moneyNeedToPay +
                ", issue=" + issue.toString() +
                '}';
    }
}
