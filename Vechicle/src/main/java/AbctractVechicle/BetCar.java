package AbctractVechicle;

public class BetCar extends CCar {

    private boolean superPower;

    BetCar(double aXCoordinate, double anYCoordinate, double aVechiclePrice,
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
}
