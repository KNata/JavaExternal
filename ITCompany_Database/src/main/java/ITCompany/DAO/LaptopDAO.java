package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Laptop;
import ITCompany.Entity.Product;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LaptopDAO extends AbstractDAO {

    private Logger logger;

    @Override
    public List findAll() throws ClassNotFoundException {
        String sql = "select * from Laptop";
        List<Laptop> laptopsList = new ArrayList<Laptop>();
        Connection conn = null;
        Statement stat = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            stat = conn.createStatement();
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
            logger.error("SQL exeption " + e);
        } finally {
            close(stat);
            close(conn);
        }
        return laptopsList;
    }

    @Override
    public boolean delete(Object id) {

        return false;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public Object update(Object theLaptop) {

        return null;
    }

    public HashSet showAllPCManufacturersBySpeedMoreThen() throws ClassNotFoundException {
        String sql = "select pr.maker, pr.type, pr.model, lapt.speed from Product pr inner join Laptop lapt where lapt.speed > 600";
        HashSet productsSet = new HashSet();
        Connection conn = null;
        Statement stat = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            stat = conn.createStatement();
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
//            logger.error(e);
        } finally {
            close(stat);
            close(conn);
         }
         return productsSet;
    }
}
