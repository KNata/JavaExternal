package ITCompany.Entity;

import ITCompany.DAO.PCDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PCTest {

    @Mock
    PCDao pcDAO;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUnicCode() {

    }

    @Test
    public void getModelOfPC() {
    }

    @Test
    public void getSpeedOfPC() {
    }

    @Test
    public void getPcPrice() {
    }
}

