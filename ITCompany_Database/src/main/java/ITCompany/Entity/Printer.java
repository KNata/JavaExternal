package ITCompany.Entity;

import java.util.Objects;

public class Printer {

    private String unicCode;
    private String model;
    private String color;
    private String type;
    private int price;

    Printer(String anUnicCode, String aModel, String aColor, String aType, int aPrice) {
        unicCode = anUnicCode;
        model = aModel;
        color = aColor;
        type = aType;
        price = aPrice;
    }

    public String getUnicCode() {
        return unicCode;
    }

    public void setUnicCode(String unicCode) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
                Objects.equals(type, printer.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unicCode, model, color, type, price);
    }

    @Override
    public String toString() {
        return "Printer{" +
                "unicCode='" + unicCode + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
