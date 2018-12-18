package DAO;

import Model.Visitor;

import java.sql.SQLException;
import java.util.ArrayList;

public class VisitorDAO implements AbstractDAO<String, Visitor> {


    @Override
    public boolean addRecord(Visitor anEntity) throws SQLException {
        String insertSQL = "insert into `mydb`.`Visitor`values(?, ?, ?, ?, ?, ?)";
        

        return false;
    }

    @Override
    public boolean deleteRecord(String anID) throws SQLException {
        int visitorID = Integer.valueOf(anID);

        return false;
    }

    @Override
    public ArrayList<Visitor> findAll() throws SQLException {
        return null;
    }

    @Override
    public Visitor findByID(String anID) throws SQLException {
        int visitorID = Integer.valueOf(anID);

        return null;
    }

    @Override
    public Visitor findByName(String aName) throws SQLException {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean update() {
        return false;
    }
}
