package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Laptop;
import ITCompany.Entity.Product;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LaptopDAO extends AbstractDAO <Integer, Laptop> {

    private static final Logger logger;

    static {
        logger = Logger.getLogger(LaptopDAO.class);
    }

    @Override
    public List findAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Laptop";
        List<Laptop> laptopsList = new ArrayList<Laptop>();
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
                int unicCode = resultSet.getInt("code");
                String laptopModel = resultSet.getString("model");
                int laptopSpeed = resultSet.getInt("speed");
                int hardDriveSize = resultSet.getInt("hd");
                int ram = resultSet.getInt("ram");
                int screenSize = resultSet.getInt("screen");
                int laptopPrice = resultSet.getInt("price");
                Laptop theLaptop = new Laptop(unicCode, laptopModel, laptopSpeed, hardDriveSize, ram, screenSize, laptopPrice);
                laptopsList.add(theLaptop);
            }
            conn.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            conn.rollback(savepoint);
        } finally {
            close(stat);
            close(conn);
        }
        return laptopsList;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Laptop entity) {
        return false;
    }

    @Override
    public Laptop update(Laptop entity) {
        return null;
    }


    public HashSet showAllPCManufacturersBySpeedMoreThen() throws ClassNotFoundException, SQLException {
        String sql = "select pr.maker, pr.type, pr.model, lapt.speed from Product pr inner join Laptop lapt where lapt.speed > 600";
        HashSet productsSet = new HashSet();
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
                int laptopSpeed = resultSet.getInt("lapt.speed");
                Laptop theLaptop = new Laptop(0, "", laptopSpeed, 0, 0, 0, 0);
                productsSet.add(theLaptop);
                String productMaker = resultSet.getString("pr.maker");
                String productType = resultSet.getString("pr.type");
                String productModel = resultSet.getString("pr.model");
                Product theProduct = new Product(productMaker, productModel, productType);
                productsSet.add(theProduct);
            }
            conn.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            conn.rollback(savepoint);
        } finally {
            close(stat);
            close(conn);
         }
         return productsSet;
    }
}
