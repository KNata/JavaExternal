package NewYearPresent.Candies;

public class Marmelove extends Candy {

    private boolean isChocolate;

    Marmelove(String aCandyName, int aWeight, int aCandySugar, double aCandyPrice, boolean aTopping, boolean chocolateOrNo) {
        super(aCandyName, aWeight, aCandySugar, aCandyPrice);
        isChocolate = chocolateOrNo;
    }

    public boolean isChocolate() {
        return isChocolate;
    }

    public void setChocolate(boolean chocolate) {
        isChocolate = chocolate;
    }

    @Override
    public String toString() {
        return "Marmelove{" +
                "isChocolate=" + isChocolate +
                '}';
    }
}
