package NewYearPresent;

import NewYearPresent.Candies.*;
import NewYearPresent.Exeptions.CandyNotFoundExeption;
import NewYearPresent.Fruits.Banana;
import NewYearPresent.Fruits.Fruits;
import NewYearPresent.Fruits.Kiwi;
import NewYearPresent.Fruits.Tangerine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PakingOffice {

    private ArrayList<Candy> candyList;
    private ArrayList<Fruits> fruitList;

    private static int MIN_COUNT_OF_OBJECTS_IN_PRESENT_PACK = 6;
    private static int MAX_COUNT_OF_OBJECTS_IN_PRESENT_PACK = 50;


    PakingOffice(ArrayList<Candy> aCandyList, ArrayList<Fruits> aFruitList) {
        candyList = aCandyList;
        fruitList = aFruitList;
    }

    public void sortCandies() {
        Collections.sort(candyList, Candy.candyComparator);
    }

    public Candy findNeededCandy(int minCountOfSugar, int maxCountOfSugar) {
        Candy resultCandy = null;
        for (int i = 0; i < candyList.size(); i++) {
            if (candyList.get(i).getCountOfSugar() >= minCountOfSugar && candyList.get(i).getCountOfSugar() <= maxCountOfSugar ) {
                resultCandy = candyList.get(i);
            }
        }
        if (resultCandy == null) {
            throw new CandyNotFoundExeption("Wrong parameters. Try again");
        }
        return resultCandy;
    }

    public ArrayList<Candy> findNeededCandies(int minCountOfSugar, int maxCountOfSugar) {
        ArrayList<Candy> resultListOfCandies = new ArrayList<Candy>();
        for (int i = 0; i < candyList.size(); i++) {
            if (candyList.get(i).getCountOfSugar() >= minCountOfSugar && candyList.get(i).getCountOfSugar() <= maxCountOfSugar ) {
                resultListOfCandies.add(candyList.get(i));            }
        }
        if (resultListOfCandies == null) {
            throw new CandyNotFoundExeption("Wrong parameters. Try again");
        }
        return resultListOfCandies;
    }

    public ArrayList<Candy> generatePackOfCandies() {
        ArrayList<Candy> candyPresentPack = new ArrayList<Candy>();
        Collections.shuffle(candyList);
        int randCountOfSweets = (int)Math.random()*MAX_COUNT_OF_OBJECTS_IN_PRESENT_PACK + MIN_COUNT_OF_OBJECTS_IN_PRESENT_PACK;
        int sameCountOfSweets = randCountOfSweets / 3;
        for (int i = 0; i < randCountOfSweets; i++) {
            if (candyList.get(i) instanceof StarLight) {
                for (int j = 0; j < sameCountOfSweets; j++) {
                    candyPresentPack.add(candyList.get(i));
                }
            }
            if (candyList.get(i) instanceof Marmelove) {
                for (int j = 0; j < sameCountOfSweets; j++) {
                    candyPresentPack.add(candyList.get(i));
                }
            }
            if (candyList.get(i) instanceof Truffels) {
                for (int j = 0; j < sameCountOfSweets; j++) {
                    candyPresentPack.add(candyList.get(i));
                }
            }
            if (candyList.get(i) instanceof Wanner) {
                candyPresentPack.add(candyList.get(i));
            }
        }
        return candyPresentPack;
    }

    public ArrayList<Fruits> generatePackOfFruit() {
        ArrayList<Fruits> fruitPresentPack = new ArrayList<Fruits>();
        Collections.shuffle(fruitList);
        int randCountOfFruit = (int)Math.random()*MAX_COUNT_OF_OBJECTS_IN_PRESENT_PACK + MIN_COUNT_OF_OBJECTS_IN_PRESENT_PACK;
        int sameCountOfFruit = randCountOfFruit / 3;
        for (int i = 0; i < sameCountOfFruit; i++) {
            if (fruitList.get(i) instanceof Banana) {
                for (int j = 0; j < sameCountOfFruit; j++) {
                    fruitPresentPack.add(fruitList.get(i));
                }
            }
            if (fruitList.get(i) instanceof Kiwi) {
                for (int j = 0; j < sameCountOfFruit; j++) {
                    fruitPresentPack.add(fruitList.get(i));
                }
            }
            if (fruitList.get(i) instanceof Tangerine) {
                for (int j = 0; j < sameCountOfFruit; j++) {
                    fruitPresentPack.add(fruitList.get(i));
                }
            }
        }
        return fruitPresentPack;
    }



}
