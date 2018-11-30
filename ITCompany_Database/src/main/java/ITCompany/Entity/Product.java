package ITCompany.Entity;

import java.util.Objects;

public class Product {

    private String marker;
    private String modelNumber;
    private String typeOfModel;

    public Product(String aMarker, String aModelNumber, String aTypeOfModel ) {
        marker = aMarker;
        modelNumber = aModelNumber;
        typeOfModel = aTypeOfModel;
    }


    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getTypeOfModel() {
        return typeOfModel;
    }

    public void setTypeOfModel(String typeOfModel) {
        this.typeOfModel = typeOfModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(marker, product.marker) &&
                Objects.equals(modelNumber, product.modelNumber) &&
                Objects.equals(typeOfModel, product.typeOfModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marker, modelNumber, typeOfModel);
    }

    @Override
    public String toString() {
        return "Product (" +
                "marker = '" + marker + '\'' +
                ", number of model = '" + modelNumber + '\'' +
                ", type of model = '" + typeOfModel + '\'' +
                ')';
    }
}
