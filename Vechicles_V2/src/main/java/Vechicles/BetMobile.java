package Vechicles;

public class BetMobile extends Vechicle implements ISwimmable, IMovebble, IFlyvable {

    public static class Builder implements javafx.util.Builder<BetMobile> {

        private double pointX;
        private double pointY;
        private double vechiclePrice;
        private double vechicleSpeed;
        private int vechicleYearOfProduction;

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

        public Builder build(double aPointX, double aPointY, double aVechiclePrice, double aVechicleSpeed, int aVechicleYearOfProduction) {
            pointX = aPointX;
            pointY = aPointY;
            vechicleSpeed = aVechicleSpeed;
            vechiclePrice = aVechiclePrice;
            vechicleYearOfProduction = aVechicleYearOfProduction;
            return this;
        }

        public BetMobile build() {
            return new BetMobile(this);
        }
    }

    private BetMobile(Builder builder) {
        super(builder.pointX, builder.pointY, builder.vechiclePrice, builder.vechicleSpeed, builder.vechicleYearOfProduction);
    }

    @Override
    public void flyDescription() {
        System.out.println("I can fly");
    }

    @Override
    public void swimDescription() {
        System.out.println("I can swim");
    }

    @Override
    public void moveDescription() {
        System.out.println("I can drive");
    }
}
