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

        Laptop theLaptop = new Laptop(11,"00000",400,90,2,333,19000, 1);
        LaptopDAO theDAO = new LaptopDAO();
        theDAO.addLaptop(theLaptop);
        List<Laptop> laptopList = theDAO.findAll();
        for(Laptop l: laptopList){
            System.out.println(l.toString());
        }
//        theDAO.updateCountOfLaptops(theLaptop);
//        System.out.println("");

    }
}
