package SmartVechicles.Model;

public abstract class Vechicle {

    private double pointX;
    private double pointY;
    private double vechiclePrice;
    private double vechicleSpeed;
    private int vechicleYearOfProduction;

    public double getPointX() {
        return pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public double getVechiclePrice() {
        return vechiclePrice;
    }

    public double getVechicleSpeed() {
        return vechicleSpeed;
    }

    public int getVechicleYearOfProduction() {
        return vechicleYearOfProduction;
    }


    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setPointX(double aPointX) {
            pointX = aPointX;
            return this;
        }

        public Builder setPointY(double aPointY) {
            pointY = aPointY;
            return this;
        }

        public Builder setVechiclePrice(double aPrice) {
            vechiclePrice = aPrice;
            return this;
        }

        public Builder setVechicleSpeed(double aSpeed) {
            vechicleSpeed = aSpeed;
            return this;
        }

        public Builder setYearOfProduction(int aYearOfProduction) {
            vechicleYearOfProduction = aYearOfProduction;
            return this;
        }

        public Vechicle build() {
            return Vechicle.this;
        }

    }



    @Override
    public String toString() {
        return "Vechicle { " +
                "pointX = " + pointX +
                ", pointY = " + pointY +
                ", vechiclePrice = " + vechiclePrice +
                ", vechicleSpeed = " + vechicleSpeed +
                ", vechicleYearOfProduction = " + vechicleYearOfProduction +
                '}';
    }
}
