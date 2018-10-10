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
        theCuckoo.madeEggs();

        Bird hen = new Hen();
        hen.madeEggs();
        hen.fly();
    }
}
