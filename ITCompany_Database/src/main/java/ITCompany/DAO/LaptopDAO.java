package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Laptop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDAO extends AbstractDAO {


    @Override
    public List findAll() {
        List<Laptop> laptopsList = new ArrayList<Laptop>();
        Connection conn = null;
        Statement stat = null;
        String sql = "select * from Laptop";
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
                Laptop theLaptop = new Laptop(unicCode, laptopModel, laptopSpeed, hardDriveSize, ram, screenSize, laptopPrice);
                laptopsList.add(theLaptop);
            }

        } catch (SQLException e) {
            System.err.println("SQL exeption " + e);
        } finally {
           // ConnectionPool.close();
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
    public Object update(Object entity) {
        return null;
    }



    public List<Laptop> showAllPCManufacturersBySpeedMoreThen() throws SQLException {
        String sql = "select pr.maker, pr.type, pr.model, lapt.speed from Product pr inner join Laptop lapt where lapt.speed > 600";
        List<Laptop> laptopsList = new ArrayList<Laptop>();
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
            Laptop theLaptop = new Laptop(unicCode, laptopModel, laptopSpeed, hardDriveSize, ram, screenSize, laptopPrice);
            laptopsList.add(theLaptop);
        }
        return laptopsList;
    }
}
