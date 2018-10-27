package SmartVechicles.Model;

import java.util.Comparator;


public class Plane extends Vechicle {

    private double pointX;
    private double pointY;
    private double vechiclePrice;
    private double vechicleSpeed;
    private int vechicleYearOfProduction;

    private int maxCountOfPassengers;
    private double heighOfFlightUnderSea;


    public int getMaxCountOfPassengers() {
        return maxCountOfPassengers;
    }

    public double getHeighOfFlightUnderSea() {
        return heighOfFlightUnderSea;
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

	public static Comparator<Plane> getPlaneComparator() {
		return planeComparator;
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

        public Builder setMaxCountOfPass(int aMaxYearOfPass) {
            maxCountOfPassengers = aMaxYearOfPass;
            return this;
        }

        public Builder setMaxHeighUnderSea(double aMaxHeighUnderSea) {
            heighOfFlightUnderSea = aMaxHeighUnderSea;
            return this;
        }

        public Plane build() {
            return Plane.this;
        }

    }

    public static Builder newBuilder() {
        return new Plane().new Builder();
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
