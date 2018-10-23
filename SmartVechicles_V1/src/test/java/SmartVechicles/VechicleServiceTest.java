package SmartVechicles;

import SmartVechicles.View.VechicleService;
import org.junit.Test;

import SmartVechicles.Model.AmfibianCar;
import SmartVechicles.Model.BetMobile;
import SmartVechicles.Model.Car;
import SmartVechicles.Model.Plane;
import SmartVechicles.Model.Ship;
import SmartVechicles.Model.Vechicle;
import SmartVechicles.Model.Interfaces.IFlyvable;
import SmartVechicles.Model.Interfaces.IMovebble;
import SmartVechicles.Model.Interfaces.ISwimmable;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class VechicleServiceTest {

    @Test
    public void findPlanedByConditionSpeed() {
        Plane plane1 = new Plane(43.7, 233.3, 45600, 400, 2014, 500, 455.7);
        Plane plane2 = new Plane(21, 432, 65432, 550, 2018, 800, 6000);
        ArrayList<Plane> planeList = new ArrayList<Plane>();
        planeList.add(plane1);
        planeList.add(plane2);
        VechicleService theService = new VechicleService(planeList, null, null, null, null);
        double expectedPlaneSpeed = plane2.getVechicleSpeed();
        double actualPlaneSpeed = theService.findPlanedByConditions().get(0).getVechicleSpeed();

        assertEquals(actualPlaneSpeed, expectedPlaneSpeed, 0.001);
    }

    @Test
    public void findPlanedByConditionYear() {
        Plane plane1 = new Plane(43.7, 233.3, 45600, 400, 2014, 500, 455.7);
        Plane plane2 = new Plane(21, 432, 65432, 550, 2018, 800, 6000);
        ArrayList<Plane> planeList = new ArrayList<Plane>();
        planeList.add(plane1);
        planeList.add(plane2);
        VechicleService theService = new VechicleService(planeList, null, null, null, null);
        int expectedPlaneYear = plane2.getVechicleYearOfProduction();
        int actualPlaneYear = theService.findPlanedByConditions().get(0).getVechicleYearOfProduction();

        assertEquals(actualPlaneYear, expectedPlaneYear);
    }

    @Test
    public void returnListOfVechiclesWithMaxSppedExeptPlanes() {
        Car hundai = new Car(32.6, 100, 900000, 551, 2018);
        Ship ship2 = new Ship(0.6, 400.4, 780000, 500, 2010, 100, "Ostende");
        Plane plane3 = new Plane(43.7, 233.3, 23444, 600, 1999, 500, 9000.7);
        ArrayList<Vechicle> vechicleList = new ArrayList<Vechicle>();
        vechicleList.add(hundai);
        vechicleList.add(ship2);
        vechicleList.add(plane3);
        VechicleService theService = new VechicleService(null, vechicleList, null, null, null);
        double expectedResult = hundai.getVechicleSpeed();
        double actualResult = theService.returnListOfVechiclesWithMaxSppedExeptPlanes().get(0).getVechicleSpeed();

       // assertEquals(actualResult, expectedResult, 0.001);
    }

    @Test
    public void checkForMaxSpeedInMovableBetweenBetMobiles() {
        BetMobile betMobile1 = new BetMobile(32.2, 200, 45678888, 900, 2000);
        AmfibianCar amfibianCar1 = new AmfibianCar(32.0, 400, 60000, 500, 2009);
        BetMobile betMobile2 = new BetMobile(32.2, 200, 45678888, 800, 2000);
        ArrayList<IMovebble> movableList = new ArrayList<IMovebble>();
        movableList.add(betMobile1);
        movableList.add(amfibianCar1);
        movableList.add(betMobile2);
        VechicleService theService = new VechicleService(null, null, movableList, null, null);
        double expectedResult = betMobile1.getVechicleSpeed();
        double actualResult = theService.checkForMaxSpeedInMovableBetweenBetMobiles().get(1).getVechicleSpeed();

        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkForMaxSpeedInMovableBetweenAmphibianCars() {
        AmfibianCar amfibianCar1 = new AmfibianCar(32.0, 400, 60000, 500, 2009);
        BetMobile betMobile2 = new BetMobile(32.2, 200, 45678888, 800, 2000);
        AmfibianCar amfibianCar2 = new AmfibianCar(32.0, 400, 60000, 600, 2009);
        ArrayList<IMovebble> movableList = new ArrayList<IMovebble>();
        movableList.add(betMobile2);
        movableList.add(amfibianCar1);
        movableList.add(amfibianCar2);
        VechicleService theService = new VechicleService(null, null, movableList, null, null);
        double expectedResult = amfibianCar2.getVechicleSpeed();
        double actualResult = theService.checkForMaxSpeedInMovableBetweenAmphibianCars().get(1).getVechicleSpeed();

        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkForMaxSpeedInSwimmableBetweenBetMobiles() {
        BetMobile betMobile1 = new BetMobile(32.2, 200, 45678888, 900, 2000);
        AmfibianCar amfibianCar1 = new AmfibianCar(32.0, 400, 60000, 500, 2009);
        BetMobile betMobile2 = new BetMobile(32.2, 200, 45678888, 800, 2000);
        ArrayList<ISwimmable> swimmableList = new ArrayList<ISwimmable>();
        swimmableList.add(betMobile1);
        swimmableList.add(amfibianCar1);
        swimmableList.add(betMobile2);
        VechicleService theService = new VechicleService(null, null, null, swimmableList, null);
        double expectedResult = betMobile1.getVechicleSpeed();
        double actualResult = theService.checkForMaxSpeedInSwimmableBetweenBetMobiles().get(1).getVechicleSpeed();

        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkForMaxSpeedInSwimmableBetweenAmphibianCars() {
        AmfibianCar amfibianCar1 = new AmfibianCar(32.0, 400, 60000, 500, 2009);
        BetMobile betMobile2 = new BetMobile(32.2, 200, 45678888, 800, 2000);
        AmfibianCar amfibianCar2 = new AmfibianCar(32.0, 400, 60000, 600, 2009);
        ArrayList<ISwimmable> swimmableList = new ArrayList<ISwimmable>();
        swimmableList.add(betMobile2);
        swimmableList.add(amfibianCar1);
        swimmableList.add(amfibianCar2);
        VechicleService theService = new VechicleService(null, null, null, swimmableList, null);
        double expectedResult = amfibianCar2.getVechicleSpeed();
        double actualResult = theService.checkForMaxSpeedInSwimmableBetweenAmphibianCars().get(1).getVechicleSpeed();

        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkForMaxSpeedInSFlyvableBetweenBetMobiles() {
        BetMobile betMobile1 = new BetMobile(32.2, 200, 45678888, 900, 2000);
        BetMobile betMobile2 = new BetMobile(32.2, 200, 45678888, 800, 2000);
        ArrayList<IFlyvable> flyvableList = new ArrayList<IFlyvable>();
        flyvableList.add(betMobile1);
        flyvableList.add(betMobile2);
        VechicleService theService = new VechicleService(null, null, null, null, flyvableList);
        double expectedResult = betMobile1.getVechicleSpeed();
        double actualResult = theService.checkForMaxSpeedInSFlyvableBetweenBetMobiles().get(1).getVechicleSpeed();

        assertEquals(actualResult, expectedResult);
    }

    
}