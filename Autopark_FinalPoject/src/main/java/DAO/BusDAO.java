package DAO;

import DBConnection.ConnectionPool;
import Model.Bus;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO implements AbstractDAO<Integer, Bus> {

    private static Logger theLogger;

    static {
        theLogger = Logger.getLogger(BusDAO.class);
    }


    @Override
    public boolean addRecord(Bus anEntity) throws SQLException {
        boolean added = false;
        if (anEntity == null) {
            added = false;
        } else if (findByName(anEntity.getBusModel()) != null) {
            added = false;
        } else {
            String insertSQL = "insert into Bus values(?,?,?,?,?,)";
        }
        return false;
    }

    @Override
    public boolean deleteRecord(Integer anID) throws SQLException {
        boolean wasDeleted = false;
        if (anID == 0) {
            wasDeleted = false;
        } else {
            String deleteSQL = "delete from Bus where busID = '" + anID + "'";
            Connection connection = null;
            Statement statement = null;
            Savepoint savepoint = null;
            try {
                connection = ConnectionPool.getConnection();
                statement = connection.createStatement();
                connection.setAutoCommit(false);
                statement.execute(deleteSQL);
                wasDeleted = true;
                savepoint = connection.setSavepoint();
                connection.commit();
            } catch (SQLException e) {
                if (savepoint == null) {
                    connection.rollback();
                } else {
                    connection.rollback(savepoint);
                }
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }
        return wasDeleted;
    }

    @Override
    public List<Bus> findAll() throws SQLException {
        String selectAllSQL = "Select * from Bus";
        ArrayList<Bus> busList = new ArrayList<Bus>();
        Connection conncection = null;
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            conncection = ConnectionPool.getConnection();
            conncection.setAutoCommit(false);
            statement = conncection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllSQL);
            while (resultSet.next()) {
                String busID = resultSet.getString("busID");
                String busModel = resultSet.getString("modelName");
                int maxCountOfPassengers = resultSet.getInt("maxPassengers");
                int miles = resultSet.getInt("miles");
                boolean passedService = resultSet.getBoolean("maintance");
                int routeID = resultSet.getInt("Route_routeID");
                int driverID = resultSet.getInt("Driver_driverID");
                int visitorID = resultSet.getInt("Visitor_visitorID");
                Bus theBus = Bus.newBuilder().setBusID(busID).setBusModel(busModel).
                        setmaxCountOfPassagers(maxCountOfPassengers).setMiles(miles).setPassedService(passedService)
                        .setDriver(new DriverDAO().findByID(driverID)).setRoute(new RouteDAO().findByID(routeID))
                        .setVisitor(new VisitorDAO().findByID(visitorID)).build();
                busList.add(theBus);
                savepoint = conncection.setSavepoint();
            }
            conncection.commit();
        } catch (SQLException e) {
            if (savepoint != null) {
                conncection.rollback(savepoint);
            } else {
                conncection.rollback();
            }
            theLogger.error(e.getMessage());
        } finally {
            if(statement != null) {
                statement.close();
            }
            if (conncection != null) {
                conncection.close();
            }
        }
        return busList;
    }

    @Override
    public Bus findByID(int anID) throws SQLException {
        if (anID == 0) {
            // to do something
        }
        Bus theBus = null;
        String selectAllSQL = "select * from Bus b, Driver d, Visitor v where b.busID = '" + anID + "'";
        Connection conncection = null;
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            conncection = ConnectionPool.getConnection();
            conncection.setAutoCommit(false);
            statement = conncection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllSQL);
            while (resultSet.next()) {
                String busID = resultSet.getString("busID");
                String busModel = resultSet.getString("modelName");
                int maxCountOfPassengers = resultSet.getInt("maxPassengers");
                int miles = resultSet.getInt("miles");
                boolean passedService = resultSet.getBoolean("maintance");
                int routeID = resultSet.getInt("Route_routeID");
                int driverID = resultSet.getInt("Driver_driverID");
                int visitorID = resultSet.getInt("Visitor_visitorID");
                theBus = Bus.newBuilder().setBusID(busID).setBusModel(busModel).
                        setmaxCountOfPassagers(maxCountOfPassengers).setMiles(miles).setPassedService(passedService)
                        .setDriver(new DriverDAO().findByID(driverID)).setRoute(new RouteDAO().findByID(routeID))
                        .setVisitor(new VisitorDAO().findByID(visitorID)).build();
                savepoint = conncection.setSavepoint();

            }
            conncection.commit();
        } catch (SQLException e) {
            if (savepoint != null) {
                conncection.rollback(savepoint);
            } else {
                conncection.rollback();
            }
            theLogger.error(e.getMessage());
        } finally {
            if(statement != null) {
                statement.close();
            }
            if (conncection != null) {
                conncection.close();
            }
        }
        return theBus;
    }

    @Override
    public Bus findByName(String aName) throws SQLException {
        if (aName == null) {
            return null;
        }
        Bus theBus = null;
        String selectAllSQL = "select * from Bus b, Driver d, Visitor v where b.modelName = '" + aName + "'";
        Connection conncection = null;
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            conncection = ConnectionPool.getConnection();
            conncection.setAutoCommit(false);
            statement = conncection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllSQL);
            while (resultSet.next()) {
                String busID = resultSet.getString("busID");
                String busModel = resultSet.getString("modelName");
                int maxCountOfPassengers = resultSet.getInt("maxPassengers");
                int miles = resultSet.getInt("miles");
                boolean passedService = resultSet.getBoolean("maintance");
                int routeID = resultSet.getInt("Route_routeID");
                int driverID = resultSet.getInt("Driver_driverID");
                int visitorID = resultSet.getInt("Visitor_visitorID");
                theBus = Bus.newBuilder().setBusID(busID).setBusModel(busModel).
                        setmaxCountOfPassagers(maxCountOfPassengers).setMiles(miles).setPassedService(passedService)
                        .setDriver(new DriverDAO().findByID(driverID)).setRoute(new RouteDAO().findByID(routeID))
                        .setVisitor(new VisitorDAO().findByID(visitorID)).build();
                savepoint = conncection.setSavepoint();
            }

            conncection.commit();
        } catch (SQLException e) {
            if (savepoint != null) {
                conncection.rollback(savepoint);
            } else {
                conncection.rollback();
            }
            theLogger.error(e.getMessage());
        } finally {
            if(statement != null) {
                statement.close();
            }
            if (conncection != null) {
                conncection.close();
            }
        }
        return theBus;
    }

    @Override
    public boolean isObjectExistsByID(int id) throws SQLException {
        boolean isExist = false;
        String selectAllSQL = "Select * from Bus where busID = '" + id + "'";
        Connection conncection = null;
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            conncection = ConnectionPool.getConnection();
            conncection.setAutoCommit(false);
            statement = conncection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllSQL);
            while (resultSet.next()) {
                String busID = resultSet.getString("busID");
                isExist = true;
            }
            savepoint = conncection.setSavepoint();
            conncection.commit();
        } catch (SQLException e) {
            if (savepoint != null) {
                conncection.rollback(savepoint);
            } else {
                conncection.rollback();
            }
            theLogger.error(e.getMessage());
        } finally {
            if(statement != null) {
                statement.close();
            }
            if (conncection != null) {
                conncection.close();
            }
        }
        return isExist;
    }

    @Override
    public boolean update() {
        return false;
    }
}
