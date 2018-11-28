package ITCompany.DAO;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<K, T> {

    private Logger logger;

    public AbstractDAO() {
    }

    public abstract List<T> findAll() throws ClassNotFoundException, SQLException;
    public abstract boolean delete(Object id);
    public abstract boolean create(Object entity);
    public abstract T update(Object entity);


    public void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    public void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}
