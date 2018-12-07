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

public interface AbstractDAO<K, T> {


    public abstract List<T> findAll() throws ClassNotFoundException, SQLException;
   // public abstract List<T> findbyID(K anId) throws ClassNotFoundException, SQLException;
    public abstract boolean delete(K id) throws SQLException, ClassNotFoundException;
    public abstract boolean create(T entity) throws SQLException, ClassNotFoundException;
    public abstract boolean update(int anID, double aPrice) throws SQLException, ClassNotFoundException;
    public abstract boolean isTheProductExistByID(int anId) throws SQLException, ClassNotFoundException;
    public abstract boolean isTheProductExistByModel(String aModel) throws SQLException, ClassNotFoundException;


}
