package Insurance;

public class Issue {

    private String issueDescription;
    private String importantInformation;
    private long insuranceRefund;

    Issue(String anIssueDescriotion, String anInportantInfo, long anInsuranceRefund) {
        issueDescription = anIssueDescriotion;
        importantInformation = anInportantInfo;
        insuranceRefund = anInsuranceRefund;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getImportantInformation() {
        return importantInformation;
    }

    public void setImportantInformation(String importantInformation) {
        this.importantInformation = importantInformation;
    }

    public long getInsuranceRefund() {
        return insuranceRefund;
    }

    public void setInsuranceRefund(long insuranceRefund) {
        this.insuranceRefund = insuranceRefund;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueDescription='" + issueDescription + '\'' +
                ", importantInformation='" + importantInformation + '\'' +
                ", insuranceRefund=" + insuranceRefund +
                '}';
    }
}
