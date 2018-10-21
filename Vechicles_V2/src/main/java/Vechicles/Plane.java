package Vechicles;

public class Plane extends Vechicle {

    private int maxCountOfPassengers;
    private double heighOfFlightUnderSea;

    public static class Builder implements javafx.util.Builder<Plane> {

        private double pointX;
        private double pointY;
        private double vechiclePrice;
        private double vechicleSpeed;
        private int vechicleYearOfProduction;
        private int maxCountOfPassengers;
        private double heighOfFlightUnderSea;


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

        public Builder setHeighOfFlightUnderSean(double aHeighOfFlightUnderSean) {
            heighOfFlightUnderSea = aHeighOfFlightUnderSean;
            return this;
        }

        public Builder build(double aPointX, double aPointY, double aVechiclePrice, double aVechicleSpeed,
                             int aVechicleYearOfProduction, int maxCounfOfPass, double aHeighOfFlightUnderSean) {
            pointX = aPointX;
            pointY = aPointY;
            vechicleSpeed = aVechicleSpeed;
            vechiclePrice = aVechiclePrice;
            vechicleYearOfProduction = aVechicleYearOfProduction;
            maxCountOfPassengers = maxCounfOfPass;
            heighOfFlightUnderSea = aHeighOfFlightUnderSean;
            return this;
        }

        public Plane build() {
            return new Plane(this, maxCountOfPassengers, heighOfFlightUnderSea);
        }

    }

    private Plane(Builder builder, int aMaxCountOfPassengers, double aHeighOfFlightUnderSea) {
        super(builder.pointX, builder.pointY, builder.vechiclePrice, builder.vechicleSpeed, builder.vechicleYearOfProduction);
        maxCountOfPassengers = aMaxCountOfPassengers;
        heighOfFlightUnderSea = aHeighOfFlightUnderSea;
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

    @Override
    public String toString() {
        return "Plane{" +
                " maxCountOfPassengers = " + maxCountOfPassengers +
                ", heighOfFlightUnderSea = " + heighOfFlightUnderSea +
                '}';
    }
}
