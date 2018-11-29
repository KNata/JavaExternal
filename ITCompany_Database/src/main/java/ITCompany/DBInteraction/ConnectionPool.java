package ITCompany.DBInteraction;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionPool {

    private static BasicDataSource ds = new BasicDataSource();
    private static Properties property = new Properties();
   // public static final Logger logger;

    static {
    //    logger = Logger.getLogger(ConnectionPool.class);
    }

    static {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/nataliakiselyk/Documents/GitHub/JavaExternal/ITCompany_Database/src/main/resources/databaseProperties.properties");
            property.load(fis);
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUrl(property.getProperty("url"));
            ds.setUsername(property.getProperty("user"));
            ds.setPassword(property.getProperty("password"));
        } catch (IOException e) {
          //  logger.error(e.getMessage());
            System.err.println(e.getMessage());
        }finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                 //   logger.error(e.getMessage());
                    System.err.println(e.getMessage());
                }
            }
        }
    }


    public static Connection getConnection() throws SQLException {
        Connection connection = ds.getConnection();
       // Connection connection =   DriverManager.getConnection("jdbc:mysql://localhost/Labor_SQL", "root", "");
        return connection;
    }


}

