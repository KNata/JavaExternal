package ITCompany.DBInteraction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class WrapperConnector {

    private Connection connection;
    private Logger logger;

    public WrapperConnector() {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("databaseProperties.properties");
            String url = resource.getString("url");
            String user = resource.getString("user");
            String pass = resource.getString("password");
            Properties prop = new Properties();
            prop.put("user", user);
            prop.put("password", pass);
            connection = DriverManager.getConnection(url, prop);

        } catch (MissingResourceException e) {
            logger.error("Properties file missing " + e);
        } catch (SQLException e) {
            logger.error("Not obtain connection " + e);
        }
    }

    public Statement getStatement() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement(); if (statement != null) {
                return statement;
            }
        }
        throw new SQLException("connection or statement is null");
    }


}
