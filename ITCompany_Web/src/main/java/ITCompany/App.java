package ITCompany;


import ITCompany.DAO.GuestsDAO;
import ITCompany.DAO.LaptopDAO;
import ITCompany.DAO.PCDao;
import ITCompany.DAO.ProductDAO;
import ITCompany.Entity.Guest;
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

        GuestsDAO productDAO = new GuestsDAO();
        boolean allProducts = productDAO.addUser(new Guest(4, "khomyachok", "1111", "Somebody", "jfhgdj", "user"));
//        for (Guest pr : allProducts) {
//            System.out.println(pr.toString());
//        }
            System.out.println(allProducts);

        List<Guest> allGuests = productDAO.findAll();
        for (Guest pr : allGuests) {
            System.out.println(pr.toString());
        }

    }
}
