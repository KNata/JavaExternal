package Insurance;

import java.util.ArrayList;

public class InsuranceCompany {

    private String companyName;
    private String companyPhone;
    private String companyAddress;
    private ArrayList<Issue> issuesList;
    private ArrayList<Client> clientsList;

    public InsuranceCompany(String aCompanyName, String aCompanyPhone, String aCompanyAddress,
                     ArrayList<Issue> anIssuesList, ArrayList<Client> aClientsList) {
        companyName = aCompanyName;
        companyPhone = aCompanyPhone;
        companyAddress = aCompanyAddress;
        issuesList = anIssuesList;
        clientsList = aClientsList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public ArrayList<Issue> getIssuesList() {
        return issuesList;
    }

    public void setIssuesList(ArrayList<Issue> issuesList) {
        this.issuesList = issuesList;
    }

    public ArrayList<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(ArrayList<Client> clientsList) {
        this.clientsList = clientsList;
    }

    @Override
    public String toString() {
        return "InsuranceCompany{" +
                "companyName='" + companyName + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", issuesList=" + issuesList.toArray() +
                ", clientsList=" + clientsList.toArray() +
                '}';
    }
}
