package SmartVechicles.Model;

import java.util.Comparator;
import SmartVechicles.Model.Interfaces.*;



public class BetMobile extends Vechicle implements ISwimmable, IMovebble, IFlyvable {

    private double pointX;
    private double pointY;
    private double vechiclePrice;
    private double vechicleSpeed;
    private int vechicleYearOfProduction;

    public BetMobile() {}

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

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public void setVechiclePrice(double vechiclePrice) {
        this.vechiclePrice = vechiclePrice;
    }

    public void setVechicleSpeed(double vechicleSpeed) {
        this.vechicleSpeed = vechicleSpeed;
    }

    public void setVechicleYearOfProduction(int vechicleYearOfProduction) {
        this.vechicleYearOfProduction = vechicleYearOfProduction;
    }

    public static void setVechicleComparator(Comparator<BetMobile> vechicleComparator) {
        BetMobile.vechicleComparator = vechicleComparator;
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

    public static Comparator<BetMobile> vechicleComparator = new Comparator<BetMobile>() {
        public int compare(BetMobile vechicle1, BetMobile vechicle2) {
            return (int)(vechicle1.getVechicleSpeed() - vechicle2.getVechicleSpeed());
        }
    };
}
