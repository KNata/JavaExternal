package ITCompany.MenuChooser;

import ITCompany.DAO.LaptopDAO;

public class ShowAllLaptopManufacturesByCriteria implements Command {

    private LaptopDAO laptopDAO;

    ShowAllLaptopManufacturesByCriteria (LaptopDAO aLaptopDAO) {
        laptopDAO = aLaptopDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException {
        for (Object obj : laptopDAO.showAllPCManufacturersBySpeedMoreThen()) {
            System.out.println(obj.toString());
        }
    }
}
