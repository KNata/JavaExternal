package ITCompany.DAO;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *Basic class, which is to be implemented by ALL DAO classes
 * @param <K> key type
 * @param <T> model type
 */

public abstract class AbstractDAO<K, T> {

    private Logger logger;

    public AbstractDAO() {
    }



    public abstract List<T> findAll() throws ClassNotFoundException, SQLException;
   // public abstract List<T> findbyID(K anId) throws ClassNotFoundException, SQLException;
    public abstract boolean delete(K id);
    public abstract boolean create(T entity);
    public abstract T update(T entity);


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
