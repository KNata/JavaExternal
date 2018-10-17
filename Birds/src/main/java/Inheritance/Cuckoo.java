package Inheritance;

public class Cuckoo extends Bird {

    Cuckoo() {
        super();
        System.out.println("Cuckoo was created...");
    }

    @Override
    public void fly() {
        System.out.println("Cuckoo flies...");
    }

    @Override
    public void sing() {
        System.out.println("Cuckoo sings...");
    }

    @Override
    public void madeEggs() {
        System.out.println("Cuckoo's eggs...");
    }

    @Override
    public String toString() {
        return "This is cuckoo";
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
