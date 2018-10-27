package SmartVechicles.Model;

import java.util.Comparator;


public class Car extends Vechicle {

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

    public static Comparator<Car> getCarComparator() {
        return carComparator;
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

        public Car build() {
            return Car.this;
        }

    }

    public static Builder newBuilder() {
        return new Car().new Builder();
    }

    public static Comparator<Car> carComparator = new Comparator<Car>() {
        public int compare(Car car1, Car car2) {
            return (int)(car1.getVechicleSpeed() - car2.getVechicleSpeed());
        }
    };

    @Override
    public String toString() {
        return "Car {" +
                " pointX = " + pointX +
                ", pointY = " + pointY +
                ", vechiclePrice = " + vechiclePrice +
                ", vechicleSpeed = " + vechicleSpeed +
                ", vechicleYearOfProduction = " + vechicleYearOfProduction +
                '}';
    }
}