package Inheritance;

public class Bird {

    Bird() {
        System.out.println("New bird was created...");
    }

    public void fly() {
        System.out.println("Bird flies...");
    }

    public void sing() {
        System.out.println("Bird sing...");
    }

    public void madeEggs() {
        System.out.println("1 egg...");
    }

    @Override
    public String toString() {
        return "This is a bird";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}