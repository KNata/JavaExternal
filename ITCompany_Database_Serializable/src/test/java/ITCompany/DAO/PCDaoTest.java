package ITCompany.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class PCDaoTest {

    private static PCDao pcDao;

    @BeforeClass
    public static void setUp() {
        pcDao = new PCDao();
    }

    @Test
    public void isTheProductExist() throws SQLException, ClassNotFoundException {
        assertTrue(pcDao.isTheProductExist(2));
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException{
        assertTrue(pcDao.delete(1));
    }

    @Test
    public void allPCBySelectedSpeedAndPrice() throws SQLException, ClassNotFoundException{
        assertEquals(0, pcDao.allPCBySelectedSpeedAndPrice());
    }

    @Test
    public void allPCBySelectedSpeedInPriceRange() throws SQLException, ClassNotFoundException{
        assertEquals(7, pcDao.allPCBySelectedSpeedInPriceRange());
    }

    @Test
    public void showAllPCWhichModelContainTwoSameNumbers() throws SQLException, ClassNotFoundException {
        assertEquals(3, pcDao.showAllPCWhichModelContainTwoSameNumbers());
    }

    @Test
    public void showAllPCManufacturersBySelectedSpeed() throws SQLException, ClassNotFoundException{
        assertEquals(0, pcDao.showAllPCManufacturersBySelectedSpeed());
    }
}