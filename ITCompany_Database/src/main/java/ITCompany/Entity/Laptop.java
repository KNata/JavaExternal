package ITCompany.Entity;

import java.util.Objects;

public class Laptop {

    private String unicCode;
    private String modelOfLaptop;
    private String speedOfLaptop;
    private int sizeOfHardDrive;
    private int ram;
    private String sizeOfScreen;
    private int laptopPrice;

    Laptop(String anUnicCode, String aModelOfLaptop, String aSpeedOfLaptop, int aSizeOfHardDrive, int aRam, String aSizeOfScreen, int aLaptopPrice) {
        unicCode = anUnicCode;
        modelOfLaptop = aModelOfLaptop;
        speedOfLaptop = aSpeedOfLaptop;
        sizeOfHardDrive = aSizeOfHardDrive;
        ram = aRam;
        sizeOfScreen = aSizeOfScreen;
        laptopPrice = aLaptopPrice;
    }

    public String getUnicCode() {
        return unicCode;
    }

    public void setUnicCode(String unicCode) {
        this.unicCode = unicCode;
    }

    public String getModelOfLaptop() {
        return modelOfLaptop;
    }

    public void setModelOfLaptop(String modelOfLaptop) {
        this.modelOfLaptop = modelOfLaptop;
    }

    public String getSpeedOfLaptop() {
        return speedOfLaptop;
    }

    public void setSpeedOfLaptop(String speedOfLaptop) {
        this.speedOfLaptop = speedOfLaptop;
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

    public String getSizeOfScreen() {
        return sizeOfScreen;
    }

    public void setSizeOfScreen(String sizeOfScreen) {
        this.sizeOfScreen = sizeOfScreen;
    }

    public int getLaptopPrice() {
        return laptopPrice;
    }

    public void setLaptopPrice(int laptopPrice) {
        this.laptopPrice = laptopPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return sizeOfHardDrive == laptop.sizeOfHardDrive &&
                ram == laptop.ram &&
                laptopPrice == laptop.laptopPrice &&
                Objects.equals(unicCode, laptop.unicCode) &&
                Objects.equals(modelOfLaptop, laptop.modelOfLaptop) &&
                Objects.equals(speedOfLaptop, laptop.speedOfLaptop) &&
                Objects.equals(sizeOfScreen, laptop.sizeOfScreen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unicCode, modelOfLaptop, speedOfLaptop, sizeOfHardDrive, ram, sizeOfScreen, laptopPrice);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "unicCode='" + unicCode + '\'' +
                ", modelOfLaptop='" + modelOfLaptop + '\'' +
                ", speedOfLaptop='" + speedOfLaptop + '\'' +
                ", sizeOfHardDrive=" + sizeOfHardDrive +
                ", ram=" + ram +
                ", sizeOfScreen='" + sizeOfScreen + '\'' +
                ", laptopPrice=" + laptopPrice +
                '}';
    }
}
