package Insurance;

public class Client {

    private String clientName;
    private int clientAge;
    private String clientAddress;
    private Issue clientIssue;
    private long priceForInsurance;


    Client(String aClientName, int aClientAge, String aClientAddress, Issue aClientIssue, long aPriceForInsuance) {
        clientName = aClientName;
        clientAge = aClientAge;
        clientAddress = aClientAddress;
        clientIssue = aClientIssue;
        priceForInsurance = aPriceForInsuance;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientAge() {
        return clientAge;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Issue getClientIssue() {
        return clientIssue;
    }

    public void setClientIssue(Issue clientIssue) {
        this.clientIssue = clientIssue;
    }

    public long getPriceForInsurance() {
        return priceForInsurance;
    }

    public void setPriceForInsurance(long priceForInsurance) {
        this.priceForInsurance = priceForInsurance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", clientAge=" + clientAge +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientIssue=" + clientIssue +
                ", priceForInsurance=" + priceForInsurance +
                '}';
    }
}
