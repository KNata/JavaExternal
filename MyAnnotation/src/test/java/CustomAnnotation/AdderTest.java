package CustomAnnotation;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdderTest {


    @Test
    public void addTwoNumbers() {
        Adder adder = new Adder();
        assertEquals(4, adder.addTwoNumbers(), 0.00001);
    }
}