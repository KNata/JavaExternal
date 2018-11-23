package ITCompany.DAO;

import ITCompany.DBInteraction.ConnectionPool;
import ITCompany.Entity.Laptop;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDAO extends AbstractDAO {


    @Override
    public List findAll() {
        List<Laptop> laptopsList = new ArrayList<Laptop>();
        Connection conn = null;
        Statement stat = null;
        String sql = "select * from Laptop";
        try {
            conn = ConnectionPool.getConnection();
            stat = conn.createStatement();

        } catch (SQLException e) {}
        return null;
    }

    @Override
    public boolean delete(Object id) {

        return false;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }

    public List<Laptop> findLaptopMakersByMeketAsc() {
        String sql = "select type, maker from Product where type = 'Laptop' order by maker ASC";
        return null;
    }

    public List<Laptop> showAllPCManufacturersBySpeedMoreThen() {
        String sql = "select pr.maker, pr.type, pr.model, lapt.speed from Product pr inner join Laptop lapt where lapt.speed > 600";
        return null;
    }
}
