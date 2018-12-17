package ITCompany.DAO;

import ITCompany.Entity.Product;
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
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductDAOMockTest {

    @Mock
    private DataSource dataSource;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement stmt;
    @Mock
    private ResultSet resultSet;

    private Product theProduct;
    private ProductDAO productDAO;

    @Before
    public void setUp() throws Exception {
        productDAO = new ProductDAO();
        when(connection.prepareStatement(any(String.class))).thenReturn(stmt);
        when(dataSource.getConnection()).thenReturn(connection);

        theProduct = new Product("A", "1298", "Printer");
        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(1);
        when(resultSet.getString(2)).thenReturn(theProduct.getMarker());
        when(resultSet.getString(3)).thenReturn(theProduct.getModelNumber());
        when(resultSet.getString(4)).thenReturn(theProduct.getTypeOfModel());
        when(stmt.executeQuery()).thenReturn(resultSet);

    }

    @Test
    public void findAll() throws ClassNotFoundException, SQLException{
        assertEquals(16, productDAO.findAll().size());
    }

    @Test
    public void showAllProductsExeptPrinters() throws ClassNotFoundException, SQLException {
        assertNotNull(productDAO.showAllProductsExeptPrinters());
    }

    @Test
    public void findLaptopMakersByMeketAsc() throws ClassNotFoundException, SQLException {
        assertNotNull(productDAO.findLaptopMakersByMeketAsc());
    }
}