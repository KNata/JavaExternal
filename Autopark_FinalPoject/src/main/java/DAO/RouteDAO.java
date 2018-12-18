package DAO;

import Model.Route;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

public class RouteDAO implements AbstractDAO<String, Route> {

    private static Logger theLogger;

    static {
        theLogger = Logger.getLogger(DriverDAO.class);
    }


    @Override
    public boolean addRecord(Route anEntity) throws SQLException {

        return false;
    }

    @Override
    public boolean deleteRecord(String anID) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Route> findAll() throws SQLException {
        return null;
    }

    @Override
    public Route findByID(String anID) throws SQLException {
        return null;
    }

    @Override
    public Route findByName(String aName) throws SQLException {
        return null;
    }

    @Override
    public boolean update() {
        return false;
    }
}
