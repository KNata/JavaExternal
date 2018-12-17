package ITCompany.Entity;

import java.io.Serializable;
import java.util.Objects;

public class PC implements Serializable {

    private int unicCode;
    private String modelOfPC;
    private int speedOfPC;
    private int sizeOfHardDrive;
    private transient int ram;
    private String speedOfCD;
    private double pcPrice;

    public PC(int anUnicCode, String aModelOfPC, int aSpeedOfPC, int aSizeOfHardDrive, int aRam, String aSpeedOfCD, double aPcPrice) {
        unicCode = anUnicCode;
        modelOfPC = aModelOfPC;
        speedOfCD = aSpeedOfCD;
        sizeOfHardDrive = aSizeOfHardDrive;
        ram = aRam;
        speedOfPC = aSpeedOfPC;
        pcPrice = aPcPrice;
    }

    public int getUnicCode() {
        return unicCode;
    }

    public void setUnicCode(int unicCode) {
        this.unicCode = unicCode;
    }

    public String getModelOfPC() {
        return modelOfPC;
    }

    public void setModelOfPC(String modelOfPC) {
        this.modelOfPC = modelOfPC;
    }

    public int getSpeedOfPC() {
        return speedOfPC;
    }

    public void setSpeedOfPC(int speedOfPC) {
        this.speedOfPC = speedOfPC;
    }

    public int getSizeOfHardDrive() {
        return sizeOfHardDrive;
    }

    public void setSizeOfHardDrive(int sizeOfHardDrive) {
        this.sizeOfHardDrive = sizeOfHardDrive;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getSpeedOfCD() {
        return speedOfCD;
    }

    public void setSpeedOfCD(String speedOfCD) {
        this.speedOfCD = speedOfCD;
    }

    public double getPcPrice() {
        return pcPrice;
    }

    public void setPcPrice(double pcPrice) {
        this.pcPrice = pcPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PC pc = (PC) o;
        return sizeOfHardDrive == pc.sizeOfHardDrive &&
                ram == pc.ram &&
                pcPrice == pc.pcPrice &&
                Objects.equals(unicCode, pc.unicCode) &&
                Objects.equals(modelOfPC, pc.modelOfPC) &&
                Objects.equals(speedOfPC, pc.speedOfPC) &&
                Objects.equals(speedOfCD, pc.speedOfCD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unicCode, modelOfPC, speedOfPC, sizeOfHardDrive, ram, speedOfCD, pcPrice);
    }

    @Override
    public String toString() {
        return "PC (" +
                "id = '" + unicCode + '\'' +
                ", PC model = '" + modelOfPC + '\'' +
                ", speed of PC = '" + speedOfPC + '\'' +
                ", hard drive size = " + sizeOfHardDrive +
                ", ram = " + ram +
                ", speed of CD = '" + speedOfCD + '\'' +
                ", price = " + pcPrice +
                ')';
    }
}
