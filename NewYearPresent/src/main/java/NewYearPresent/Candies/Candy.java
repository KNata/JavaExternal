package NewYearPresent.Candies;

import java.util.Comparator;
import java.util.Objects;

public class Candy {

    private String candyName;
    private int weight;
    private int countOfSugar;
    private double candyPrice;

    Candy(String aCandyName, int aWeight, int aCandySugar, double aCandyPrice) {
        candyName = aCandyName;
        weight = aWeight;
        countOfSugar = aCandySugar;
        candyPrice = aCandyPrice;
    }

    public String getCandyName() {
        return candyName;
    }

    public void setCandyName(String candyName) {
        this.candyName = candyName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCountOfSugar() {
        return countOfSugar;
    }

    public void setCountOfSugar(int countOfSugar) {
        this.countOfSugar = countOfSugar;
    }

    public double getCandyPrice() {
        return candyPrice;
    }

    public void setCandyPrice(double candyPrice) {
        this.candyPrice = candyPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return weight == candy.weight &&
                countOfSugar == candy.countOfSugar &&
                Double.compare(candy.candyPrice, candyPrice) == 0 &&
                Objects.equals(candyName, candy.candyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candyName, weight, countOfSugar, candyPrice);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "candyName='" + candyName + '\'' +
                ", weight=" + weight +
                ", countOfSugar=" + countOfSugar +
                ", candyPrice=" + candyPrice +
                '}';
    }

    public static Comparator<Candy> candyComparator = new Comparator<Candy>() {
        public int compare(Candy candy1, Candy candy2) {
            return (int)(candy1.getCountOfSugar() - candy2.getCountOfSugar());
        }
    };
}
