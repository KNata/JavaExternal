package SmartVechicles.Controller;

import SmartVechicles.View.VechicleService;
import SmartVechicles.Model.*;

import java.util.ArrayList;

public class VechicleController {

    private VechicleService theService;

    public VechicleController(VechicleService vechicleService) {
        theService = vechicleService;
    }

    public ArrayList<Plane> findPlanedByConditions() {
        return theService.findPlanedByConditions();
    }

    public ArrayList<Vechicle> returnListOfVechiclesWithMaxSppedExeptPlanes() {
        return theService.returnListOfVechiclesWithMaxSppedExeptPlanes();
    }

    public ArrayList<BetMobile> checkInstanceOfIMovebbleInterfaceToBetmobile() {
        return theService.checkForMaxSpeedInMovableBetweenBetMobiles();
    }

    public ArrayList<AmfibianCar> checkInstanceOfIMovebbleInterfaceToAmphibianCar() {
        return theService.checkForMaxSpeedInMovableBetweenAmphibianCars();
    }

    public ArrayList<BetMobile> checkForMaxSpeedInSwimmableBetweenBetMobiles() {
        return theService.checkForMaxSpeedInSwimmableBetweenBetMobiles();
    }

    public ArrayList<AmfibianCar> checkInstanceOfISwimableInterfaceToAmphibianCar() {
        return theService.checkForMaxSpeedInSwimmableBetweenAmphibianCars();
    }

    public ArrayList<BetMobile> checkInstanceOfIFlyvableInterfaceToBetmobile() {
        return theService.checkForMaxSpeedInSFlyvableBetweenBetMobiles();
    }

}

