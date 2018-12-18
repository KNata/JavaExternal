import DAO.BusDAO;
import Model.Bus;

import java.sql.SQLException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello World");

        BusDAO theBusDAO = new BusDAO();
        ArrayList<Bus> buses = theBusDAO.findAll();
        System.out.println(buses.size());


    }
}
