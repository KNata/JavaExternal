package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Guest;
import ITCompany.Exeptions.EmptyParameterExeption;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestsDAO {

//    private static final Logger logger;
//
//    static {
//        logger = Logger.getLogger(GuestsDAO.class);
//    }


    public boolean addUser(Guest aGuest) throws SQLException, ClassNotFoundException {
        String sql = "insert into User values(?,?,?,?,?,?)";
        boolean isInserted = false;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Savepoint savepoint = null;
        if (isUserExist(aGuest.getLogin())) {
            isInserted = false;
            System.out.println("User with this this login is already exists in the system. Please use another name for login. Thank you!");
        } else {
            try {
                conn = ConnectionPool.getConnection();
                conn.setAutoCommit(false);
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, aGuest.getId());
                preparedStatement.setString(2, aGuest.getLogin());
                preparedStatement.setString(3, aGuest.getPassword());
                preparedStatement.setString(4, aGuest.getName());
                preparedStatement.setString(5, aGuest.getEmail());
                preparedStatement.setString(6, aGuest.getRole());
                isInserted = true;
                savepoint = conn.setSavepoint();
                conn.commit();
            } catch (SQLException e) {
                System.err.println("Something went wrong");
                if (savepoint == null) {
                    conn.rollback();
                } else {
                    conn.rollback(savepoint);
                }
            } finally {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        }
        return isInserted;
    }

    public boolean editUserOnlyForUser(int anID, String aPasswors, String aName, String anEmail) throws SQLException{
        if (aPasswors == null && aName == null && anEmail == null) {
            throw new EmptyParameterExeption();
        }
        if (aPasswors == null && aName == null && anEmail == null) {
            throw new EmptyParameterExeption();
        }
        String sql = "update User set password = ?, name = ?, email = ? where id = '" + anID + "'";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Savepoint savepoint = null;

        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, aPasswors);
            preparedStatement.setString(2, aName);
            preparedStatement.setString(3, anEmail);
            preparedStatement.executeUpdate();
            savepoint = conn.setSavepoint();
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                //   logger.error(e.getMessage());
                conn.rollback();
            } else {
                //  logger.error(e.getMessage());
                conn.rollback(savepoint);
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public boolean editUserOnlyForAdmin(int anID, String aPasswors, String aName, String anEmail, String aRole) throws SQLException {
        if (aPasswors == null && aName == null && anEmail == null) {
            throw new EmptyParameterExeption();
        }
        if (aPasswors == null && aName == null && anEmail == null) {
            throw new EmptyParameterExeption();
        }
        String sql = "update User set password = ?, name = ?, email = ?, role = ? where id = '" + anID + "'";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Savepoint savepoint = null;

        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, aPasswors);
            preparedStatement.setString(2, aName);
            preparedStatement.setString(3, anEmail);
            preparedStatement.setString(4, aRole);
            preparedStatement.executeUpdate();
            savepoint = conn.setSavepoint();
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                //   logger.error(e.getMessage());
                conn.rollback();
            } else {
                //  logger.error(e.getMessage());
                conn.rollback(savepoint);
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }


    public boolean isUserExist(String login) throws SQLException {
        String sql = "select * from User where login = '" + login +  "'";
        List<Guest> userList = new ArrayList<Guest>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        String userLogin = "";
        boolean doesExist = false;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                userLogin = resultSet.getString("login");
            }
            if (login.equals(userLogin)) {
                doesExist = true;
            }
            savepoint = conn.setSavepoint("SavePoint");
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                //   logger.error(e.getMessage());
                conn.rollback();
            } else {
                //  logger.error(e.getMessage());
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
        return doesExist;
    }

    public boolean doesTheLoginAndPassMachToUser(String login, String password) throws SQLException, ClassNotFoundException{
        String sql = "select login, password from User where login = '" + login + "'";
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        String userLogin = "";
        String userPassword = "";
        boolean trueCredentias  = false;
        try {
            conn = ConnectionPool.getConnection();
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                userLogin = resultSet.getString("login");
                userPassword = resultSet.getString("password");
            }
            if (login.equals(userLogin) && password.equals(userPassword)) {
                trueCredentias = true;
            } else {
                trueCredentias = false;
            }
            savepoint = conn.setSavepoint("SavePoint");
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                //   logger.error(e.getMessage());
                conn.rollback();
            } else {
                //  logger.error(e.getMessage());
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
        return trueCredentias;
    }

    public Guest findUserByLogin() throws SQLException {
        String sql = "select * from User where login = '" + "'";
        Guest theGuest = null;
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String userLogin = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                String userFullName = resultSet.getString("name");
                String userEmail = resultSet.getString("email");
                String userRole = resultSet.getString("role");
                theGuest = new Guest(userId, userLogin, userPassword, userFullName, userEmail, userRole);
                savepoint = conn.setSavepoint("SavePoint");
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
                //   logger.error(e.getMessage());
                conn.rollback();
            } else {
                //  logger.error(e.getMessage());
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
        return theGuest;
    }

    public List findAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from User";
        List<Guest> userList = new ArrayList<Guest>();
        Connection conn = null;
        Statement stat = null;
        Savepoint savepoint = null;
        try {
            conn = ConnectionPool.getConnection();
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String userLogin = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                String userFullName = resultSet.getString("name");
                String userEmail = resultSet.getString("email");
                String userRole = resultSet.getString("role");
                Guest theGuest = new Guest(userId, userLogin, userPassword, userFullName, userEmail, userRole);
                userList.add(theGuest);
                savepoint = conn.setSavepoint("SavePoint");
            }
            conn.commit();
        } catch (SQLException e) {
            if (savepoint == null) {
             //   logger.error(e.getMessage());
                conn.rollback();
            } else {
              //  logger.error(e.getMessage());
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
        return userList;
    }

    public boolean deletUser(String aName) throws SQLException { throw new UnsupportedOperationException(); }


}
