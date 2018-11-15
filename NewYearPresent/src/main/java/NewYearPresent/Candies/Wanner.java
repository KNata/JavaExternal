package NewYearPresent.Candies;

public class Wanner extends Candy {

    private boolean isWaffles;


    Wanner(String aCandyName, int aWeight, int aCandySugar, double aCandyPrice, boolean aWaffles) {
        super(aCandyName, aWeight, aCandySugar, aCandyPrice);
        isWaffles = aWaffles;
    }

    public boolean isWaffles() {
        return isWaffles;
    }

    public void setWaffles(boolean waffles) {
        isWaffles = waffles;
    }

    @Override
    public String toString() {
        return "Wanner{" +
                "isWaffles=" + isWaffles +
                '}';
    }
}
