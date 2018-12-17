package ITCompany.DAO;

import ITCompany.Entity.Printer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrinterDAOMockTest {

    @Mock
    private DataSource dataSource;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement stmt;
    @Mock
    private ResultSet resultSet;

    private Printer thePrinter;
    private PrinterDAO printerDAO;

    @Before
    public void setUp() throws Exception {
        printerDAO = new PrinterDAO();
        Assert.assertNotNull(dataSource);
        when(connection.prepareStatement(any(String.class))).thenReturn(stmt);
        when(dataSource.getConnection()).thenReturn(connection);

        thePrinter = new Printer(21, "1276", "n", "Laser", 400.00);
        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(1);
        when(resultSet.getString(2)).thenReturn(thePrinter.getModel());
        when(resultSet.getString(3)).thenReturn(thePrinter.getColor());
        when(resultSet.getString(4)).thenReturn(thePrinter.getType());
        when(resultSet.getDouble(5)).thenReturn(thePrinter.getPrice());
        when(stmt.executeQuery()).thenReturn(resultSet);

    }

    @Test
    public void findAll() throws ClassNotFoundException, SQLException{
        assertEquals(6, printerDAO.findAll().size());
    }

    @Test
    public void isTheProductExist() throws ClassNotFoundException, SQLException {
        assertTrue(printerDAO.isTheProductExist(1));
    }


}