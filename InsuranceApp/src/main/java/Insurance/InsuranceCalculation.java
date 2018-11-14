package Insurance;

public class InsuranceCalculation {

    InsuranceCalculation() {}

    public boolean checkIfClientDependsToInsuranceCompany(Client aClient, InsuranceCompany aCompany) {
        boolean belongs = false;
        for (int i = 0; i < aCompany.getClientsList().size(); i++) {
            if (aClient.getClientName().equals(aCompany.getClientsList().get(i).getClientName())) {
                belongs = true;
            }
        }
        return belongs;
    }

    public double calculateSumToReimburse(Client aClient, InsurancePolice aPolice) {
        double avaliabLeSumOnInsurancePolice = 0.0;
        if(aClient.isInshuranced()) {
            if((aPolice.getMoneyToInsurance() >= aClient.getMoneyNeedToPay()) && (aPolice.getInsuredDays() > 0)) {
                aPolice.setMoneyToInsurance(aPolice.getMoneyToInsurance() - aClient.getMoneyNeedToPay());
            }
        }
        return avaliabLeSumOnInsurancePolice;
    }

    
}
