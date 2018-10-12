package AbctractVechicle;

public class CCar extends CVechicle {

    private double xCoordinate;
    private double yCoordinate;
    private double vechiclePrice;
    private double vechicleSpeed;
    private int vechicleYearOfProduction;

    CCar(double aXCoordinate, double anYCoordinate, double aVechiclePrice,
         double aVechicleSpeed, int aVechicleYearOfProduction) {
        xCoordinate = aXCoordinate;
        yCoordinate = anYCoordinate;
        vechiclePrice = aVechiclePrice;
        vechicleSpeed = aVechicleSpeed;
        vechicleYearOfProduction = aVechicleYearOfProduction;
    }

    @Override
    public double getxCoordinate() {
        return xCoordinate;
    }

    @Override
    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    @Override
    public double getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public double getVechiclePrice() {
        return vechiclePrice;
    }

    @Override
    public void setVechiclePrice(double vechiclePrice) {
        this.vechiclePrice = vechiclePrice;
    }

    @Override
    public double getVechicleSpeed() {
        return vechicleSpeed;
    }

    @Override
    public void setVechicleSpeed(double vechicleSpeed) {
        this.vechicleSpeed = vechicleSpeed;
    }

    @Override
    public int getVechicleYearOfProduction() {
        return vechicleYearOfProduction;
    }

    @Override
    public void setVechicleYearOfProduction(int vechicleYearOfProduction) {
        this.vechicleYearOfProduction = vechicleYearOfProduction;
    }
}
