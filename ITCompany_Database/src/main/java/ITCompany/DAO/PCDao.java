package ITCompany.DAO;


import ITCompany.App;
import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.PC;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PCDao implements AbstractDAO <Integer, PC> {

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
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
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
                savepoint = conn.setSavepoint("Find all PC");
            }
            conn.commit();
            } catch (SQLException d) {
                if (savepoint == null) {
                    logger.error(d.getMessage());
                    conn.rollback();
                } else {
                    logger.error(d.getMessage());
                    conn.rollback(savepoint);
                }
        } finally {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return pcList;
    }

    @Override
    public boolean isTheProductExist(int anId) throws SQLException, ClassNotFoundException {
        String sql = "select code from PC where code = '" + anId + "'";
        int pcId = -1;
        boolean isPresent = false;
        Connection conn = null;
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                pcId = resultSet.getInt("code");
            }
            if (pcId == anId) {
                isPresent = true;
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
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return isPresent;
    }

    @Override
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException{
        boolean wasDeleted = false;
        if (isTheProductExist(id)) {
            String sql = "delete from PC where code = '" + id + "'";
            if (id != -1) {
                Connection conn = null;
                Statement stat = null;
                Savepoint savePoint = null;
                try {
                    conn = ConnectionPool.getConnection();
                    conn.setAutoCommit(false);
                    stat = conn.createStatement();
                    savePoint = conn.setSavepoint();
                    stat.executeUpdate(sql);
                    wasDeleted = true;
                    savePoint = conn.setSavepoint("SavePoint");
                    conn.commit();
                } catch (SQLException e) {
                    if (savePoint == null) {
                        logger.error(e.getMessage());
                        conn.rollback();
                    } else {
                        logger.error(e.getMessage());
                        conn.rollback(savePoint);
                    }
                } finally {
                    if (stat != null) {
                        stat.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                }
            }
        } else {
            logger.info("Wrong ID");
        }
        return wasDeleted;
    }

    @Override
    public boolean create(PC entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(int anID, double aPrice) throws SQLException, ClassNotFoundException{
        boolean status = false;
        String updateSQL = "UPDATE PC SET price = '" + aPrice + "' WHERE code = '" + anID + "'";
        Connection conn = null;
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            statement.executeUpdate(updateSQL);
            status = true;
            savepoint = conn.setSavepoint("SavePoint");
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
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return status;
    }


    // res should be 0
    public List<PC> allPCBySelectedSpeedAndPrice() throws ClassNotFoundException, SQLException {
        String sql = "select * from PC where speed > 550 and price < 800 order by price ASC";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Savepoint savePoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
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
                savePoint = conn.setSavepoint("SavePoint");
            }
            conn.commit();
        } catch (SQLException e) {
            if (savePoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
                conn.rollback(savePoint);
            }
        } finally {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return pcList;
    }

    public List<PC> allPCBySelectedSpeedInPriceRange() throws ClassNotFoundException, SQLException {
        String sql = "select model, speed from PC where speed BETWEEN 400 and 600 order by hd desc";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Savepoint savePoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                int pcSpeed = resultSet.getInt("speed");
                PC thePC = new PC(0, model, pcSpeed, 0, 0, "", 0.0);
                pcList.add(thePC);
                savePoint = conn.setSavepoint("SavePoint");
            }
            conn.commit();
        } catch (SQLException e) {
            if (savePoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
                conn.rollback(savePoint);
            }
        } finally {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return pcList;
    }

    public List<PC> showAllPCWhichModelContainTwoSameNumbers() throws ClassNotFoundException, SQLException{
        String sql = "select * from PC where model like '%11%'";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Savepoint savePoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
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
                savePoint = conn.setSavepoint();
            }
            conn.commit();
        } catch (SQLException e) {
            if (savePoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
                conn.rollback(savePoint);
            }
        } finally {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return pcList;
    }

    private List<PC> showAllPCManufacturersBySelectedHD() throws ClassNotFoundException, SQLException {
        String sql = "select marker, type, speed, hd from PC where hd > 8";
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        Statement st = null;
        Savepoint savePoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                int pcSpeed = resultSet.getInt("speed");
                int hd = resultSet.getInt("hd");
                PC thePC = new PC(0, model, pcSpeed, 0, hd, "", 0.0);
                pcList.add(thePC);
                savePoint = conn.setSavepoint();
            }
            conn.commit();
        } catch(SQLException e) {
            if (savePoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
                conn.rollback(savePoint);
            }
        } finally {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
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
            conn.setAutoCommit(false);
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
                savePoint = conn.setSavepoint();
            }
            conn.commit();
        } catch (SQLException e) {
            if (savePoint == null) {
                logger.error(e.getMessage());
                conn.rollback();
            } else {
                logger.error(e.getMessage());
                conn.rollback(savePoint);
            }
        } finally {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return pcList;
    }

}
