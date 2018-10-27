package SmartVechicles.Model;

import java.util.Comparator;
import SmartVechicles.Model.Interfaces.*;

public class AmfibianCar extends Vechicle implements IMovebble, ISwimmable {


    private double pointX;
    private double pointY;
    private double vechiclePrice;
    private double vechicleSpeed;
    private int vechicleYearOfProduction;

    public AmfibianCar(){

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

    public static void setVechicleComparator(Comparator<AmfibianCar> vechicleComparator) {
        AmfibianCar.vechicleComparator = vechicleComparator;
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
