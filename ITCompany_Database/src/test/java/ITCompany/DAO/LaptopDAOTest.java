package ITCompany.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class LaptopDAOTest {

    private static LaptopDAO laptopDAO;

    @BeforeClass
    public static void setUp() {
        laptopDAO = new LaptopDAO();
    }

    @Test
    public void isTheProductExist() throws SQLException, ClassNotFoundException{
        assertTrue(laptopDAO.isTheProductExist(1));
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException{
        assertTrue(laptopDAO.delete(5));
    }


    @Test
    public void showAllPCManufacturersBySpeedMoreThen() throws SQLException, ClassNotFoundException {
        assertEquals(17, laptopDAO.showAllPCManufacturersBySpeedMoreThen().size());
    }
}