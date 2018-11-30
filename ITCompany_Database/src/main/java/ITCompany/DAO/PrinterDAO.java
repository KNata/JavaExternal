package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Laptop;
import ITCompany.Entity.Printer;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrinterDAO implements AbstractDAO <Integer, Printer> {


    @Override
    public List findAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Printer";
        List<Printer> printerList = new ArrayList<Printer>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                int code = resultSet.getInt("code");
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                Printer thePrinter = new Printer(code, model, color, type, price);
                printerList.add(thePrinter);
                savepoint = conn.setSavepoint();
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                conn.rollback();
            } else {
                conn.rollback(savepoint);
            }
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return printerList;
    }

    public boolean isTheProductExist(int anId) throws SQLException, ClassNotFoundException{
        String sql = "select code from Printer where code = '" + anId + "'";
        int laptopId = -1;
        boolean isPresent = false;
        Connection conn = null;
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                laptopId = resultSet.getInt("code");
            }
            if (laptopId == anId) {
                isPresent = true;
                savepoint = conn.setSavepoint();
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                conn.rollback();
            } else {
                conn.rollback(savepoint);
            }        } finally {
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return isPresent;
    }

    @Override
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException{
        boolean wasDeleted = false;
        if (isTheProductExist(id)) {
            String sql = "delete from Printer where code = '" + id + "'";
            if (id != -1) {
                Connection conn = null;
                Statement stat = null;
                Savepoint savePoint = null;
                try {
                    conn = ConnectionPool.getConnection();
                    conn.setAutoCommit(false);
                    stat = conn.createStatement();
                    stat.executeUpdate(sql);
                    wasDeleted = true;
                    savePoint = conn.setSavepoint();
                    conn.commit();
                } catch (SQLException e) {
                    if (savePoint == null) {
                        conn.rollback();
                    } else {
                        conn.rollback(savePoint);
                    }
                } finally {
                    if (stat != null) {
                        stat.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                }
            }
        } else {
            System.out.println("Wrong ID");
        }
        return wasDeleted;
    }

    @Override
    public boolean create(Printer entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(int anID, double aPrice) throws SQLException, ClassNotFoundException{
        boolean status = false;
        String updateSQL = "UPDATE Printer SET price = '" + aPrice + "' WHERE code = '" + anID + "'";
        Connection conn = null;
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            statement.executeUpdate(updateSQL);
            status = true;
            savepoint = conn.setSavepoint();
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                conn.rollback();
            } else {
                conn.rollback(savepoint);
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return status;
    }


    public List<Printer> showAllColorPrintersByDesc() throws ClassNotFoundException, SQLException {
        String sql = "select * from Printer where color = 'y' order by price desc";
        List<Printer> printerList = new ArrayList<Printer>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                int code = resultSet.getInt("code");
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                Printer thePrinter = new Printer(code, model, color, type, price);
                printerList.add(thePrinter);
                savepoint = conn.setSavepoint();
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                conn.rollback();
            } else {
                conn.rollback(savepoint);
            }
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return printerList;
    }

    public List<Printer> showAllPrintersByPriceLessThenSelected() throws ClassNotFoundException, SQLException {
        String sql = "select model, type, price from Printer where price < 300 order by type desc";
        List<Printer> printerList = new ArrayList<Printer>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                Printer thePrinter = new Printer(0, model, "", type, price);
                printerList.add(thePrinter);
                savepoint = conn.setSavepoint();
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                conn.rollback();
            } else {
                conn.rollback(savepoint);
            }
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return printerList;
    }
}
