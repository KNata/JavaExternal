package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Laptop;
import ITCompany.Entity.PC;
import ITCompany.Entity.Printer;
import ITCompany.Entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProductDAO extends AbstractDAO {
    @Override
    public List findAll() throws ClassNotFoundException {
        String sql = "select * from Product";
        List<Product> productList = new ArrayList<Product>();
        Connection conn = null;
        Statement stat = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Labor_SQL", "root", "");
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                String maker = resultSet.getString("maker");
                String model = resultSet.getString("model");
                String type = resultSet.getString("type");
                Product theProduct = new Product(maker, model, type);
                productList.add(theProduct);
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

    public HashSet showAllProductsExeptPrinters() throws ClassNotFoundException {
        String sql = "select pr.maker, pr.model, pr.type, lapt.price, pc.price from Product pr, Laptop lapt, PC pc where not pr.type = 'Printer'";
        HashSet selectedProductList = new HashSet();
        Connection conn = null;
        Statement stat = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Labor_SQL", "root", "");
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                String productMaker = resultSet.getString("pr.maker");
                String productModel = resultSet.getString("pr.model");
                String productType = resultSet.getString("pr.type");
                Product theProduct = new Product(productMaker, productModel, productType);
                selectedProductList.add(theProduct);
                double pcPrice = resultSet.getDouble("pc.price");
                PC thePC = new PC(0, "", 0, 0, 0, "", pcPrice);
                selectedProductList.add(thePC);
                int laptopPrice = resultSet.getInt("lapt.price");
                Laptop theLaptop = new Laptop(0, "", 0, 0, 0, 0, laptopPrice);
                selectedProductList.add(theLaptop);
            }
        } catch (SQLException e) {
        }
        return selectedProductList;
    }

    public List<Product> findLaptopMakersByMeketAsc() throws ClassNotFoundException {
        String sql = "select type, maker from Product where type = 'Laptop' order by maker ASC";
        List<Product> laptopsList = new ArrayList<Product>();
        Connection conn = null;
        Statement stat = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/Labor_SQL", "root", "");
                stat = conn.createStatement();
                ResultSet resultSet = stat.executeQuery(sql);
                while (resultSet.next()) {
                    String productType = resultSet.getString("type");
                    String productMaker = resultSet.getString("maker");
                    Product theProduct = new Product(productMaker, "", productType);
                    laptopsList.add(theProduct);
                }
            } catch (SQLException e) {}
        return laptopsList;
    }


}
