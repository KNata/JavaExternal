package SmartVechicles.Model;

import java.util.Comparator;


public class Ship extends Vechicle {

    private int maxCountOfPassengers;
    private String portOfRegistration;

    private double pointX;
    private double pointY;
    private double vechiclePrice;
    private double vechicleSpeed;
    private int vechicleYearOfProduction;


    public int getMaxCountOfPassengers() {
        return maxCountOfPassengers;
    }

    public String getPortOfRegistration() {
        return portOfRegistration;
    }


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

    public static Comparator<Ship> getShipComparator() {
        return shipComparator;
    }



    public class Builder {

        private Builder() {
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

        public Builder setMaxCountOfPass(int aMaxCountOfPass) {
            maxCountOfPassengers = aMaxCountOfPass;
            return this;
        }

        public Builder setPortOfRegistration(String aPortOfRegistration) {
            portOfRegistration = aPortOfRegistration;
            return this;
        }


        public Ship build() {
            return Ship.this;
        }

    }

    public static Builder newBuilder() {
        return new Ship().new Builder();
    }

    public static Comparator<Ship> shipComparator = new Comparator<Ship>() {
        public int compare(Ship ship1, Ship ship2) {
            return (int)(ship1.getVechicleSpeed() - ship2.getVechicleSpeed());
        }
    };

    @Override
    public String toString() {
        return "Ship { " +
                " maxCountOfPassengers =" + maxCountOfPassengers +
                ", portOfRegistration = '" + portOfRegistration + '\'' +
                '}';
    }
}