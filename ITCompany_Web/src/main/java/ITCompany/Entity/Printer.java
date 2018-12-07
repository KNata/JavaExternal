package ITCompany.Entity;

import java.util.Objects;

public class Printer {

    private int unicCode;
    private String model;
    private String color;
    private String type;
    private double price;
    private int countOfPrinters;

    public  Printer(int anUnicCode, String aModel, String aColor, String aType, double aPrice, int aCountOfPrinters) {
        unicCode = anUnicCode;
        model = aModel;
        color = aColor;
        type = aType;
        price = aPrice;
        countOfPrinters = aCountOfPrinters;
    }

    public int getUnicCode() {
        return unicCode;
    }

    public void setUnicCode(int unicCode) {
        this.unicCode = unicCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCountOfPrinters() {
        return countOfPrinters;
    }

    public void setCountOfPrinters(int countOfPrinters) {
        this.countOfPrinters = countOfPrinters;
    }

    public int increasePrinterCount() {
        return countOfPrinters++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printer printer = (Printer) o;
        return price == printer.price &&
                Objects.equals(unicCode, printer.unicCode) &&
                Objects.equals(model, printer.model) &&
                Objects.equals(color, printer.color) &&
                Objects.equals(type, printer.type) &&
                countOfPrinters == ((Printer) o).countOfPrinters;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unicCode, model, color, type, price, countOfPrinters);
    }

    @Override
    public String toString() {
        return "Printer (" +
                "id = '" + unicCode + '\'' +
                ", model = '" + model + '\'' +
                ", is color = '" + color + '\'' +
                ", printer type = '" + type + '\'' +
                ", price = " + price + '\'' +
                ", count of printers = " + countOfPrinters + '\'' +
                ')';
    }
}
