package DAO;

import DBConnection.ConnectionPool;
import Model.Destination;
import Model.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO implements AbstractDAO<Integer, Driver> {


    @Override
    public boolean addRecord(Driver anEntity) throws SQLException {

        return false;
    }

    @Override
    public boolean deleteRecord(Integer anID) throws SQLException {

        boolean wasDeleted = false;
        if (anID == 0) {
            wasDeleted = false;
        } else {
            String deleteSQL = "delete from Driver where driverID = '" + anID + "'";
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
    public List<Driver> findAll() throws SQLException {
        String selectAllSQL = "Select * from Driver";
        ArrayList<Driver> driverList = new ArrayList<Driver>();
        Connection conncection = null;
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            conncection = ConnectionPool.getConnection();
            conncection.setAutoCommit(false);
            statement = conncection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllSQL);
            while (resultSet.next()) {
                int driverID = resultSet.getInt("driverID");
                String driverName = resultSet.getString("driverName");
                int destinationID = resultSet.getInt("Visitor_visitorID");
                Driver theDriver = Driver.newBuilder().setDriverID(driverID).setDriverName(driverName).build();
                savepoint = conncection.setSavepoint();
            }
            conncection.commit();
        } catch (SQLException e) {
            if (savepoint != null) {
                conncection.rollback(savepoint);
            } else {
                conncection.rollback();
            }
            //theLogger.error(e.getMessage());
        } finally {
            if(statement != null) {
                statement.close();
            }
            if (conncection != null) {
                conncection.close();
            }
        }
        return driverList;
    }

    @Override
    public Driver findByID(int anID) throws SQLException {
        return null;
    }

    @Override
    public Driver findByName(String aName) throws SQLException {
        return null;
    }

    @Override
    public boolean isObjectExistsByID(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }
}
