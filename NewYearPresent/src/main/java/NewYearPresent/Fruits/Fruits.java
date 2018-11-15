package NewYearPresent.Fruits;

import java.util.Objects;

public class Fruits {

    private String fryitName;
    private int weight;
    private int countOfSugar;
    private double fryitPrice;

    Fruits(String aFryitName, int aWeight, int aCandySugar, double aFryitPrice) {
        fryitName = aFryitName;
        weight = aWeight;
        countOfSugar = aCandySugar;
        fryitPrice = aFryitPrice;
    }

    public String getFryitName() {
        return fryitName;
    }

    public void setFryitName(String fryitName) {
        this.fryitName = fryitName;
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

    public double getFryitPrice() {
        return fryitPrice;
    }

    public void setFryitPrice(double fryitPrice) {
        this.fryitPrice = fryitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruits fruits = (Fruits) o;
        return weight == fruits.weight &&
                countOfSugar == fruits.countOfSugar &&
                Double.compare(fruits.fryitPrice, fryitPrice) == 0 &&
                Objects.equals(fryitName, fruits.fryitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fryitName, weight, countOfSugar, fryitPrice);
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "fryitName='" + fryitName + '\'' +
                ", weight=" + weight +
                ", countOfSugar=" + countOfSugar +
                ", fryitPrice=" + fryitPrice +
                '}';
    }
}
