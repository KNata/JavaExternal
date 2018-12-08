package DAO;

import Model.Driver;

import java.util.List;

public class DriverDAO implements AbstractDAO<Integer, Driver> {
    @Override
    public boolean addRecord(Driver anEntity) {
        return false;
    }

    @Override
    public boolean deleteRecord(Integer anID) {
        return false;
    }

    @Override
    public List<Driver> finfAll() {
        return null;
    }

    @Override
    public Driver findByID(int anID) {
        return null;
    }

    @Override
    public Driver findByName(String aName) {
        return null;
    }

    @Override
    public boolean isObjectExistsByID(int id) {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }
}
