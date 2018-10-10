package Inheritance;

public class Bird {

    private String name;

    Bird() {

    }

    public void fly() {
        System.out.println("Fly");
    }

    public void sing() {
        System.out.println("Doo Doo Doo");
    }

    public void madeEggs() {
        System.out.println("1 egg");
    }
}


/*
Создать объект класса Наседка, используя классы Птица, Кукушка.
Методы: летать, петь, нести яйца, высиживать птенцов.
 */