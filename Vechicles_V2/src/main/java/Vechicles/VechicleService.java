package Vechicles;

import java.util.ArrayList;

public class VechicleService {

    private ArrayList<Plane> planesList;
    private ArrayList<Vechicle> vechiclesList;
    private ArrayList<IMovebble> movableList;
    private ArrayList<ISwimmable> swimmableList;
    private ArrayList<IFlyvable> flyvableList;


    private static final int MAX_FLIGHT_HEIGHT = 5000;
    private static final int FLIGHT_YEAR_OF_PRODUCTION = 2000;
    private static final double VECHICLE_MIN_SPEED_IN_RANGE = 200;
    private static final double VECHICLE_MAX_SPEED_IN_RANGE = 500;



    VechicleService(ArrayList<Plane> aPlanesList, ArrayList<Vechicle> aVechiclesList,
                    ArrayList<IMovebble> aMovableList, ArrayList<ISwimmable> aSwimmableList, ArrayList<IFlyvable> aFlyvableList) {
        planesList = aPlanesList;
        vechiclesList = aVechiclesList;
        movableList = aMovableList;
        swimmableList = aSwimmableList;
        flyvableList = aFlyvableList;
    }


    /**
     * найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000
     */
    public ArrayList<Plane> findPlanedByConditions() {
        ArrayList<Plane> resultList = new ArrayList<Plane>();
        for (int i = 0; i < planesList.size(); i++) {
            if (planesList.get(i).getHeighOfFlightUnderSea() > MAX_FLIGHT_HEIGHT &&
                    planesList.get(i).getVechicleYearOfProduction() > FLIGHT_YEAR_OF_PRODUCTION) {
                resultList.add(planesList.get(i));
            }
        }
        return resultList;
    }

    /**
     *  3. найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane
     */

    private ArrayList<Vechicle> checkInstanceForAClass() {
        ArrayList<Vechicle> resultList = new ArrayList<Vechicle>();
        for (int i = 0; i < vechiclesList.size(); i++) {
            if (vechiclesList.get(i) instanceof Car || vechiclesList.get(i) instanceof Ship) {
                resultList.add(vechiclesList.get(i));
            }
        }
        return resultList;
    }

    private ArrayList<Vechicle> checkVechicleByCiteria(ArrayList<Vechicle> vechiclesList) {
        ArrayList<Vechicle> vechiclesWithMaxSpeedInRange = new ArrayList<Vechicle>();
        if (vechiclesList.size() > 0) {
            for (int i = 0; i < vechiclesList.size(); i++) {
                if (vechiclesList.get(i).getVechicleSpeed() >= VECHICLE_MIN_SPEED_IN_RANGE &&
                        vechiclesList.get(i).getVechicleSpeed() <= VECHICLE_MAX_SPEED_IN_RANGE) {
                    vechiclesWithMaxSpeedInRange.add(vechiclesList.get(i));
                }
            }
        }
        return vechiclesWithMaxSpeedInRange;
    }

    public ArrayList<Vechicle> returnListOfVechiclesWithMaxSppedExeptPlanes() {
        ArrayList<Vechicle> vechiclesWithMaxSpeedInRange = checkInstanceForAClass();
        return checkVechicleByCiteria(vechiclesWithMaxSpeedInRange);
    }


}
