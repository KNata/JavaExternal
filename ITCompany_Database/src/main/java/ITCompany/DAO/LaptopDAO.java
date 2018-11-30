package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Laptop;
import ITCompany.Entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LaptopDAO implements AbstractDAO <Integer, Laptop> {

    public LaptopDAO() {}

    @Override
    public List findAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Laptop";
        List<Laptop> laptopsList = new ArrayList<Laptop>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
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
                double laptopPrice = resultSet.getInt("price");
                Laptop theLaptop = new Laptop(unicCode, laptopModel, laptopSpeed, hardDriveSize, ram, screenSize, laptopPrice);
                laptopsList.add(theLaptop);
            }
            conn.rollback(savepoint);
            conn.commit();
        } catch (SQLException e) {
        } finally {
            stat.close();
            conn.close();
        }
        return laptopsList;
    }


    public boolean isTheProductExist(int anId) throws SQLException, ClassNotFoundException{
        String sql = "select code from Laptop where code = '" + anId + "'";
        int laptopId = -1;
        boolean isPresent = false;
        Connection conn = null;
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            statement = conn.createStatement();
            savepoint = conn.setSavepoint();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                laptopId = resultSet.getInt("code");
            }
            if (laptopId == anId) {
                isPresent = true;
            }
            //conn.rollback(savepoint);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            statement.close();
            conn.close();
        }
        return isPresent;
    }

    @Override
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException{
        boolean wasDeleted = false;
        if (isTheProductExist(id)) {
            String sql = "delete from Laptop where code = '" + id + "'";
            if (id != -1) {
                Connection conn = null;
                Statement stat = null;
                Savepoint savePoint = null;
                try {
                    conn = ConnectionPool.getConnection();
                    stat = conn.createStatement();
                    savePoint = conn.setSavepoint();
                    stat.executeUpdate(sql);
                    wasDeleted = true;
                  //  conn.rollback(savePoint);
                    conn.commit();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                } finally {
                    stat.close();
                    conn.close();
                }
            }
        } else {
            System.out.println("Wrong ID");
        }
        return wasDeleted;
    }


    @Override
    public boolean create(Laptop entity) {
     /*   boolean status = false;
        if (isTheLaptopExist(entity.getUnicCode())) {
            System.out.println("The item is already exists");
        } else {
                int laptopID = entity.getUnicCode();
                String laptopModel = entity.getModelOfLaptop();
                int laptopSpeed = entity.getSpeedOfLaptop();
                int laptopRam = entity.getRam();
                int laptopHD = entity.getSizeOfHardDrive();
                int laptopScreen = entity.getSizeOfScreen();
                double laptopPrice = entity.getLaptopPrice();
                String sql = "insert into Laptop(code, model, speed, ram, hd, price, screen) values (?,?,?,?,?,?,?)";
                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    connection = ConnectionPool.getConnection();
                    statement = connection.prepareStatement(sql);
                    statement.setInt(1, laptopID);
                    statement.setString(2, laptopModel);
                    statement.setInt(3, laptopSpeed);
                    statement.setInt(4, laptopRam);
                    statement.setInt(5, laptopHD);
                    statement.setDouble(6, laptopPrice);
                    statement.setInt(7, laptopScreen);
                    statement.executeUpdate();
                    status = true;
                    System.err.println("Laptop was successfully added");
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
        }
        return status; */
     throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(int anID, double aPrice) throws SQLException, ClassNotFoundException{
        boolean status = false;
        String updateSQL = "UPDATE Laptop SET price = '" + aPrice + "' WHERE code = '" + anID + "'";
        Connection conn = null;
        Statement statement = null;
        try {
            conn = ConnectionPool.getConnection();
            statement = conn.createStatement();
            statement.executeUpdate(updateSQL);
            status = true;
            System.out.println("Done");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            statement.close();
            conn.close();
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
          //  conn.rollback(savepoint);
            conn.commit();
        } catch (SQLException e) {
        } finally {
            stat.close();
            conn.close();
         }
         return productsSet;
    }
}
