package DAO;

import Model.Bus;

import java.util.List;

public class BusDAO implements AbstractDAO<Integer, Bus> {

    @Override
    public boolean addRecord(Bus anEntity) {
        return false;
    }

    @Override
    public boolean deleteRecord(Integer anID) {
        return false;
    }

    @Override
    public List<Bus> finfAll() {
        return null;
    }

    @Override
    public Bus findByID(int anID) {
        return null;
    }

    @Override
    public Bus findByName(String aName) {
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
