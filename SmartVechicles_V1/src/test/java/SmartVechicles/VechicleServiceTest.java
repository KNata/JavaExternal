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
    public void findPlanedByConditionSpeedAndYearTrue() {
        Plane plane1 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(56000).setVechicleSpeed(1000)
                .setYearOfProduction(2018).setMaxCountOfPass(400).setMaxHeighUnderSea(7000.0).build();
        Plane plane2 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(6488).setVechicleSpeed(600)
                .setYearOfProduction(2000).setMaxCountOfPass(400).setMaxHeighUnderSea(1000.0).build();
        ArrayList<Plane> planeList = new ArrayList<Plane>();
        planeList.add(plane1);
        planeList.add(plane2);
        VechicleService theService = new VechicleService(planeList, null, null, null, null);
        double expectedPlaneSpeed = plane1.getVechicleSpeed();
        double actualPlaneSpeed = theService.findPlanedByConditions().get(0).getVechicleSpeed();

        assertEquals(actualPlaneSpeed, expectedPlaneSpeed, 0.001);
    }

  /*  @Test
    public void returnListOfVechiclesWithMaxSppedExeptPlanes() {
        Car hundai = Car.newBuilder().setPointX(21.5).setPointY(76.9).setVechiclePrice(900000).setVechicleSpeed(550)
                .setYearOfProduction(1999).build();
        Ship ship2 = Ship.newBuilder().setPointX(30.0).setPointY(30.0).setVechiclePrice(22778).setVechicleSpeed(200.0)
                .setYearOfProduction(2018).setMaxCountOfPass(600).setPortOfRegistration("Istambul").build();
        Plane plane3 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(6488).setVechicleSpeed(600)
                .setYearOfProduction(2000).setMaxCountOfPass(400).setMaxHeighUnderSea(1000.0).build();
        ArrayList<Vechicle> vechicleList = new ArrayList<Vechicle>();
        vechicleList.add(hundai);
        vechicleList.add(ship2);
        vechicleList.add(plane3);
        VechicleService theService = new VechicleService(null, vechicleList, null, null, null);
        double expectedResult = hundai.getVechicleSpeed();
        double actualResult = theService.returnListOfVechiclesWithMaxSppedExeptPlanes().get(0).getVechicleSpeed();

       // assertEquals(actualResult, expectedResult, 0.001);
    }
    */

    @Test
    public void checkForMaxSpeedInMovableBetweenBetMobiles() {
        BetMobile betMobile1 = new BetMobile();
        betMobile1.setPointX(32.2);
        betMobile1.setPointY(0.00);
        betMobile1.setVechiclePrice(23000.8);
        betMobile1.setVechicleSpeed(3000);
        betMobile1.setVechicleYearOfProduction(2017);

        AmfibianCar amfibianCar1 = new AmfibianCar();
        amfibianCar1.setPointX(0.00);
        amfibianCar1.setPointY(0.00);
        amfibianCar1.setVechiclePrice(20000);
        amfibianCar1.setVechicleSpeed(1000);
        amfibianCar1.setVechicleYearOfProduction(2018);

        BetMobile betMobile2 = new BetMobile();
        betMobile2.setPointX(132.2);
        betMobile2.setPointY(10.00);
        betMobile2.setVechiclePrice(10000.8);
        betMobile2.setVechicleSpeed(2000);
        betMobile2.setVechicleYearOfProduction(2019);

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
        AmfibianCar amfibianCar1 = new AmfibianCar();
        amfibianCar1.setPointX(0.00);
        amfibianCar1.setPointY(0.00);
        amfibianCar1.setVechiclePrice(20000);
        amfibianCar1.setVechicleSpeed(1000);
        amfibianCar1.setVechicleYearOfProduction(2018);

        BetMobile betMobile2 = new BetMobile();
        betMobile2.setPointX(132.2);
        betMobile2.setPointY(10.00);
        betMobile2.setVechiclePrice(10000.8);
        betMobile2.setVechicleSpeed(2000);
        betMobile2.setVechicleYearOfProduction(2019);


        AmfibianCar amfibianCar2 = new AmfibianCar();
        amfibianCar2.setPointX(0.00);
        amfibianCar2.setPointY(0.00);
        amfibianCar2.setVechiclePrice(10000);
        amfibianCar2.setVechicleSpeed(300);
        amfibianCar2.setVechicleYearOfProduction(2014);

        ArrayList<IMovebble> movableList = new ArrayList<IMovebble>();
        movableList.add(betMobile2);
        movableList.add(amfibianCar1);
        movableList.add(amfibianCar2);
        VechicleService theService = new VechicleService(null, null, movableList, null, null);
        double expectedResult = amfibianCar1.getVechicleSpeed();
        double actualResult = theService.checkForMaxSpeedInMovableBetweenAmphibianCars().get(1).getVechicleSpeed();

        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkForMaxSpeedInSwimmableBetweenBetMobiles() {
        BetMobile betMobile1 = new BetMobile();
        betMobile1.setPointX(32.2);
        betMobile1.setPointY(0.00);
        betMobile1.setVechiclePrice(23000.8);
        betMobile1.setVechicleSpeed(3000);
        betMobile1.setVechicleYearOfProduction(2017);

        AmfibianCar amfibianCar1 = new AmfibianCar();
        amfibianCar1.setPointX(0.00);
        amfibianCar1.setPointY(0.00);
        amfibianCar1.setVechiclePrice(20000);
        amfibianCar1.setVechicleSpeed(1000);
        amfibianCar1.setVechicleYearOfProduction(2018);

        BetMobile betMobile2 = new BetMobile();
        betMobile2.setPointX(132.2);
        betMobile2.setPointY(10.00);
        betMobile2.setVechiclePrice(10000.8);
        betMobile2.setVechicleSpeed(2000);
        betMobile2.setVechicleYearOfProduction(2019);

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
        AmfibianCar amfibianCar1 = new AmfibianCar();
        amfibianCar1.setPointX(0.00);
        amfibianCar1.setPointY(0.00);
        amfibianCar1.setVechiclePrice(20000);
        amfibianCar1.setVechicleSpeed(1000);
        amfibianCar1.setVechicleYearOfProduction(2018);

        BetMobile betMobile2 = new BetMobile();
        betMobile2.setPointX(132.2);
        betMobile2.setPointY(10.00);
        betMobile2.setVechiclePrice(10000.8);
        betMobile2.setVechicleSpeed(2000);
        betMobile2.setVechicleYearOfProduction(2019);


        AmfibianCar amfibianCar2 = new AmfibianCar();
        amfibianCar2.setPointX(0.00);
        amfibianCar2.setPointY(0.00);
        amfibianCar2.setVechiclePrice(10000);
        amfibianCar2.setVechicleSpeed(300);
        amfibianCar2.setVechicleYearOfProduction(2014);

        ArrayList<ISwimmable> swimmableList = new ArrayList<ISwimmable>();
        swimmableList.add(betMobile2);
        swimmableList.add(amfibianCar1);
        swimmableList.add(amfibianCar2);
        VechicleService theService = new VechicleService(null, null, null, swimmableList, null);
        double expectedResult = amfibianCar1.getVechicleSpeed();
        double actualResult = theService.checkForMaxSpeedInSwimmableBetweenAmphibianCars().get(1).getVechicleSpeed();

        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkForMaxSpeedInSFlyvableBetweenBetMobiles() {
        BetMobile betMobile1 = new BetMobile();
        betMobile1.setPointX(32.2);
        betMobile1.setPointY(0.00);
        betMobile1.setVechiclePrice(23000.8);
        betMobile1.setVechicleSpeed(3000);
        betMobile1.setVechicleYearOfProduction(2017);

        BetMobile betMobile2 = new BetMobile();
        betMobile2.setPointX(132.2);
        betMobile2.setPointY(10.00);
        betMobile2.setVechiclePrice(10000.8);
        betMobile2.setVechicleSpeed(2000);
        betMobile2.setVechicleYearOfProduction(2019);

        ArrayList<IFlyvable> flyvableList = new ArrayList<IFlyvable>();
        flyvableList.add(betMobile1);
        flyvableList.add(betMobile2);
        VechicleService theService = new VechicleService(null, null, null, null, flyvableList);
        double expectedResult = betMobile1.getVechicleSpeed();
        double actualResult = theService.checkForMaxSpeedInSFlyvableBetweenBetMobiles().get(1).getVechicleSpeed();

        assertEquals(actualResult, expectedResult);
    }

    
}