package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Printer;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrinterDAO implements AbstractDAO <Integer, Printer> {

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
                int count = resultSet.getInt("count");
                Printer thePrinter = new Printer(code, model, color, type, price, count);
                printerList.add(thePrinter);
                savepoint = conn.setSavepoint();
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
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
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
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
                        logger.error(e.getMessage());
                        conn.rollback();
                    } else {
                        logger.error(e.getMessage());
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
    public boolean create(Printer aPrinter) throws SQLException, ClassNotFoundException{

        boolean isCreated = false;
        try {
            if (isTheProductExistByID(aPrinter.getUnicCode()) && isTheProductExistByModel(aPrinter.getModel())) {
                logger.info("This Laptop is already exists");
            } else if(isTheProductExistByModel(aPrinter.getModel()))  {
                logger.info("Count of selected laptop's model was changed");
                // update count of laptops
                isCreated = updateCountOfPrinters(aPrinter);
            } else {
                isCreated = addPrinter(aPrinter);
            }
        } catch (SQLException e) {}
        return isCreated;
    }

    public boolean addPrinter(Printer aPrinter) throws ClassNotFoundException, SQLException{
        boolean isAdded = false;
        String sql = "insert into Printer values('" +aPrinter.getUnicCode() + ", " + aPrinter.getModel() + ", "
                + aPrinter.getColor() + ", " + aPrinter.getType() + ", "+ aPrinter.getPrice() + ", "+ aPrinter.getCountOfPrinters()
                +"')";
        Connection connection = null;
        Statement preparedStatement = null;
        Savepoint savepoint = null;
        try {
            System.out.println("1");
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            System.out.println("2");
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("3");
            savepoint = connection.setSavepoint();
            System.out.println("Success");
            isAdded = true;
        } catch (SQLException e){
            if (savepoint == null) {
                logger.error(e.getMessage());
                connection.rollback();
            } else {
                logger.error(e.getMessage());
                connection.rollback(savepoint);
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return isAdded;
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
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
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

    public boolean updateCountOfPrinters(Printer aPrinter) throws SQLException, ClassNotFoundException{
        boolean status = false;
        String updateSQL = "UPDATE Printer SET count = ? WHERE model = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        Savepoint savePoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(updateSQL);
            statement.setInt(1, aPrinter.increasePrinterCount());
            statement.setString(2, aPrinter.getModel());
            statement.executeUpdate(updateSQL);
            status = true;
            savePoint = conn.setSavepoint("SavePoint");
            conn.commit();
            status = true;
            System.out.println("Success");
        } catch (SQLException e) {
            if (savePoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
                conn.rollback(savePoint);
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

    @Override
    public boolean isTheProductExistByID(int anId) throws SQLException, ClassNotFoundException {
        String sql = "select code from Printer where code = '" + anId + "'";
        int printerlpcId = -1;
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
                printerlpcId = resultSet.getInt("code");
            }
            if (printerlpcId == anId) {
                isPresent = true;
                savepoint = conn.setSavepoint("SavePoint");
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
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
        return isPresent;
    }

    @Override
    public boolean isTheProductExistByModel(String aModel) throws SQLException, ClassNotFoundException {
        String sql = "select code from Printer where model = '" + aModel + "'";
        String printerModel = "";
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
                printerModel = resultSet.getString("model");
            }
            if (printerModel.equals(aModel)) {
                isPresent = true;
                savepoint = conn.setSavepoint("SavePoint");
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
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
        return isPresent;
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
                int count = resultSet.getInt("count");
                Printer thePrinter = new Printer(code, model, color, type, price, count);
                printerList.add(thePrinter);
                savepoint = conn.setSavepoint();
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
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
                Printer thePrinter = new Printer(0, model, "", type, price, 0);
                printerList.add(thePrinter);
                savepoint = conn.setSavepoint();
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
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
