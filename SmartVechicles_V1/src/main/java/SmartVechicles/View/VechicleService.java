package SmartVechicles.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import SmartVechicles.CustomExeptions.EmptyVechicleListExeption;
import SmartVechicles.CustomExeptions.MyIndexOfBoundExeption;
import SmartVechicles.Model.*;
import SmartVechicles.Model.Interfaces.*;

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



    public VechicleService(ArrayList<Plane> aPlanesList, ArrayList<Vechicle> aVechiclesList,
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

    private ArrayList<Vechicle> checkInstanceForAClass() throws EmptyVechicleListExeption {
        ArrayList<Vechicle> resultList = new ArrayList<Vechicle>();
        for (int i = 0; i < vechiclesList.size(); i++) {
            if (vechiclesList.get(i) instanceof Car || vechiclesList.get(i) instanceof Ship) {
                resultList.add(vechiclesList.get(i));
            }
        }
        return resultList;
    }

    private ArrayList<Vechicle> checkVechicleByCiteria(ArrayList<Vechicle> vechiclesList) throws MyIndexOfBoundExeption {
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

    public ArrayList<Vechicle> returnListOfVechiclesWithMaxSppedExeptPlanes() throws MyIndexOfBoundExeption {
        ArrayList<Vechicle> vechiclesWithMaxSpeedInRange = checkInstanceForAClass();
        return checkVechicleByCiteria(vechiclesWithMaxSpeedInRange);
    }

 //найти в полученных масивах механизмы с максимальной скоростью
    public ArrayList<BetMobile> checkForMaxSpeedInMovableBetweenBetMobiles() {
        ArrayList<BetMobile> betMobileList = new ArrayList<BetMobile>();
        for (int i = 0; i < movableList.size(); i++) {
            if (movableList.get(i) instanceof BetMobile) {
                betMobileList.add((BetMobile) movableList.get(i));
            }
        }
        Collections.sort(betMobileList, BetMobile.vechicleComparator);
        return betMobileList;
    }

    public ArrayList<AmfibianCar> checkForMaxSpeedInMovableBetweenAmphibianCars() {
        ArrayList<AmfibianCar> amphibianCarList = new ArrayList<AmfibianCar>();
        for (int i = 0; i < movableList.size(); i++) {
            if (movableList.get(i) instanceof AmfibianCar) {
                amphibianCarList.add((AmfibianCar) movableList.get(i));
            }
        }
        Collections.sort(amphibianCarList, AmfibianCar.vechicleComparator);
        return amphibianCarList;
    }

    public ArrayList<BetMobile> checkForMaxSpeedInSwimmableBetweenBetMobiles() {
        ArrayList<BetMobile> betMobileList = new ArrayList<BetMobile>();
        for (int i = 0; i < swimmableList.size(); i++) {
            if (swimmableList.get(i) instanceof BetMobile) {
                betMobileList.add((BetMobile) swimmableList.get(i));
            }
        }
        Collections.sort(betMobileList, BetMobile.vechicleComparator);
        return betMobileList;
    }

    public ArrayList<AmfibianCar> checkForMaxSpeedInSwimmableBetweenAmphibianCars() {
        ArrayList<AmfibianCar> amphibianCarList = new ArrayList<AmfibianCar>();
        for (int i = 0; i < swimmableList.size(); i++) {
            if (swimmableList.get(i) instanceof AmfibianCar) {
                amphibianCarList.add((AmfibianCar) swimmableList.get(i));
            }
        }
        Collections.sort(amphibianCarList, AmfibianCar.vechicleComparator);
        return amphibianCarList;
    }

    public ArrayList<BetMobile> checkForMaxSpeedInSFlyvableBetweenBetMobiles() {
        ArrayList<BetMobile> betMobileList = new ArrayList<BetMobile>();
        for (int i = 0; i < flyvableList.size(); i++) {
            if (flyvableList.get(i) instanceof BetMobile) {
                betMobileList.add((BetMobile) flyvableList.get(i));
            }
        }
        Collections.sort(betMobileList, BetMobile.vechicleComparator);
        return betMobileList;
    }

    public ArrayList<Plane> getPlanesList() {
        return planesList;
    }

    public void setPlanesList(ArrayList<Plane> planesList) {
        this.planesList = planesList;
    }

    public ArrayList<Vechicle> getVechiclesList() {
        return vechiclesList;
    }

    public void setVechiclesList(ArrayList<Vechicle> vechiclesList) {
        this.vechiclesList = vechiclesList;
    }

    public ArrayList<IMovebble> getMovableList() {
        return movableList;
    }

    public void setMovableList(ArrayList<IMovebble> movableList) {
        this.movableList = movableList;
    }

    public ArrayList<ISwimmable> getSwimmableList() {
        return swimmableList;
    }

    public void setSwimmableList(ArrayList<ISwimmable> swimmableList) {
        this.swimmableList = swimmableList;
    }

    public ArrayList<IFlyvable> getFlyvableList() {
        return flyvableList;
    }

    public void setFlyvableList(ArrayList<IFlyvable> flyvableList) {
        this.flyvableList = flyvableList;
    }
}
