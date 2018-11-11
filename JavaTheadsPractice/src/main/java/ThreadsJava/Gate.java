package ThreadsJava;

public class Gate {

    private String gateTitle;
    private int gateID;
    private int terminalId;
    private boolean isFree;

    Gate(String aName, int aGateID, int aTerminalId) {
        gateTitle = aName;
        gateID = aGateID;
        terminalId = aTerminalId;
        isFree = true;
    }

    public String getGateTitle() {
        return gateTitle;
    }

    public void setGateTitle(String gateTitle) {
        this.gateTitle = gateTitle;
    }

    public int getGateID() {
        return gateID;
    }

    public void setGateID(int gateID) {
        this.gateID = gateID;
    }

    public int getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(int terminalId) {
        this.terminalId = terminalId;
    }

    public boolean isFree() {
        return isFree;
    }

    public void occupy() {
        isFree = false;
    }

    public void returnGate() {
        isFree = true;
    }

}
