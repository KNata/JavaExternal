package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Laptop;
import ITCompany.Entity.Printer;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrinterDAO extends AbstractDAO <Integer, Printer> {

    private static final Logger logger;

    static {
        logger = Logger.getLogger(PrinterDAO.class);
    }


    @Override
    public List findAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Printer";
        List<Printer> printerList = new ArrayList<Printer>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            stat = conn.createStatement();
            savepoint = conn.setSavepoint();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                int code = resultSet.getInt("code");
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                Printer thePrinter = new Printer(code, model, color, type, price);
                printerList.add(thePrinter);
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback(savepoint);
            logger.error(e.getMessage());
        } finally {
            close(stat);
            close(conn);
        }
        return printerList;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Printer entity) {
        return false;
    }

    @Override
    public Printer update(Printer entity) {
        return null;
    }


    public List<Printer> showAllColorPrintersByDesc() throws ClassNotFoundException, SQLException {
        String sql = "select * from Printer where color = 'y' order by price desc";
        List<Printer> printerList = new ArrayList<Printer>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            stat = conn.createStatement();
            savepoint = conn.setSavepoint();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                int code = resultSet.getInt("code");
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                Printer thePrinter = new Printer(code, model, color, type, price);
                printerList.add(thePrinter);
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback(savepoint);
            logger.error(e.getMessage());
        } finally {
            close(stat);
            close(conn);
        }
        return printerList;
    }

    public List<Printer> showAllPrintersByPriceLessThenSelected() throws ClassNotFoundException, SQLException {
        String sql = "select model, type, price from Printer where price < 300 order by type desc";
        List<Printer> printerList = new ArrayList<Printer>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            stat = conn.createStatement();
            savepoint = conn.setSavepoint();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                Printer thePrinter = new Printer(0, model, "", type, price);
                printerList.add(thePrinter);
            }
        } catch (SQLException e) {
            conn.rollback(savepoint);
            logger.error(e.getMessage());
        } finally {
            close(stat);
            close(conn);
        }
        return printerList;
    }
}
