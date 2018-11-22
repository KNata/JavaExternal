package ITCompany.DAO;

import ITCompany.DBInteraction.DatabaseConnectionPoolResource;
import ITCompany.Entity.PC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import by.bsu.pool.ConnectionPool;

public class PCDao extends AbstractDAO {

    @Override
    public List findAll() {
        List<PC> pcList = new ArrayList<PC>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionPool.
        }
        return null;
    }

    @Override
    public Object findById(Object id) {
        return null;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public boolean create (Object aPc) {
        try (Connection con = DatabaseConnectionPoolResource.getConnection()) {
            int temp = 0;
            String sql = "INSERT INTO pc(model, speed, ram, hd, cd, price) VALUE (?,?,?,?,?,?) ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, aPc.getModelOfPC());
            preparedStatement.setString(2, aPc.getSpeedOfPC());
            preparedStatement.setInt(3, aPc.getRam());
            preparedStatement.setInt(4, aPc.getSizeOfHardDrive());
            preparedStatement.setString(5, aPc.getSpeedOfCD());
            preparedStatement.setInt(5, aPc.getPcPrice());
            temp = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return false;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }
}
