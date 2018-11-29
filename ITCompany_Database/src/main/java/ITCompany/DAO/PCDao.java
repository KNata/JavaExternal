package ITCompany.DAO;


import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.PC;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PCDao extends AbstractDAO <Integer, PC> {

    private static final Logger logger;


    static {
        logger = Logger.getLogger(PCDao.class);
    }


    @Override
    public List findAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from PC";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Savepoint savepoint = null;
        //Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            st = conn.createStatement();
            savepoint = conn.setSavepoint();
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
            } catch (SQLException d) {
           // conn.rollback(savepoint);
           // logger.error(d.getMessage());
        } finally {
               close(st);
               close(conn);
        }
        return pcList;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(PC entity) {
        return false;
    }

    @Override
    public PC update(PC entity) {
        return null;
    }


    // res should be 0
    public List<PC> allPCBySelectedSpeedAndPrice() throws ClassNotFoundException, SQLException {
        String sql = "select * from PC where speed > 550 and price < 800 order by price ASC";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
     //   Savepoint savePoint = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            st = conn.createStatement();
        //    savePoint = conn.setSavepoint();
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
    //        conn.commit();
        } catch (SQLException e) {
//            conn.rollback(savePoint);
//            logger.error(e.getMessage());
        } finally {
//            close(st);
//            close(conn);
        }
        return pcList;
    }

    public List<PC> allPCBySelectedSpeedInPriceRange() throws ClassNotFoundException, SQLException {
        String sql = "select model, speed from PC where speed BETWEEN 400 and 600 order by hd desc";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Savepoint savePoint = null;
       // Class.forName("com.mysql.cj.jdbc.Driver");
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
          //  conn.rollback(savePoint);
          //  logger.error(e.getMessage());
        } finally {
            close(st);
            close(conn);
        }
        return pcList;
    }

    public List<PC> showAllPCWhichModelContainTwoSameNumbers() throws ClassNotFoundException, SQLException{
        String sql = "select * from PC where model like '%11%'";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Savepoint savePoint = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            st = conn.createStatement();
            savePoint = conn.setSavepoint();
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
            conn.rollback(savePoint);
            logger.error(e.getMessage());
        } finally {
            close(st);
            close(conn);
        }
        return pcList;
    }

    private List<PC> showAllPCManufacturersBySelectedHD() throws ClassNotFoundException, SQLException {
        String sql = "select marker, type, speed, hd from PC where hd > 8";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Savepoint savePoint = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = ConnectionPool.getConnection();
            st = conn.createStatement();
            savePoint = null;
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
            conn.rollback(savePoint);
            logger.error(e.getMessage());
        } finally {
            close(st);
            close(conn);
        }
        return pcList;
    }

    public List<PC> showAllPCManufacturersBySelectedSpeed() throws SQLException {
        String sql = "select pr.maker from Product pr inner join Laptop lapt where lapt.speed <= 500";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Savepoint savePoint = null;
        try {
            conn = ConnectionPool.getConnection();
            st = conn.createStatement();
            savePoint = conn.setSavepoint();
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
//            conn.rollback(savePoint);
         //   logger.error(e.getMessage());
        } finally {
            close(st);
            close(conn);
        }
        return pcList;
    }

}
