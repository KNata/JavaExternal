package ITCompany.DAO;

import java.util.List;

public abstract class AbstractDAO<K, T> {

    public AbstractDAO() {
    }

    public abstract List<T> findAll();
    public abstract T findById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(T entity);
    public abstract T update(T entity);


}
