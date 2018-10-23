package SmartVechicles.Model;



public abstract class Vechicle {

    private double pointX;
    private double pointY;
    private double vechiclePrice;
    private double vechicleSpeed;
    private int vechicleYearOfProduction;

    public Vechicle(double aPointX, double aPointY, double aVechiclePrice, double aVechicleSpeed, int aVechicleYearOfProduction) {
        pointX = aPointX;
        pointY = aPointY;
        vechicleSpeed = aVechicleSpeed;
        vechiclePrice = aVechiclePrice;
        vechicleYearOfProduction = aVechicleYearOfProduction;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double getVechiclePrice() {
        return vechiclePrice;
    }

    public void setVechiclePrice(double vechiclePrice) {
        this.vechiclePrice = vechiclePrice;
    }

    public double getVechicleSpeed() {
        return vechicleSpeed;
    }

    public void setVechicleSpeed(double vechicleSpeed) {
        this.vechicleSpeed = vechicleSpeed;
    }

    public int getVechicleYearOfProduction() {
        return vechicleYearOfProduction;
    }

    public void setVechicleYearOfProduction(int vechicleYearOfProduction) {
        this.vechicleYearOfProduction = vechicleYearOfProduction;
    }

    @Override
    public String toString() {
        return "Vechicle{ " +
                "pointX = " + pointX +
                ", pointY = " + pointY +
                ", vechiclePrice = " + vechiclePrice +
                ", vechicleSpeed = " + vechicleSpeed +
                ", vechicleYearOfProduction = " + vechicleYearOfProduction +
                '}';
    }
}
