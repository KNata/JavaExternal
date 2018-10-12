package Inheritance;

public class Hen extends Bird {

    Hen() {
        super();
        System.out.println("Hen was created...");
    }

    public void henEggs() {
        System.out.println("Hen eggs...");
    }

    @Override
    public void sing() {
        System.out.println("Hen sings...");
    }

    @Override
    public void fly() {
        System.out.println("Hen flies...");
    }
}