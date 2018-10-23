package Vechicles;

import java.util.Comparator;


public class Ship extends Vechicle {

    private int maxCountOfPassengers;
    private String portOfRegistration;


    Ship(double aPointX, double aPointY, double aVechiclePrice, double aVechicleSpeed, int aVechicleYearOfProduction,
         int aMaxCountOfPass, String aPortOfRegistration) {
        super(aPointX, aPointY, aVechiclePrice, aVechicleSpeed, aVechicleYearOfProduction);
        maxCountOfPassengers = aMaxCountOfPass;
        portOfRegistration = aPortOfRegistration;
    }

    public int getMaxCountOfPassengers() {
        return maxCountOfPassengers;
    }

    public void setMaxCountOfPassengers(int maxCountOfPassengers) {
        this.maxCountOfPassengers = maxCountOfPassengers;
    }

    public String getPortOfRegistration() {
        return portOfRegistration;
    }

    public void setPortOfRegistration(String portOfRegistration) {
        this.portOfRegistration = portOfRegistration;
    }

    public static Comparator<Ship> shipComparator = new Comparator<Ship>() {
        public int compare(Ship ship1, Ship ship2) {
            return (int)(ship1.getVechicleSpeed() - ship2.getVechicleSpeed());
        }
    };

    @Override
    public String toString() {
        return "Ship {" +
                " maxCountOfPassengers =" + maxCountOfPassengers +
                ", portOfRegistration = '" + portOfRegistration + '\'' +
                '}';
    }
}
