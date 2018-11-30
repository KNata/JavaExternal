package ITCompany.DAO;

import ITCompany.App;
import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Laptop;
import ITCompany.Entity.PC;
import ITCompany.Entity.Product;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProductDAO implements AbstractDAO <Integer, Product> {

    private static final Logger logger;

    static {
        logger = Logger.getLogger(ProductDAO.class);
    }

    @Override
    public List findAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Product";
        List<Product> productList = new ArrayList<Product>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                String maker = resultSet.getString("maker");
                String model = resultSet.getString("model");
                String type = resultSet.getString("type");
                Product theProduct = new Product(maker, model, type);
                productList.add(theProduct);
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
        return productList;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Product entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(int anID, double aPrice) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isTheProductExist(int anId) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException();    }


    public HashSet showAllProductsExeptPrinters() throws ClassNotFoundException, SQLException {
        String sql = "select pr.maker, pr.model, pr.type, lapt.price, pc.price from Product pr, Laptop lapt, PC pc where not pr.type = 'Printer'";
        HashSet selectedProductList = new HashSet();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
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
        return selectedProductList;
    }

    public List<Product> findLaptopMakersByMeketAsc() throws ClassNotFoundException, SQLException {
        String sql = "select type, maker from Product where type = 'Laptop' order by maker ASC";
        List<Product> laptopsList = new ArrayList<Product>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
            try {
                conn = ConnectionPool.getConnection();
                conn.setAutoCommit(false);
                stat = conn.createStatement();
                ResultSet resultSet = stat.executeQuery(sql);
                while (resultSet.next()) {
                    String productType = resultSet.getString("type");
                    String productMaker = resultSet.getString("maker");
                    Product theProduct = new Product(productMaker, "", productType);
                    laptopsList.add(theProduct);
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
        return laptopsList;
    }
}
