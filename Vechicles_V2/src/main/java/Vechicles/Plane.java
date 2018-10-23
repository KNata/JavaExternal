package Vechicles;

import java.util.Comparator;


public class Plane extends Vechicle {

    private int maxCountOfPassengers;
    private double heighOfFlightUnderSea;

    Plane(double aPointX, double aPointY, double aVechiclePrice, double aVechicleSpeed, int aVechicleYearOfProduction,
          int aMaxCountOfPass, double aHeight) {
        super(aPointX, aPointY, aVechiclePrice, aVechicleSpeed, aVechicleYearOfProduction);
        maxCountOfPassengers = aMaxCountOfPass;
        heighOfFlightUnderSea = aHeight;
    }

    public int getMaxCountOfPassengers() {
        return maxCountOfPassengers;
    }

    public void setMaxCountOfPassengers(int maxCountOfPassengers) {
        this.maxCountOfPassengers = maxCountOfPassengers;
    }

    public double getHeighOfFlightUnderSea() {
        return heighOfFlightUnderSea;
    }

    public void setHeighOfFlightUnderSea(double heighOfFlightUnderSea) {
        this.heighOfFlightUnderSea = heighOfFlightUnderSea;
    }

    public static Comparator<Plane> planeComparator = new Comparator<Plane>() {
        public int compare(Plane plane1, Plane plane2) {
            return (int)(plane1.getVechicleSpeed() - plane2.getVechicleSpeed());
        }
    };

    @Override
    public String toString() {
        return "Plane{" +
                " maxCountOfPassengers = " + maxCountOfPassengers +
                ", heighOfFlightUnderSea = " + heighOfFlightUnderSea +
                '}';
    }
}
