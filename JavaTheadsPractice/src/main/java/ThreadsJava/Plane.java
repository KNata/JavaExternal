package ThreadsJava;

public class Plane extends Thread {

    private String nameOfMachine;
    private String codeOfFlight;
    private String direction;
    private int maxCountOfPassengers;
    private Airport theAirport;

    Plane(String aNameOfMachine, String aCodeOfFlight, String aDirection, int aMaxCountOfPassengers) {
        nameOfMachine = aNameOfMachine;
        codeOfFlight = aCodeOfFlight;
        direction = aDirection;
        maxCountOfPassengers = aMaxCountOfPassengers;
    }


    public void run(){
            Gate theGate = theAirport.getGate();
            System.out.println("Plane " + this.getNameOfMachine() + "with flight " + this.getCodeOfFlight() + " "
                + this.getDirection() + "landed in the " + theAirport.nameOfAirport);
            System.out.println("Plane " + this.getNameOfMachine() + "with flight " + this.getCodeOfFlight() + " "
                    + this.getDirection() + "deparches from the " + theAirport.nameOfAirport);
            theGate.returnGate();

    }










    public String getNameOfMachine() {
        return nameOfMachine;
    }

    public void setNameOfMachine(String nameOfMachine) {
        this.nameOfMachine = nameOfMachine;
    }

    public String getCodeOfFlight() {
        return codeOfFlight;
    }

    public void setCodeOfFlight(String codeOfFlight) {
        this.codeOfFlight = codeOfFlight;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getMaxCountOfPassengers() {
        return maxCountOfPassengers;
    }

    public void setMaxCountOfPassengers(int maxCountOfPassengers) {
        this.maxCountOfPassengers = maxCountOfPassengers;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "nameOfMachine='" + nameOfMachine + '\'' +
                ", codeOfFlight='" + codeOfFlight + '\'' +
                ", direction='" + direction + '\'' +
                ", maxCountOfPassengers=" + maxCountOfPassengers +
                '}';
    }
}
