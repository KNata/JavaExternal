package Inheritance;


public class App 
{
    public static void main( String[] args )
    {
        Cuckoo theCuckoo = new Cuckoo();
        theCuckoo.fly();
        theCuckoo.sing();
        theCuckoo.madeEggs();

        System.out.println();
        Hen theHen = new Hen();
        theHen.sing();
        theHen.henEggs();
        theHen.fly();
    }
}
