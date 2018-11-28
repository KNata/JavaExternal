package ITCompany.DAO;


import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.PC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PCDao extends AbstractDAO {


    @Override
    public List findAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from PC";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Labor_SQL", "root", "");

            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                int unicode = resultSet.getInt("code");
                String model = resultSet.getString("model");
                int pcSpeed = resultSet.getInt("speed");
                int ram = resultSet.getInt("ram");
                int hd = resultSet.getInt("hd");
                String cd = resultSet.getString("cd");
                double price = resultSet.getDouble("price");
                PC thePC = new PC(unicode, model, pcSpeed, ram, hd, cd, price);
                pcList.add(thePC);
                conn.commit();
            }

        return pcList;
    }

    @Override
    public boolean delete(Object id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Object entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object update(Object entity) {
        throw new UnsupportedOperationException();
    }

    // res should be 0
    public List<PC> allPCBySelectedSpeedAndPrice() throws ClassNotFoundException {
        String sql = "select * from PC where speed > 550 and price < 800 order by price ASC";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Labor_SQL","root", "");
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next()) {
                int unicode = resultSet.getInt("code");
                String model = resultSet.getString("model");
                int pcSpeed = resultSet.getInt("speed");
                int ram = resultSet.getInt("ram");
                int hd = resultSet.getInt("hd");
                String cd = resultSet.getString("cd");
                double price = resultSet.getDouble("price");
                PC thePC = new PC(unicode, model, pcSpeed, ram, hd, cd, price);
                pcList.add(thePC);
            }
            conn.commit();
        } catch (SQLException e) {

        }
        return pcList;
    }

    public List<PC> allPCBySelectedSpeedInPriceRange() throws ClassNotFoundException {
        String sql = "select model, speed from PC where speed BETWEEN 400 and 600 order by hd desc";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                int pcSpeed = resultSet.getInt("speed");
                PC thePC = new PC(0, model, pcSpeed, 0, 0, "", 0.0);
                pcList.add(thePC);
            }
            conn.commit();
        } catch (SQLException e) {
            close(st);
            close(conn);
        }
        return pcList;
    }

    public List<PC> showAllPCWhichModelContainTwoSameNumbers() throws ClassNotFoundException{
        String sql = "select * from PC where model like '%11%'";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                int unicode = resultSet.getInt("code");
                String model = resultSet.getString("model");
                int pcSpeed = resultSet.getInt("speed");
                int ram = resultSet.getInt("ram");
                int hd = resultSet.getInt("hd");
                String cd = resultSet.getString("cd");
                double price = resultSet.getDouble("price");
                PC thePC = new PC(unicode, model, pcSpeed, ram, hd, cd, price);
                pcList.add(thePC);
            }
            conn.commit();
        } catch (SQLException e) {
            close(st);
            close(conn);
        }
        return pcList;
    }

    private List<PC> showAllPCManufacturersBySelectedHD() throws ClassNotFoundException {
        String sql = "select marker, type, speed, hd from PC where hd > 8";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                int pcSpeed = resultSet.getInt("speed");
                int hd = resultSet.getInt("hd");
                PC thePC = new PC(0, model, pcSpeed, 0, hd, "", 0.0);
                pcList.add(thePC);
            }
            conn.commit();
        } catch(SQLException e) {
            close(st);
            close(conn);
        }
        return pcList;
    }

    private List<PC> showAllPCManufacturersBySelectedSpeed() {
        String sql = "select pr.maker from Product pr inner join Laptop lapt where lapt.speed <= 500";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionPool.getConnection();
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                int unicode = resultSet.getInt("code");
                String model = resultSet.getString("model");
                int pcSpeed = resultSet.getInt("speed");
                int ram = resultSet.getInt("ram");
                int hd = resultSet.getInt("hd");
                String cd = resultSet.getString("cd");
                double price = resultSet.getDouble("price");
                PC thePC = new PC(unicode, model, pcSpeed, ram, hd, cd, price);
                pcList.add(thePC);
            }
            conn.commit();
        } catch (SQLException e) {
            close(st);
            close(conn);
        }
        return pcList;
    }

}
