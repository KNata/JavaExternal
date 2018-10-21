package Vechicles;

public class Ship extends Vechicle {

    private int maxCountOfPassengers;
    private String portOfRegistration;


    public static class Builder implements javafx.util.Builder<Ship> {

        private double pointX;
        private double pointY;
        private double vechiclePrice;
        private double vechicleSpeed;
        private int vechicleYearOfProduction;
        private int maxCountOfPassengers;
        private String portOfRegistration;


        public Builder setCoordinates(double aPointX, double aPointY) {
            pointX = aPointX;
            pointY = aPointY;
            return this;
        }

        public Builder setPrice(double aPrice) {
            vechiclePrice = aPrice;
            return this;
        }

        public Builder setSpeed(double aSpeed) {
            vechicleSpeed = aSpeed;
            return this;
        }

        public Builder setYeatOfProduction(int aYearOfProduction) {
            vechicleYearOfProduction = aYearOfProduction;
            return this;
        }

        public Builder setMaxCountOfPassagers(int aMaxCountOfPassagers) {
            maxCountOfPassengers = aMaxCountOfPassagers;
            return this;
        }

        public Builder setPort(String aPortOfRegistration) {
            portOfRegistration = aPortOfRegistration;
            return this;
        }

        public Builder build(double aPointX, double aPointY, double aVechiclePrice, double aVechicleSpeed, int aVechicleYearOfProduction, int maxCounfOfPass, String aPortOfRegistration) {
            pointX = aPointX;
            pointY = aPointY;
            vechicleSpeed = aVechicleSpeed;
            vechiclePrice = aVechiclePrice;
            vechicleYearOfProduction = aVechicleYearOfProduction;
            maxCountOfPassengers = maxCounfOfPass;
            portOfRegistration = aPortOfRegistration;
            return this;
        }

        public Ship build() {
            return new Ship(this, maxCountOfPassengers, portOfRegistration);
        }

    }

    private Ship(Builder builder, int aMaxCountOfPass, String aPortOfRegistration) {
        super(builder.pointX, builder.pointY, builder.vechiclePrice, builder.vechicleSpeed, builder.vechicleYearOfProduction);
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

    @Override
    public String toString() {
        return "Ship {" +
                " maxCountOfPassengers =" + maxCountOfPassengers +
                ", portOfRegistration = '" + portOfRegistration + '\'' +
                '}';
    }
}
