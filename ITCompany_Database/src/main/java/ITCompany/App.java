package ITCompany;

import ITCompany.DAO.PCDao;
import ITCompany.DAO.PrinterDAO;
import ITCompany.DAO.ProductDAO;
import ITCompany.Entity.PC;
import ITCompany.Entity.Printer;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main (String[] args) throws ClassNotFoundException, SQLException {
        PrinterDAO pc = new PrinterDAO();
        List<Printer> allPC = pc.showAllPrintersByPriceLessThenSelected();
        System.out.println(allPC.size());
        for (int i = 0; i < allPC.size(); i++) {
            System.out.println(allPC.get(i).toString());
        }


    }
}
