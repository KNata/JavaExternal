package SmartVechicles.Init;

import java.util.ArrayList;

import SmartVechicles.Controller.VechicleController;
import SmartVechicles.Model.*;
import SmartVechicles.Model.Interfaces.*;
import SmartVechicles.View.VechicleService;

/**
 * Hello world!
 *
 */
public class App1
{
    public static void main( String[] args )
    {
        // init data
        ArrayList<Plane> planeList = new ArrayList<Plane>();
        ArrayList<Vechicle> vechicleList = new ArrayList<Vechicle>();
        initTypicalVechicles(vechicleList, planeList);
        ArrayList<IMovebble> movableList = new ArrayList<IMovebble>();
        ArrayList<IFlyvable> flyvableList = new ArrayList<IFlyvable>();
        ArrayList<ISwimmable> swimmableList = new ArrayList<ISwimmable>();
        initSuperCars(movableList, flyvableList, swimmableList);

        // service
        VechicleService theService = new VechicleService(planeList, vechicleList, movableList, swimmableList, flyvableList);
        VechicleController theControler = new VechicleController(theService);
        ArrayList<Plane> planeResList = theControler.findPlanedByConditions();
        for (int i = 0; i < planeResList.size(); i++) {
            System.out.println("Plane with height under sea " + planeResList.get(i).getHeighOfFlightUnderSea() +
                    " and " + planeResList.get(i).getVechicleYearOfProduction() + " year of production");
        }
//        System.out.println();
//        System.out.println("Vechicles with max speed:");
//        ArrayList<Vechicle> vechicleResList = theControler.returnListOfVechiclesWithMaxSppedExeptPlanes();
//        for (int i = 0; i < vechicleList.size()-1; i++) {
//            System.out.println(i+1 + ". " + vechicleResList.get(i).getVechicleSpeed() + "(" + vechicleResList.get(i).getClass() + ")");
//        }
        System.out.println();
        System.out.println("Interface IMovable");
        ArrayList<BetMobile> bmList = theControler.checkInstanceOfIMovebbleInterfaceToBetmobile();
        System.out.println("Bet Mobile with max speed " + bmList.get(0).getVechicleSpeed());
        ArrayList<AmfibianCar> amList = theControler.checkInstanceOfIMovebbleInterfaceToAmphibianCar();
        System.out.println("Amphibian car with max speed " + amList.get(0).getVechicleSpeed());

        System.out.println();
        System.out.println("Interface IFlywable");
        ArrayList<BetMobile> bmListF = theControler.checkInstanceOfIFlyvableInterfaceToBetmobile();
        System.out.println("Bet Mobile with max speed " + bmListF.get(0).getVechicleSpeed());

        System.out.println();
        System.out.println("Interface ISwimable");
        ArrayList<BetMobile> bmListS = theControler.checkForMaxSpeedInSwimmableBetweenBetMobiles();
        System.out.println("Bet Mobile with max speed " + bmListS.get(0).getVechicleSpeed());
        ArrayList<AmfibianCar> amListS = theControler.checkInstanceOfISwimableInterfaceToAmphibianCar();
        System.out.println("Amphibian car with max speed " + amListS.get(0).getVechicleSpeed());
        /*
         */
    }

    public static void initTypicalVechicles(ArrayList<Vechicle> vechicleList, ArrayList<Plane> planeList) {

        // create cars
        Car bmw = new Car(32.6, 100, 34000, 200, 2018);
        Car audi = new Car(0.0, 200, 100000, 550, 2010);
        Car toyota = new Car(1.6, 9000.8, 76000, 700, 2018);
        Car hundai = new Car(32.6, 100, 900000, 551, 2018);
        Car pegeoue = new Car(32.6, 100, 87655, 300, 2018);
        Car porshe = new Car(32.6, 100, 34000, 200, 2018);

        // create ships
        Ship ship1 = new Ship(32.6, 44.4, 230000, 300, 1999, 200, "Edinburg");
        Ship ship2 = new Ship(0.6, 400.4, 780000, 500, 2010, 100, "Ostende");
        Ship ship3 = new Ship(322.6, 1000.4, 100000, 550, 2018, 200, "Odessa");
        Ship ship4 = new Ship(90.6, 900.4, 632456, 330, 2017, 200, "Gdansk");
        Ship ship5 = new Ship(32.6, 44.4, 230000, 300, 1999, 200, "Edinburg");
        Ship ship6 = new Ship(345, 0.02, 123487, 700, 1999, 200, "Kherson");

        // create planes
        Plane plane1 = new Plane(43.7, 233.3, 45600, 400, 2019, 500, 455.7);
        Plane plane2 = new Plane(21, 432, 65432, 550, 2014, 800, 6000);
        Plane plane3 = new Plane(43.7, 233.3, 23444, 600, 1999, 500, 9000.7);
        Plane plane4 = new Plane(43.7, 233.3, 100000, 400, 2013, 500, 9001.7);
        Plane plane5 = new Plane(43.7, 233.3, 45600, 400, 2019, 500, 455.7);
        Plane plane6 = new Plane(43.7, 233.3, 45600, 400, 2019, 500, 8000);

        planeList.add(plane1);
        planeList.add(plane2);
        planeList.add(plane3);
        planeList.add(plane4);
        planeList.add(plane5);
        planeList.add(plane6);

        vechicleList.add(pegeoue);
        vechicleList.add(porshe);
        vechicleList.add(plane1);
        vechicleList.add(plane2);
        vechicleList.add(plane3);
        vechicleList.add(plane4);
        vechicleList.add(plane5);
        vechicleList.add(plane6);
        vechicleList.add(ship1);
        vechicleList.add(ship2);
        vechicleList.add(ship3);
        vechicleList.add(ship4);
        vechicleList.add(ship5);
        vechicleList.add(ship6);
        vechicleList.add(bmw);
        vechicleList.add(audi);
        vechicleList.add(toyota);
        vechicleList.add(hundai);
    }

    public static void initSuperCars(ArrayList<IMovebble> movableList, ArrayList<IFlyvable> flyvableList, ArrayList<ISwimmable> swimmableList) {
        BetMobile betMobile1 = new BetMobile(32.2, 200, 45678888, 900, 2000);
        AmfibianCar amfibianCar1 = new AmfibianCar(32.0, 400, 60000, 500, 2009);
        BetMobile betMobile2 = new BetMobile(32.2, 200, 45678888, 800, 2000);
        AmfibianCar amfibianCar2 = new AmfibianCar(32.0, 400, 60000, 500, 2009);
        BetMobile betMobile3 = new BetMobile(32.2, 200, 45678888, 700, 2000);
        AmfibianCar amfibianCar3 = new AmfibianCar(32.0, 400, 60000, 500, 2009);
        BetMobile betMobile4 = new BetMobile(32.2, 200, 45678888, 100, 2000);
        AmfibianCar amfibianCar4 = new AmfibianCar(32.0, 400, 60000, 500, 2009);

        movableList.add(betMobile1);
        movableList.add(amfibianCar1);
        movableList.add(betMobile2);
        movableList.add(betMobile4);
        movableList.add(amfibianCar4);
        movableList.add(amfibianCar3);
        movableList.add(amfibianCar2);

        flyvableList.add(betMobile1);
        flyvableList.add(betMobile3);
        flyvableList.add(betMobile2);
        flyvableList.add(betMobile4);

        swimmableList.add(betMobile1);
        swimmableList.add(amfibianCar1);
        swimmableList.add(amfibianCar2);
        swimmableList.add(amfibianCar3);
        swimmableList.add(betMobile3);


    }

}
