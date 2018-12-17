package ITCompany.MenuChooser;

import ITCompany.DAO.LaptopDAO;
import ITCompany.Entity.Laptop;

import java.sql.SQLException;

public class ShowAllListOfLaptops implements Command{

    private LaptopDAO laptopDAO;

    public ShowAllListOfLaptops (LaptopDAO aLaptopDAO) {
        laptopDAO = aLaptopDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        for (int i = 0; i < laptopDAO.findAll().size(); i++) {
            System.out.println(laptopDAO.findAll().get(i).toString());
        }

    }
}
