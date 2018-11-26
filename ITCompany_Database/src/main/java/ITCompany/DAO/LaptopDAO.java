package ITCompany.DAO;

import ITCompany.Entity.Laptop;
import ITCompany.Entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LaptopDAO extends AbstractDAO {

    @Override
    public List findAll() throws ClassNotFoundException {
        String sql = "select * from Laptop";
        List<Laptop> laptopsList = new ArrayList<Laptop>();
        Connection conn = null;
        Statement stat = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Labor_SQL", "root", "");
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

        } catch (SQLException e) {
            System.err.println("SQL exeption " + e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Labor_SQL", "root", "");
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
            } catch (SQLException e) {}
            return productsSet;
        }
}
