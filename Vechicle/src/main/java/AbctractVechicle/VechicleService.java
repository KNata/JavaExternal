package AbctractVechicle;

/*
 1. механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет
 2. найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000  done
 3. найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane  -> done
 4. добавить к данной иерархии машину-амфибию, и БетМобиль,   -> done
 5. создать 3 масива сгупированых по Интерфейсам Flyable, MoveAble, SwimAble  ???
 6. найти в полученных масивах механизмы с максимальной скоростью -> done
 */

import java.util.ArrayList;

public class VechicleService {

    private ArrayList<CCar> carList;
    private ArrayList<CShip> shipList;
    private ArrayList<CPlane> planeList;

    private static final double MINIMUM_FLIGHT_HEIHGT = 5000.0;
    private static final int PLANE_MINIMUM_YEAR_OF_PRODUCTION = 2000;
    private static final int CAR_MINIMUM_YEAR_OF_PRODUCTION = 5;
    private static final double VECHICLE_LOWER_LIMIT_OF_SPEED = 200;
    private static final double VECHICLE_UPPER_LIMIT_OF_SPEED = 500;



    VechicleService (ArrayList<CCar> aCarList, ArrayList<CShip> aShipList, ArrayList<CPlane> aPlaneList) {
        carList = aCarList;
        shipList = aShipList;
        planeList = aPlaneList;
    }

/*
List<ValuePairs> ourValues = new ArrayList<>();

ourValues.stream().max(comparing(ValuePairs::getMValue)).get()

 */

    public void findCarsWithMinPriceAndMaxSpeedAndLessThenSelectedYearsOfProduction() {

    }

    public ArrayList<CPlane> planesWithSelectedSpeedAndYearOfProduction() {
        ArrayList<CPlane> resultList = new ArrayList<CPlane>();
        for (int i = 0; i < planeList.size(); i++) {
            if (planeList.get(i).getHeigh() >= MINIMUM_FLIGHT_HEIHGT &&
                    planeList.get(i).getVechicleYearOfProduction() >= PLANE_MINIMUM_YEAR_OF_PRODUCTION) {
                resultList.add(planeList.get(i));
            }
        }
        return resultList;
    }

    public ArrayList<CCar> carsWithSelectedSpeedInSpecificRange() {
        ArrayList<CCar> resultList = new ArrayList<CCar>();
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getVechicleSpeed() <= VECHICLE_UPPER_LIMIT_OF_SPEED &&
                    carList.get(i).getVechicleSpeed() >= VECHICLE_LOWER_LIMIT_OF_SPEED) {
                resultList.add(carList.get(i));
            }
        }
        return resultList;
    }

    public ArrayList<CShip> shipsWithSelectedSpeedInSpecificRange() {
        ArrayList<CShip> resultList = new ArrayList<CShip>();
        for (int i = 0; i < shipList.size(); i++) {
            if (shipList.get(i).getVechicleSpeed() <= VECHICLE_UPPER_LIMIT_OF_SPEED &&
                    shipList.get(i).getVechicleSpeed() >= VECHICLE_LOWER_LIMIT_OF_SPEED) {
                resultList.add(shipList.get(i));
            }
        }
        return resultList;
    }

   public ArrayList<CCar> sortAllCarsBySpeed() {
        for (int i = 0; i < carList.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < carList.size(); j++) {
                if (carList.get(j).getVechicleSpeed() < carList.get(index).getVechicleSpeed()) {
                    index = j;
                }
            }
            double indexVechicleSpeed = carList.get(index).getVechicleSpeed();
            double iVechicleSpeed = carList.get(i).getVechicleSpeed();

            double theSmallestSpeed = carList.get(index).getVechicleSpeed();
            indexVechicleSpeed = carList.get(i).getVechicleSpeed();
            iVechicleSpeed = theSmallestSpeed;
        }
        return carList;
    }

    public ArrayList<CPlane> sortAllPlanesBySpeed() {
        for (int i = 0; i < planeList.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < planeList.size(); j++) {
                if (planeList.get(j).getVechicleSpeed() < planeList.get(index).getVechicleSpeed()) {
                    index = j;
                }
            }
            double indexVechicleSpeed = planeList.get(index).getVechicleSpeed();
            double iVechicleSpeed = planeList.get(i).getVechicleSpeed();

            double theSmallestSpeed = planeList.get(index).getVechicleSpeed();
            indexVechicleSpeed = planeList.get(i).getVechicleSpeed();
            iVechicleSpeed = theSmallestSpeed;
        }
        return planeList;
    }

    public ArrayList<CShip> sortAllShipsBySpeed() {
        for (int i = 0; i < shipList.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < shipList.size(); j++) {
                if (shipList.get(j).getVechicleSpeed() < shipList.get(index).getVechicleSpeed()) {
                    index = j;
                }
            }
            double indexVechicleSpeed = shipList.get(index).getVechicleSpeed();
            double iVechicleSpeed = shipList.get(i).getVechicleSpeed();

            double theSmallestSpeed = shipList.get(index).getVechicleSpeed();
            indexVechicleSpeed = shipList.get(i).getVechicleSpeed();
            iVechicleSpeed = theSmallestSpeed;
        }
        return shipList;
    }
}
