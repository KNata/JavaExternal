package ITCompany;


import ITCompany.DAO.LaptopDAO;
import ITCompany.Entity.Laptop;


import java.sql.SQLException;
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
