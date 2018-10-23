package Vechicles;

import java.util.Comparator;


public class Car extends Vechicle {

    private double pointX;
    private double pointY;
    private double vechiclePrice;
    private double vechicleSpeed;
    private int vechicleYearOfProduction;

    Car(double aPointX, double aPointY, double aVechiclePrice, double aVechicleSpeed, int aVechicleYearOfProduction) {
        super(aPointX, aPointY, aVechiclePrice, aVechicleSpeed, aVechicleYearOfProduction);
    }

    public static Comparator<Car> carComparator = new Comparator<Car>() {
        public int compare(Car car1, Car car2) {
            return (int)(car1.getVechicleSpeed() - car2.getVechicleSpeed());
        }
    };

    @Override
    public String toString() {
        return "Car{" +
                "pointX=" + pointX +
                ", pointY=" + pointY +
                ", vechiclePrice=" + vechiclePrice +
                ", vechicleSpeed=" + vechicleSpeed +
                ", vechicleYearOfProduction=" + vechicleYearOfProduction +
                '}';
    }
}
