package DAO;

import Model.Visitor;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisitorDAOTest {

    @Test
    public void addRecord() {
        Visitor theVisitor = Visitor.newBuilder().setVisitorID(5).setVisitorName("Andrii Osadchuk")
                .setVisitorLogin("andrii").setVisitorPassword("1234").setVisitorRole("Driver").setAdminStatus(false).build();
    }

    @Test
    public void deleteRecord() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByID() {
    }

    @Test
    public void findByName() {
    }
}