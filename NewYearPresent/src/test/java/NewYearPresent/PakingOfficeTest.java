package NewYearPresent;

import NewYearPresent.Candies.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PakingOfficeTest {


    @Test
    public void findNeededCandy() {
        StarLight starLight1 = new StarLight("Star Light", 20, 34, 60.5, false, true);
        Truffels truffel1 = new Truffels("Truffels", 10, 24, 100, false, true);
        Marmelove marmelove1 = new Marmelove("Marmelove", 20, 49, 20, false, false);
        Wanner wanner = new Wanner("Wanner", 100, 46, 40, true);

        ArrayList<Candy> candyList = new ArrayList<Candy>();
        candyList.add(starLight1);
        candyList.add(marmelove1);
        candyList.add(wanner);
        candyList.add(truffel1);

        PakingOffice theOffice = new PakingOffice(candyList, null);
        Candy actualCandy = theOffice.findNeededCandy(20, 50);
        int expectedValue = 24;

        assertEquals(actualCandy.getCountOfSugar(), expectedValue);
    }
}