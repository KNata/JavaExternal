package ITCompany.DBInteraction;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectionPoolTest {

    @Test
    public void getConnection() throws SQLException {
        Connection conn = ConnectionPool.getConnection();
        assertNotNull(conn);
    }


}