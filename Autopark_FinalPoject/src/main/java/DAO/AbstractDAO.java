package DAO;

import java.util.List;

public interface AbstractDAO<K, T> {

    /**
     *Basic class, which is to be implemented by ALL DAO classes
     * @param <K> key type
     * @param <T> model type
     */

    boolean addRecord(T anEntity);
    boolean deleteRecord(K anID);
    List<T> finfAll();
    T findByID(int anID);
    T findByName(String aName);
    boolean isObjectExistsByID(int id);
    boolean update();

}
