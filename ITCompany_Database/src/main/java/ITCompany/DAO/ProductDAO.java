package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO {
    @Override
    public List findAll() {
        String sql = "select * from Product";
        List<Product> productList = new ArrayList<Product>();
        Connection conn = null;
        Statement stat = null;
        try {
            conn = ConnectionPool.getConnection();
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                String unicCode = resultSet.getString("code");
                String laptopModel = resultSet.getString("model");
                String laptopSpeed = resultSet.getString("speed");
                int hardDriveSize = resultSet.getInt("hd");
                int ram = resultSet.getInt("ram");
                String screenSize = resultSet.getString("screen");
                int laptopPrice = resultSet.getInt("price");
                // Laptop theLaptop = new Laptop(unicCode, laptopModel, laptopSpeed, hardDriveSize, ram, screenSize, laptopPrice);
                //  laptopsList.add(theLaptop);
            }
             } catch (SQLException e) {
        } finally {}
        return productList;
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
    public Object update(Object entity) {
        return null;
    }

    public List<Product> showAllProductsExeptPrinters() {
        String sql = "select pr.maker, pr.model, pr.type, lapt.price, pc.price from Product pr, Laptop lapt, PC pc where not pr.type = 'Printer'";
        return null;
    }

    public List<Product> findLaptopMakersByMeketAsc() throws SQLException {
        String sql = "select type, maker from Product where type = 'Laptop' order by maker ASC";
        List<Product> laptopsList = new ArrayList<Product>();
        Connection conn = null;
        Statement stat = null;
        conn = ConnectionPool.getConnection();
        stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(sql);
        while (resultSet.next()) {
            String unicCode = resultSet.getString("code");
            String laptopModel = resultSet.getString("model");
            String laptopSpeed = resultSet.getString("speed");
            int hardDriveSize = resultSet.getInt("hd");
            int ram = resultSet.getInt("ram");
            String screenSize = resultSet.getString("screen");
            int laptopPrice = resultSet.getInt("price");
           // Laptop theLaptop = new Laptop(unicCode, laptopModel, laptopSpeed, hardDriveSize, ram, screenSize, laptopPrice);
          //  laptopsList.add(theLaptop);
        }
        return laptopsList;
    }


}
