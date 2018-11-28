package ITCompany.DBInteraction;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionPool {

    private static final String DATASOURCE_NAME = "jdbc:mysql://localhost/Labor_SQL";
    private static DataSource dataSource;
    private static Logger logger;

    static {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);
        } catch (NamingException e) {
//            logger.error(e);
        }
    }

    private ConnectionPool() {}

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Labor_SQL", "root", "");
        return connection;
    }


}

