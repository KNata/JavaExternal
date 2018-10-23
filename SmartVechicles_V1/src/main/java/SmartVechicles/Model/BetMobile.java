package SmartVechicles.Model;

import java.util.Comparator;
import SmartVechicles.Model.Interfaces.*;



public class BetMobile extends Vechicle implements ISwimmable, IMovebble, IFlyvable {

    public BetMobile(double aPointX, double aPointY, double aVechiclePrice, double aVechicleSpeed, int aVechicleYearOfProduction) {
        super(aPointX, aPointY, aVechiclePrice, aVechicleSpeed, aVechicleYearOfProduction);
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
