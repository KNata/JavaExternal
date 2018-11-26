package ITCompany;


import ITCompany.DAO.LaptopDAO;
import ITCompany.DAO.ProductDAO;


import java.sql.SQLException;
import java.util.HashSet;


public class App {

    public static void main (String[] args) throws ClassNotFoundException, SQLException {
        LaptopDAO pc = new LaptopDAO();
        HashSet allPC = pc.showAllPCManufacturersBySpeedMoreThen();
        System.out.println(allPC.size());
        for (Object obj : allPC) {
            System.out.println(obj.toString());
        }

    }
}
