package Insurance;

import java.util.ArrayList;

public class InsuranceCompany {

    String companyTitle;
    String contract;
    String location;
    ArrayList<Client> clientList;
    ArrayList<Issue> insuranceIssuesList;

    InsuranceCompany(String aCompanyTitle, String aContract, String aLocation, ArrayList<Client> aClientList, ArrayList<Issue> anIssuesList) {
        companyTitle = aCompanyTitle;
        contract = aContract;
        location = aLocation;
        clientList = aClientList;
        insuranceIssuesList = anIssuesList;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public void setClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }

    public ArrayList<Issue> getInsuranceIssuesList() {
        return insuranceIssuesList;
    }

    public void setInsuranceIssuesList(ArrayList<Issue> insuranceIssuesList) {
        this.insuranceIssuesList = insuranceIssuesList;
    }

    @Override
    public String toString() {
        return "InsuranceCompany{" +
                "companyTitle='" + companyTitle + '\'' +
                ", contract='" + contract + '\'' +
                ", location='" + location + '\'' +
                ", clientList=" + clientList.toString() +
                ", insuranceIssuesList=" + insuranceIssuesList.toString() +
                '}';
    }
}
