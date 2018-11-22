package ThreadsJava;

import java.util.ArrayList;

import ThreadsJava.Exeptions.ParametersException;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Airport airport = new Airport();
        ArrayList<City> routeList = new ArrayList<City>();
        ArrayList<Plane> listOfPlanes = new ArrayList<Plane>();

        try {
            routeList.add(new City("London",2000,1));
            routeList.add(new City("Paris", 2200,2));
            routeList.add(new City("Warszawa", 1800,3));
            routeList.add(new City("New-York",780,4));
            routeList.add(new City("Tallin",1000,5));
            routeList.add(new City("Vilnus",1000,5));
            routeList.add(new City("Austin",1000,5));
            routeList.add(new City("Edinbourg",1000,5));
        } catch (ParametersException e) {
            e.printStackTrace();
        }

        try {
            listOfPlanes.add(new Plane(airport, 2500, 200));
            listOfPlanes.add(new Plane(airport, 5000, 180));
            listOfPlanes.add(new Plane(airport, 4200, 220));
            listOfPlanes.add(new Plane(airport, 3000, 210));
            listOfPlanes.add(new Plane(airport, 3200, 160));
            listOfPlanes.add(new Plane(airport, 1246, 160));
            listOfPlanes.add(new Plane(airport, 1234, 543));
            listOfPlanes.add(new Plane(airport, 5000, 100));
        } catch (ParametersException e){
            e.printStackTrace();
        };
        for (int i = 0; i < routeList.size(); i++){
            listOfPlanes.get(i).setRoute(routeList.get(i));
        }
        for (Plane plane: listOfPlanes) {
            if (plane.getRoute() != null) {
                plane.start();
            }
            Thread.sleep(200);
        }
    }
}