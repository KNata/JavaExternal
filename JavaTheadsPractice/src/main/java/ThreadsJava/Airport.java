package ThreadsJava;

import java.util.ArrayList;

public class Airport {

    public static int TERMINALS = 2;
    public static int  GATES = 4;

    String nameOfAirport;
    private ArrayList<Gate> gatesList;

    Airport(String aNameOfAirp) {
        nameOfAirport = aNameOfAirp;

    }

    public void createGates() {
        for (int i = 0; i < TERMINALS; i++) {
            for(int j = 0; j < GATES; j++) {
                Gate gate = new Gate(i + "-" + j, j, i);
            }
        }
    }

    public Gate getGate () {
        Gate theGate = null;
        if (gatesList.size() > 0) {
            for (int i = 0; i < gatesList.size(); i++) {
                if (gatesList.get(i).isFree()) {
                    gatesList.get(i).occupy();
                    theGate = gatesList.get(i);
                }

            }
        }
        return theGate;
    }


}
