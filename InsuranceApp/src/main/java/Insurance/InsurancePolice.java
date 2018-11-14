package Insurance;

import java.util.ArrayList;

public class InsurancePolice {

    private int policeID;
    private String clientName;
    private String insuranceCompany;
    private double moneyToCost;
    private double moneyToInsurance;
    private String typeOfPolice;
    private int insuredDays;
    private ArrayList<Issue> issuesWhichCover;

    InsurancePolice(int aPoliceID, String aClientName, String anInsuranceCompany, double aMoneyToCost,
                    double aMoneyToInsurance, String aTypeOfInsurance, int aCountOfDays, ArrayList<Issue> anIssuesToCover) {
        policeID = aPoliceID;
        clientName = aClientName;
        insuranceCompany = anInsuranceCompany;
        moneyToCost = aMoneyToCost;
        moneyToInsurance = aMoneyToInsurance;
        typeOfPolice = aTypeOfInsurance;
        insuredDays = aCountOfDays;
        issuesWhichCover = anIssuesToCover;
    }

    public int getPoliceID() {
        return policeID;
    }

    public void setPoliceID(int policeID) {
        this.policeID = policeID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public double getMoneyToCost() {
        return moneyToCost;
    }

    public void setMoneyToCost(double moneyToCost) {
        this.moneyToCost = moneyToCost;
    }

    public double getMoneyToInsurance() {
        return moneyToInsurance;
    }

    public void setMoneyToInsurance(double moneyToInsurance) {
        this.moneyToInsurance = moneyToInsurance;
    }

    public String getTypeOfPolice() {
        return typeOfPolice;
    }

    public void setTypeOfPolice(String typeOfPolice) {
        this.typeOfPolice = typeOfPolice;
    }

    public int getInsuredDays() {
        return insuredDays;
    }

    public void setInsuredDays(int insuredDays) {
        this.insuredDays = insuredDays;
    }

    public ArrayList<Issue> getIssuesWhichCover() {
        return issuesWhichCover;
    }

    public void setIssuesWhichCover(ArrayList<Issue> issuesWhichCover) {
        this.issuesWhichCover = issuesWhichCover;
    }

    @Override
    public String toString() {
        return "InsurancePolice{" +
                "policeID=" + policeID +
                ", clientName='" + clientName + '\'' +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", moneyToCost=" + moneyToCost +
                ", moneyToInsurance=" + moneyToInsurance +
                ", typeOfPolice='" + typeOfPolice + '\'' +
                ", insuredDays=" + insuredDays +
                ", issuesWhichCover=" + issuesWhichCover.toArray() +
                '}';
    }
}
