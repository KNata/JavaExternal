package SmartVechicles.Model;

import java.util.Comparator;
import SmartVechicles.Model.Interfaces.*;

public class AmfibianCar extends Vechicle implements IMovebble, ISwimmable {


   public AmfibianCar(double aPointX, double aPointY, double aVechiclePrice, double aVechicleSpeed, int aVechicleYearOfProduction) {
        super(aPointX, aPointY, aVechiclePrice, aVechicleSpeed, aVechicleYearOfProduction);
    }

    @Override
    public void swimDescription() {
        System.out.println("I can swim");
    }

    @Override
    public void moveDescription() {
        System.out.println("I can drive");
    }

    public static Comparator<AmfibianCar> vechicleComparator = new Comparator<AmfibianCar>() {
        public int compare(AmfibianCar vechicle1, AmfibianCar vechicle2) {
            return (int)(vechicle1.getVechicleSpeed() - vechicle2.getVechicleSpeed());
        }
    };

}
