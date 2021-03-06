package ITCompany;


import ITCompany.DAO.LaptopDAO;
import ITCompany.DAO.PCDao;
import ITCompany.DAO.ProductDAO;
import ITCompany.Entity.Laptop;
import ITCompany.Entity.Product;
import ITCompany.MenuChooser.Command;
import ITCompany.MenuChooser.RemoteControl;
import ITCompany.MenuChooser.ShowAllLaptopManufacturesByCriteria;
import org.apache.log4j.Logger;


import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;


public class App {

    public static void main (String[] args) throws ClassNotFoundException, SQLException {

        LaptopDAO productDAO = new LaptopDAO();
        List<Laptop> allProducts = productDAO.findAll();
        System.out.println(allProducts.size());
        for (Laptop pr : allProducts) {
            System.out.println(pr.toString());
        }



    }
}
