package ITCompany.MenuChooser;

import ITCompany.DAO.LaptopDAO;

import java.sql.SQLException;

public class ShowAllLaptopManufacturesByCriteria implements Command {

    private LaptopDAO laptopDAO;

    public ShowAllLaptopManufacturesByCriteria (LaptopDAO aLaptopDAO) {
        laptopDAO = aLaptopDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {

//        for (Laptop laptop : laptopDAO.showAllPCManufacturersBySpeedMoreThen()) {
//            System.out.println(laptop.toString());
//        }
    }
}
