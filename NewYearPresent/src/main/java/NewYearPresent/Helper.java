package NewYearPresent;

import NewYearPresent.Candies.*;
import NewYearPresent.Exeptions.InvalidInputExeption;
import NewYearPresent.Fruits.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Helper {

    Helper() {}

    public void runner() {
        StarLight starLight1 = new StarLight("Star Light", 20, 34, 60.5, false, true);
        StarLight starLight2 = new StarLight("Star Light", 20, 34, 60.5, false, true);
        StarLight starLight3 = new StarLight("Star Light", 20, 34, 60.5, false, true);
        StarLight starLight4 = new StarLight("Star Light", 20, 34, 60.5, false, true);
        StarLight starLight5 = new StarLight("Star Light", 20, 34, 60.5, false, true);
        StarLight starLight6 = new StarLight("Star Light", 20, 34, 60.5, false, true);
        StarLight starLight7 = new StarLight("Star Light", 20, 34, 60.5, false, true);

        Truffels truffel1 = new Truffels("Truffels", 10, 24, 100, false, true);
        Truffels truffel2 = new Truffels("Truffels", 10, 33, 100, false, true);
        Truffels truffel3 = new Truffels("Truffels", 10, 21, 100, false, true);
        Truffels truffel4 = new Truffels("Truffels", 10, 90, 100, false, true);
        Truffels truffel5 = new Truffels("Truffels", 10, 11, 100, false, true);

        Wanner wanner = new Wanner("Wanner", 100, 46, 40, true);

        Marmelove marmelove1 = new Marmelove("Marmelove", 20, 49, 20, false, false);
        Marmelove marmelove2 = new Marmelove("Marmelove", 20, 49, 20, false, false);
        Marmelove marmelove3 = new Marmelove("Marmelove", 20, 49, 20, false, false);
        Marmelove marmelove4 = new Marmelove("Marmelove", 20, 49, 20, false, false);
        Marmelove marmelove5 = new Marmelove("Marmelove", 20, 49, 20, false, false);

        ArrayList<Candy> candiesList = new ArrayList<Candy>();
        candiesList.add(starLight1);
        candiesList.add(starLight2);
        candiesList.add(starLight3);
        candiesList.add(starLight4);
        candiesList.add(starLight5);
        candiesList.add(starLight6);
        candiesList.add(starLight7);
        candiesList.add(wanner);
        candiesList.add(truffel1);
        candiesList.add(truffel2);
        candiesList.add(truffel3);
        candiesList.add(truffel4);
        candiesList.add(truffel5);
        candiesList.add(marmelove1);
        candiesList.add(marmelove2);
        candiesList.add(marmelove3);
        candiesList.add(marmelove4);
        candiesList.add(marmelove5);

        Banana banana1 = new Banana("Banana", 65, 59, 45.6);
        Banana banana2 = new Banana("Banana", 65, 59, 45.6);
        Banana banana3 = new Banana("Banana", 65, 59, 45.6);
        Banana banana4 = new Banana("Banana", 65, 59, 45.6);
        Banana banana5 = new Banana("Banana", 65, 59, 45.6);

        Tangerine tangerine1 = new Tangerine("Tangerine", 20, 34, 20);
        Tangerine tangerine2 = new Tangerine("Tangerine", 20, 34, 20);
        Tangerine tangerine3 = new Tangerine("Tangerine", 20, 34, 20);
        Tangerine tangerine4 = new Tangerine("Tangerine", 20, 34, 20);
        Tangerine tangerine5 = new Tangerine("Tangerine", 20, 34, 20);

        Kiwi kiwi1 = new Kiwi("Kiwi", 45, 70, 70);
        Kiwi kiwi2 = new Kiwi("Kiwi", 45, 70, 70);
        Kiwi kiwi3 = new Kiwi("Kiwi", 45, 70, 70);
        Kiwi kiwi4 = new Kiwi("Kiwi", 45, 70, 70);
        Kiwi kiwi5 = new Kiwi("Kiwi", 45, 70, 70);
        Kiwi kiwi6 = new Kiwi("Kiwi", 45, 70, 70);

        ArrayList<Fruits> fruitList = new ArrayList<Fruits>();
        fruitList.add(banana1);
        fruitList.add(banana2);
        fruitList.add(banana3);
        fruitList.add(banana4);
        fruitList.add(banana5);
        fruitList.add(tangerine1);
        fruitList.add(tangerine2);
        fruitList.add(tangerine3);
        fruitList.add(tangerine4);
        fruitList.add(tangerine5);
        fruitList.add(kiwi1);
        fruitList.add(kiwi2);
        fruitList.add(kiwi3);
        fruitList.add(kiwi4);
        fruitList.add(kiwi5);
        fruitList.add(kiwi6);

        PakingOffice theOffice = new PakingOffice(candiesList, fruitList);
        Scanner theScanner = new Scanner(System.in);
        System.out.println("Enter min count of sugar: ");
        String minCountOfSugarinCandy = theScanner.nextLine();
        if (!minCountOfSugarinCandy.matches("-?\\d+")) {
            throw new InvalidInputExeption("You need to enter a numbers");
        }
        System.out.println("Enter max count of sugar: ");
        String maxCountOfSugarinCandy = theScanner.nextLine();
        if (!maxCountOfSugarinCandy.matches("-?\\d+")) {
            throw new InvalidInputExeption("You need to enter a numbers");
        }
        if (Integer.parseInt(minCountOfSugarinCandy) > Integer.parseInt(maxCountOfSugarinCandy)) {
            throw new InvalidInputExeption("min count of sugar is bigger then max count of sugar");
        }
        theOffice.sortCandies();
        Candy theCandy = theOffice.findNeededCandy(Integer.parseInt(minCountOfSugarinCandy), Integer.parseInt(maxCountOfSugarinCandy));
        System.out.println("Found candy: " + theCandy.getCandyName() + " has sugar: " + theCandy.getCountOfSugar());
        System.out.println("Found List of candies in range [" + Integer.parseInt(minCountOfSugarinCandy) + "; "
                + Integer.parseInt(maxCountOfSugarinCandy) + "]");
        ArrayList<Candy> listOfCandiesInRange = theOffice.findNeededCandies(Integer.parseInt(minCountOfSugarinCandy),
                Integer.parseInt(maxCountOfSugarinCandy));
        for (Candy c : listOfCandiesInRange) {
            System.out.println(c.getCandyName() + " with sugar: " + c.getCountOfSugar());
        }
        System.out.println();
        System.out.println("Sweet pack of candies");
        ArrayList<Candy> newYearPackageList = theOffice.generatePackOfCandies();
        for (Candy c : newYearPackageList) {
            System.out.println(c.getCandyName());
        }
        System.out.println();
        System.out.println();
        System.out.println("Sweet pack of candies");
        ArrayList<Fruits> newYearPackageListOfFruts = theOffice.generatePackOfFruit();
        for (Fruits c : newYearPackageListOfFruts) {
            System.out.println(c.getFryitName());
        }

    }
}
