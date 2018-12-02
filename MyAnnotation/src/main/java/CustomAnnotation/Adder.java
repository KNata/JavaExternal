package CustomAnnotation;

@CustomAnnotation(firstConjuction = 2.0, secondConjucyion = 2.0)
public class Adder {

    public Adder() {
    }

    public double addTwoNumbers() {
        CustomAnnotation myAnn = this.getClass().getAnnotation(CustomAnnotation.class);
        return myAnn.firstConjuction() + myAnn.secondConjucyion();
    }
}
