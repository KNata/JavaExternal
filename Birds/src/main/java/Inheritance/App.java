package Inheritance;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Bird theCuckoo = new Cuckoo();
        theCuckoo.fly();
        theCuckoo.sing();
        theCuckoo.madeEggs();
        System.out.println();
        Bird hen = new Hen();
        hen.sing();
        hen.madeEggs();
        hen.fly();
    }
}
