package NewYearPresent.Candies;

public class StarLight extends Candy {

    private boolean hasTopping;
    private boolean isChocolate;

    public  StarLight(String aCandyName, int aWeight, int aCandySugar, double aCandyPrice, boolean aTopping, boolean chocolateOrNo) {
        super(aCandyName, aWeight, aCandySugar, aCandyPrice);
        hasTopping = aTopping;
        isChocolate = chocolateOrNo;
    }

    public boolean isHasTopping() {
        return hasTopping;
    }

    public void setHasTopping(boolean hasTopping) {
        this.hasTopping = hasTopping;
    }

    public boolean isChocolate() {
        return isChocolate;
    }

    public void setChocolate(boolean chocolate) {
        isChocolate = chocolate;
    }

    @Override
    public String toString() {
        return "StarLight{" +
                "hasTopping=" + hasTopping +
                ", isChocolate=" + isChocolate +
                '}';
    }
}
