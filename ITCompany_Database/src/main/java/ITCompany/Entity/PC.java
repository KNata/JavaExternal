package ITCompany.Entity;

import java.util.Objects;

public class PC {

    private String unicCode;
    private String modelOfPC;
    private String speedOfPC;
    private int sizeOfHardDrive;
    private int ram;
    private String speedOfCD;
    private int pcPrice;

    PC(String anUnicCode, String aModelOfPC, String aSpeedOfPC, int aSizeOfHardDrive, int aRam, String aSpeedOfCD, int aPcPrice) {
        unicCode = anUnicCode;
        modelOfPC = aModelOfPC;
        speedOfCD = aSpeedOfCD;
        sizeOfHardDrive = aSizeOfHardDrive;
        ram = aRam;
        speedOfPC = aSpeedOfPC;
        pcPrice = aPcPrice;
    }

    public String getUnicCode() {
        return unicCode;
    }

    public void setUnicCode(String unicCode) {
        this.unicCode = unicCode;
    }

    public String getModelOfPC() {
        return modelOfPC;
    }

    public void setModelOfPC(String modelOfPC) {
        this.modelOfPC = modelOfPC;
    }

    public String getSpeedOfPC() {
        return speedOfPC;
    }

    public void setSpeedOfPC(String speedOfPC) {
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

    public int getPcPrice() {
        return pcPrice;
    }

    public void setPcPrice(int pcPrice) {
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
        return "PC{" +
                "unicCode='" + unicCode + '\'' +
                ", modelOfPC='" + modelOfPC + '\'' +
                ", speedOfPC='" + speedOfPC + '\'' +
                ", sizeOfHardDrive=" + sizeOfHardDrive +
                ", ram=" + ram +
                ", speedOfCD='" + speedOfCD + '\'' +
                ", pcPrice=" + pcPrice +
                '}';
    }
}
