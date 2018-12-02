package CustomAnnotation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Adder add  = new Adder();
        CustomAnnotation myAnn = add.getClass().getAnnotation(CustomAnnotation.class);
        System.out.println("x = " + myAnn.firstConjuction());
        System.out.println("y = " + myAnn.secondConjucyion());
        System.out.println("x + y = " + add.addTwoNumbers());

    }
}
