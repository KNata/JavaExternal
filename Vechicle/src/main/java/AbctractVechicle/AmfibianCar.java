package AbctractVechicle;

public class AmfibianCar extends CCar {

    private boolean superPower;

    AmfibianCar(double aXCoordinate, double anYCoordinate, double aVechiclePrice,
                double aVechicleSpeed, int aVechicleYearOfProduction, boolean aSuperPower) {
        super(aXCoordinate, anYCoordinate, aVechiclePrice, aVechicleSpeed, aVechicleYearOfProduction);
        superPower = aSuperPower;
    }

    public boolean isSuperPower() {
        return superPower;
    }

    public void setSuperPower(boolean superPower) {
        this.superPower = superPower;
    }

    public void aboutMe() {
        System.out.println("An amphibious automobile is an automobile that is a means of transport, viable on land " +
                "as well as on (or under) water. They are unarmored, for civilian use.");
    }
}
