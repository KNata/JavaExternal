package ITCompany;

import ITCompany.DAO.PCDao;
import ITCompany.DAO.ProductDAO;
import ITCompany.Entity.PC;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main (String[] args) throws ClassNotFoundException, SQLException {
        PCDao pc = new PCDao();
        List<PC> allPC = pc.showAllPCManufacturersBySelectedHD();
        System.out.println(allPC.size());
        for (int i = 0; i < allPC.size(); i++) {
            System.out.println(allPC.get(i).toString());
        }


    }
}
