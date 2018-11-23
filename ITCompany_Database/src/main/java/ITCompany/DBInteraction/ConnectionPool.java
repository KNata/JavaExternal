package ITCompany.DBInteraction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionPool {

    private Connection connection;
    private static DataSource dataSourse;

    ConnectionPool() {
        try {
            ResourceBundle resourse = ResourceBundle.getBundle("");
            String url = resourse.getString("host");
            String user = resourse.getString("user");
            String password = resourse.getString("password");
            Properties properties = new Properties();
            properties.put("user", user);
            properties.put("password", password);
            connection = DriverManager.getConnection(url, properties);
        } catch (MissingResourceException e) {
            System.err.println("Properties file missing " + e);
        } catch (SQLException e) {
            System.err.println("Not obtain connection" + e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = dataSourse.getConnection();
        return conn;
    }


}
