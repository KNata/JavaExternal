package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Laptop;
import ITCompany.Entity.Product;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LaptopDAO implements AbstractDAO <Integer, Laptop> {

    private static final Logger logger;

    static {
        logger = Logger.getLogger(LaptopDAO.class);
    }


    public LaptopDAO() {}

    @Override
    public boolean create(Laptop aLaptop) throws SQLException, ClassNotFoundException{
        boolean isCreated = false;
        try {
            if (isTheProductExistByID(aLaptop.getUnicCode()) && isTheProductExistByModel(aLaptop.getModelOfLaptop())) {
                logger.info("This Laptop is already exists");
            } else if(isTheProductExistByModel(aLaptop.getModelOfLaptop()))  {
                logger.info("Count of selected laptop's model was changed");
                // update count of laptops
                isCreated = updateCountOfLaptops(aLaptop);
            } else {
                isCreated = addLaptop(aLaptop);
            }
        } catch (SQLException e) {}
        return isCreated;
    }

    public boolean addLaptop(Laptop aLaptop) throws ClassNotFoundException, SQLException{
        boolean isAdded = false;
        String sql = "insert into Laptop values('" +aLaptop.getUnicCode() + ", " + aLaptop.getModelOfLaptop() + ", "
        + aLaptop.getSpeedOfLaptop() + ", "+ aLaptop.getRam() + ", "+ aLaptop.getSizeOfHardDrive() + ", " + aLaptop.getLaptopPrice()
                + ", " + aLaptop.getSizeOfScreen() +"')";
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

    public boolean updateCountOfLaptops(Laptop aLaptop) throws SQLException, ClassNotFoundException{
        boolean status = false;
        int currentCount = aLaptop.getCountOfLaptopsBySelectedModel();
        int increaseCount = currentCount+1;
        String model = aLaptop.getModelOfLaptop();
        String updateSQL = "UPDATE Laptop SET count = ? WHERE model = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        Savepoint savePoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(updateSQL);
            statement.setInt(1, aLaptop.increaseCountOfLaptopsBySelectedModel());
            statement.setString(2, aLaptop.getModelOfLaptop());
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
    public boolean isTheProductExistByModel(String aModel) throws SQLException, ClassNotFoundException{
        String sql = "select code from Laptop where model = '" + aModel + "'";
        String laptopModel = "";
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
                laptopModel = resultSet.getString("model");
            }
            if (laptopModel.equals(aModel)) {
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
    public List findAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Laptop";
        List<Laptop> laptopsList = new ArrayList<Laptop>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                int unicCode = resultSet.getInt("code");
                String laptopModel = resultSet.getString("model");
                int laptopSpeed = resultSet.getInt("speed");
                int hardDriveSize = resultSet.getInt("hd");
                int ram = resultSet.getInt("ram");
                int screenSize = resultSet.getInt("screen");
                double laptopPrice = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                Laptop theLaptop = new Laptop(unicCode, laptopModel, laptopSpeed, hardDriveSize, ram, screenSize, laptopPrice, count);
                laptopsList.add(theLaptop);
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
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return laptopsList;
    }


    public boolean isTheProductExistByID(int anId) throws SQLException, ClassNotFoundException{
        String sql = "select code from Laptop where code = '" + anId + "'";
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
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException{
        boolean wasDeleted = false;
        if (isTheProductExistByID(id)) {
            String sql = "delete from Laptop where code = '" + id + "'";
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
            logger.info("Wrong ID");
        }
        return wasDeleted;
    }



    @Override
    public boolean update(int anID, double aPrice) throws SQLException, ClassNotFoundException{
        boolean status = false;
        String updateSQL = "UPDATE Laptop SET price = '" + aPrice + "' WHERE code = '" + anID + "'";
        Connection conn = null;
        Statement statement = null;
        Savepoint savePoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            statement.executeUpdate(updateSQL);
            status = true;
            savePoint = conn.setSavepoint("SavePoint");
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
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return status;
    }


    public HashSet showAllPCManufacturersBySpeedMoreThen() throws ClassNotFoundException, SQLException {
        String sql = "select pr.maker, pr.type, pr.model, lapt.speed from Product pr inner join Laptop lapt where lapt.speed > 600";
        HashSet productsSet = new HashSet();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                int laptopSpeed = resultSet.getInt("lapt.speed");
                Laptop theLaptop = new Laptop(0, "", laptopSpeed, 0, 0, 0, 0, 0);
                productsSet.add(theLaptop);
                String productMaker = resultSet.getString("pr.maker");
                String productType = resultSet.getString("pr.type");
                String productModel = resultSet.getString("pr.model");
                Product theProduct = new Product(productMaker, productModel, productType);
                productsSet.add(theProduct);
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
         return productsSet;
    }
}
