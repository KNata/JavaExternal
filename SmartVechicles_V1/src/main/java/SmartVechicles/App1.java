package SmartVechicles;


import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import SmartVechicles.Controller.VechicleController;
import SmartVechicles.CustomExeptions.NoCurrentLanguageExeption;
import SmartVechicles.Model.*;
import SmartVechicles.Model.Interfaces.*;
import SmartVechicles.View.VechicleService;


public class App1
{
    public static void main( String[] args )
    {
        Locale theLocale = Locale.getDefault();
        ResourceBundle currentLanguageBungle;
        System.out.println("Choose the interface language");
        System.out.println("To choose Ukrainian language, press 1");
        System.out.println("To choose English language, press 2");
        System.out.println("To choose Polish language, press 3");
        System.out.println("To choose Russian language, press 4");


            Scanner sc = new Scanner(System.in);
            int codeToChoose = sc.nextInt();
            if (codeToChoose > 4) {
                new NoCurrentLanguageExeption("No such language avaliable. Please enter 1-4 to choose preferable language of interface");
            }
            if (codeToChoose == 1) {
                theLocale = new Locale("");
                currentLanguageBungle = ResourceBundle.getBundle(
                        "languageUA", theLocale);
                doInternalizedService(currentLanguageBungle);
            } else if (codeToChoose == 2) {
                theLocale = new Locale("EN");
                currentLanguageBungle = ResourceBundle.getBundle(
                        "languageEN", theLocale);
                doInternalizedService(currentLanguageBungle);
            } else if (codeToChoose == 3) {
                theLocale = new Locale("PL");
                currentLanguageBungle = ResourceBundle.getBundle(
                        "languagePL", theLocale);
                doInternalizedService(currentLanguageBungle);
            } else if (codeToChoose == 4) {
                theLocale = new Locale("RU");
                currentLanguageBungle = ResourceBundle.getBundle(
                        "languageRU", theLocale);
                doInternalizedService(currentLanguageBungle);
            }
    }


    public static void initTypicalVechicles(ArrayList<Vechicle> vechicleList, ArrayList<Plane> planeList) {

        // create cars

        Car bmw = Car.newBuilder().setPointX(43.9).setPointY(0).setVechiclePrice(222222.8).setVechicleSpeed(100)
                .setYearOfProduction(2009).build();
        Car audi = Car.newBuilder().setPointX(21.5).setPointY(76.9).setVechiclePrice(563634).setVechicleSpeed(200)
                .setYearOfProduction(2018).build();
        Car toyota = Car.newBuilder().setPointX(00.00).setPointY(00.00).setVechiclePrice(10000).setVechicleSpeed(5000)
                .setYearOfProduction(2000).build();
        Car hundai = Car.newBuilder().setPointX(21.5).setPointY(76.9).setVechiclePrice(21899).setVechicleSpeed(400)
                .setYearOfProduction(2016).build();
        Car pegeoue = Car.newBuilder().setPointX(21.5).setPointY(76.9).setVechiclePrice(20999).setVechicleSpeed(100)
                .setYearOfProduction(2007).build();
        Car porshe = Car.newBuilder().setPointX(21.5).setPointY(76.9).setVechiclePrice(900000).setVechicleSpeed(550)
                .setYearOfProduction(1999).build();

        // create ships
        Ship ship1 = Ship.newBuilder().setPointX(30.0).setPointY(30.0).setVechiclePrice(30000).setVechicleSpeed(400.0)
                .setYearOfProduction(2018).setMaxCountOfPass(300).setPortOfRegistration("Ostende").build();
        Ship ship2 = Ship.newBuilder().setPointX(30.0).setPointY(30.0).setVechiclePrice(67899).setVechicleSpeed(500.9)
                .setYearOfProduction(2017).setMaxCountOfPass(100).setPortOfRegistration("Edinburg").build();
        Ship ship3 = Ship.newBuilder().setPointX(30.0).setPointY(30.0).setVechiclePrice(23000).setVechicleSpeed(400.0)
                .setYearOfProduction(2000).setMaxCountOfPass(600).setPortOfRegistration("Odessa").build();
        Ship ship4 = Ship.newBuilder().setPointX(30.0).setPointY(30.0).setVechiclePrice(12000).setVechicleSpeed(1000.0)
                .setYearOfProduction(1998).setMaxCountOfPass(300).setPortOfRegistration("Mikolaiv").build();
        Ship ship5 = Ship.newBuilder().setPointX(30.0).setPointY(30.0).setVechiclePrice(56666).setVechicleSpeed(900.0)
                .setYearOfProduction(2003).setMaxCountOfPass(260).setPortOfRegistration("Kherson").build();
        Ship ship6 = Ship.newBuilder().setPointX(30.0).setPointY(30.0).setVechiclePrice(22778).setVechicleSpeed(200.0)
                .setYearOfProduction(2018).setMaxCountOfPass(600).setPortOfRegistration("Istambul").build();

        // create planes
        Plane plane1 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(56000).setVechicleSpeed(1000)
                .setYearOfProduction(2018).setMaxCountOfPass(400).setMaxHeighUnderSea(6000.0).build();
        Plane plane2 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(6488).setVechicleSpeed(600)
                .setYearOfProduction(2000).setMaxCountOfPass(400).setMaxHeighUnderSea(7000.0).build();
        Plane plane3 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(239000).setVechicleSpeed(2000)
                .setYearOfProduction(2011).setMaxCountOfPass(200).setMaxHeighUnderSea(1000.0).build();
        Plane plane4 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(123455).setVechicleSpeed(400)
                .setYearOfProduction(2001).setMaxCountOfPass(300).setMaxHeighUnderSea(5000.0).build();
        Plane plane5 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(90000).setVechicleSpeed(900)
                .setYearOfProduction(2014).setMaxCountOfPass(1000).setMaxHeighUnderSea(4000.0).build();
        Plane plane6 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(100000).setVechicleSpeed(9000)
                .setYearOfProduction(2018).setMaxCountOfPass(4000).setMaxHeighUnderSea(1000.9).build();

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


        AmfibianCar amfibianCar2 = new AmfibianCar();
        amfibianCar2.setPointX(0.00);
        amfibianCar2.setPointY(0.00);
        amfibianCar2.setVechiclePrice(10000);
        amfibianCar2.setVechicleSpeed(300);
        amfibianCar2.setVechicleYearOfProduction(2014);

        BetMobile betMobile3 = new BetMobile();
        betMobile3.setPointX(0.2);
        betMobile3.setPointY(0.00);
        betMobile3.setVechiclePrice(10000);
        betMobile3.setVechicleSpeed(2000);
        betMobile3.setVechicleYearOfProduction(2016);

        AmfibianCar amfibianCar3 = new AmfibianCar();
        amfibianCar3.setPointX(0.00);
        amfibianCar3.setPointY(0.00);
        amfibianCar3.setVechiclePrice(20000);
        amfibianCar3.setVechicleSpeed(800);
        amfibianCar3.setVechicleYearOfProduction(2016);

        BetMobile betMobile4 = new BetMobile();
        betMobile4.setPointX(0.2);
        betMobile4.setPointY(0.00);
        betMobile4.setVechiclePrice(10000);
        betMobile4.setVechicleSpeed(1000);
        betMobile4.setVechicleYearOfProduction(1018);

        AmfibianCar amfibianCar4 = new AmfibianCar();

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

    public static void doInternalizedService(ResourceBundle aCurrentLanguageBungle) {

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
            System.out.println(aCurrentLanguageBungle.getString("Plane") + " "+
                    aCurrentLanguageBungle.getString("with") + " " + aCurrentLanguageBungle.getString("height") +
                    " " + aCurrentLanguageBungle.getString("under")+ " "+ aCurrentLanguageBungle.getString("sea") +
                    " "+ planeResList.get(i).getHeighOfFlightUnderSea() +
                    " " + aCurrentLanguageBungle.getString("and") + " " + planeResList.get(i).getVechicleYearOfProduction()
                    + " " + aCurrentLanguageBungle.getString("year") + " " + aCurrentLanguageBungle.getString("of")
                    + " "+ aCurrentLanguageBungle.getString("production"));
        }

        System.out.println();
        System.out.println(aCurrentLanguageBungle.getString("Vechicles") + " " +
                aCurrentLanguageBungle.getString("with") + " " + aCurrentLanguageBungle.getString("max") + " "
                + aCurrentLanguageBungle.getString("speed") + ":");
        ArrayList<Vechicle> vechicleResList = theControler.returnListOfVechiclesWithMaxSppedExeptPlanes();
        for (int i = 0; i < vechicleResList.size(); i++) {
            System.out.println(vechicleResList.get(i).toString());
        }
        System.out.println();
        System.out.println(aCurrentLanguageBungle.getString("Interface") + " IMovable");
        ArrayList<BetMobile> bmList = theControler.checkInstanceOfIMovebbleInterfaceToBetmobile();
        System.out.println(aCurrentLanguageBungle.getString("with") +  aCurrentLanguageBungle.getString("max") +
                " " + aCurrentLanguageBungle.getString("speed") + " " + bmList.get(0).getVechicleSpeed());
        ArrayList<AmfibianCar> amList = theControler.checkInstanceOfIMovebbleInterfaceToAmphibianCar();
        System.out.println("Amphibian car " + aCurrentLanguageBungle.getString("with") + " " + aCurrentLanguageBungle.getString("max")
                + " " + aCurrentLanguageBungle.getString("speed") +  " "+ amList.get(0).getVechicleSpeed());

        System.out.println();
        System.out.println(aCurrentLanguageBungle.getString("Interface") + " IFlywable");
        ArrayList<BetMobile> bmListF = theControler.checkInstanceOfIFlyvableInterfaceToBetmobile();
        System.out.println("Bet Mobile " + aCurrentLanguageBungle.getString("with") + " " +
                aCurrentLanguageBungle.getString("max") + " " + aCurrentLanguageBungle.getString("speed") +
                " " + bmListF.get(0).getVechicleSpeed());

        System.out.println();
        System.out.println(aCurrentLanguageBungle.getString("Interface") + " ISwimable");
        ArrayList<BetMobile> bmListS = theControler.checkForMaxSpeedInSwimmableBetweenBetMobiles();
        System.out.println("Bet Mobile " + aCurrentLanguageBungle.getString("with")  + " " +
                aCurrentLanguageBungle.getString("max") + " " + aCurrentLanguageBungle.getString("speed") + " "
                + bmListS.get(0).getVechicleSpeed());
        ArrayList<AmfibianCar> amListS = theControler.checkInstanceOfISwimableInterfaceToAmphibianCar();
        System.out.println("Amphibian car " + aCurrentLanguageBungle.getString("with") + " " +
                aCurrentLanguageBungle.getString("max") +  " " + aCurrentLanguageBungle.getString("speed")
                + " " + amListS.get(0).getVechicleSpeed());

    }
}
