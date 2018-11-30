package ITCompany.Entity;

import java.util.Objects;

public class Laptop {

    private int unicCode;
    private String modelOfLaptop;
    private int speedOfLaptop;
    private int sizeOfHardDrive;
    private int ram;
    private int sizeOfScreen;
    private double laptopPrice;

    public Laptop(int anUnicCode, String aModelOfLaptop, int aSpeedOfLaptop, int aSizeOfHardDrive, int aRam, int aSizeOfScreen, double aLaptopPrice) {
        unicCode = anUnicCode;
        modelOfLaptop = aModelOfLaptop;
        speedOfLaptop = aSpeedOfLaptop;
        sizeOfHardDrive = aSizeOfHardDrive;
        ram = aRam;
        sizeOfScreen = aSizeOfScreen;
        laptopPrice = aLaptopPrice;
    }

    public int getUnicCode() {
        return unicCode;
    }

    public void setUnicCode(int unicCode) {
        this.unicCode = unicCode;
    }

    public String getModelOfLaptop() {
        return modelOfLaptop;
    }

    public void setModelOfLaptop(String modelOfLaptop) {
        this.modelOfLaptop = modelOfLaptop;
    }

    public int getSpeedOfLaptop() {
        return speedOfLaptop;
    }

    public void setSpeedOfLaptop(int speedOfLaptop) {
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

    public int getSizeOfScreen() {
        return sizeOfScreen;
    }

    public void setSizeOfScreen(int sizeOfScreen) {
        this.sizeOfScreen = sizeOfScreen;
    }

    public double getLaptopPrice() {
        return laptopPrice;
    }

    public void setLaptopPrice(double laptopPrice) {
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
        return "Laptop (" +
                "id = '" + unicCode + '\'' +
                ", model of Laptop = '" + modelOfLaptop + '\'' +
                ", laptop's speed = '" + speedOfLaptop + '\'' +
                ", hard drive size = " + sizeOfHardDrive +
                ", ram = " + ram +
                ", screen size = '" + sizeOfScreen + '\'' +
                ", price of laptop = " + laptopPrice +
                ')';
    }
}
