package Inheritance;

public class Cuckoo extends Bird {

    Cuckoo() {
        super();
    }

    @Override
    public void fly() {
        System.out.println("Cuckoo fly");
    }

    @Override
    public void sing() {
        System.out.println("Cuckoo sing");
    }

    @Override
    public void madeEggs() {
        System.out.println("Cuckoo's eggs");
    }
}
