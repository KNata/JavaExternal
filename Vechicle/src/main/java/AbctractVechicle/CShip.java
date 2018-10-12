package AbctractVechicle;

public class CShip extends CVechicle {

    private double xCoordinate;
    private double yCoordinate;
    private double vechiclePrice;
    private double vechicleSpeed;
    private int vechicleYearOfProduction;
    private int maxCountOfPassengers;
    private String nativePort;


    CShip (double aXCoordinate, double anYCoordinate, double aVechiclePrice,
           double aVechicleSpeed, int aVechicleYearOfProduction, int aMaxCountOfPassengers, String aNativePort) {
        xCoordinate = aXCoordinate;
        yCoordinate = anYCoordinate;
        vechiclePrice = aVechiclePrice;
        vechicleSpeed = aVechicleSpeed;
        vechicleYearOfProduction = aVechicleYearOfProduction;
        maxCountOfPassengers = aMaxCountOfPassengers;
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

    public int getMaxCountOfPassengers() {
        return maxCountOfPassengers;
    }

    public void setMaxCountOfPassengers(int maxCountOfPassengers) {
        this.maxCountOfPassengers = maxCountOfPassengers;
    }

    public String getNativePort() {
        return nativePort;
    }

    public void setNativePort(String nativePort) {
        this.nativePort = nativePort;
    }
}
