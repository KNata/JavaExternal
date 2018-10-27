package SmartVechicles;

import java.util.ArrayList;

import SmartVechicles.Controller.VechicleController;
import SmartVechicles.Model.Plane;
import SmartVechicles.View.VechicleService;

public class App {

	public static void main(String[] args) {
		Plane plane1 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(56000).setVechicleSpeed(1000)
                .setYearOfProduction(2018).setMaxCountOfPass(400).setMaxHeighUnderSea(1000.0).build();
        Plane plane2 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(6488).setVechicleSpeed(600)
                .setYearOfProduction(2000).setMaxCountOfPass(400).setMaxHeighUnderSea(1000.0).build();
        Plane plane3 = Plane.newBuilder().setPointX(21.0).setPointY(32.2).setVechiclePrice(239000).setVechicleSpeed(2000)
                .setYearOfProduction(2011).setMaxCountOfPass(200).setMaxHeighUnderSea(1000.0).build();
        System.out.println(plane1.getVechicleYearOfProduction());
        System.out.println(plane2.getVechicleYearOfProduction());
        System.out.println(plane3.getVechicleYearOfProduction());
//        ArrayList<Plane> planeList = new ArrayList<Plane>();
//        planeList.add(plane3);
//        planeList.add(plane2);
//        planeList.add(plane1);
//        VechicleService theService = new VechicleService(planeList, null, null, null, null);
//        VechicleController theController = new VechicleController(theService);
//
//        ArrayList<Plane> l1 = theController.findPlanedByConditions();
//        System.out.println(l1.size());
//
	}

}
