package Model;

import java.util.Objects;

public class Driver {

    private int driverID;
    private String driverName;
    private int experience;
    private boolean isOnRoute;

    public int getDriverID() {
        return driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isOnRoute() {
        return isOnRoute;
    }

    public class Builder {

        private Builder() {}

        public Builder setDriverID(int aDriverID) {
            driverID = aDriverID;
            return this;
        }

        public Builder setDriverName(String aDriverName) {
            driverName = aDriverName;
            return this;
        }

        public Builder setDriverExperience(int aDriverExperience) {
            aDriverExperience = aDriverExperience;
            return this;
        }

        public Builder setDriverWork(boolean anOnRoute) {
            isOnRoute = anOnRoute;
            return this;
        }

        public Driver build() {
            return Driver.this;
        }
    }

    public static Builder newBuilder() {
        return new Driver().new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return driverID == driver.driverID &&
                experience == driver.experience &&
                isOnRoute == driver.isOnRoute &&
                Objects.equals(driverName, driver.driverName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverID, driverName, experience, isOnRoute);
    }

    @Override
    public String toString() {
        return "Driver (" +
                "driverID = " + driverID +
                ", driverName = '" + driverName + '\'' +
                ", experience = " + experience +
                ", isOnRoute = " + isOnRoute +
                ')';
    }
}
