package ITCompany.DAO;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<K, T> {

    public AbstractDAO() {
    }

    public abstract List<T> findAll() throws ClassNotFoundException, SQLException;
    public abstract boolean delete(Object id);
    public abstract boolean create(Object entity);
    public abstract T update(Object entity);


}
