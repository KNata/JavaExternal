package ITCompany.Servlets.Laptop_Command;

import ITCompany.DAO.ProductDAO;
import ITCompany.Servlets.Command;

import java.sql.SQLException;

public class ShowAllLaptopManufacturesByCriteria implements Command {

    private ProductDAO productDAO;

    public ShowAllLaptopManufacturesByCriteria (ProductDAO aProductDAO) {
        productDAO = aProductDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        if (productDAO.findLaptopMakersByMeketAsc().size() == 0) {
            System.out.println("Unfortunalely, Laptops by requested criteria are not avaliable in out IT Department");
        } else {
            for (int i = 0; i < productDAO.findLaptopMakersByMeketAsc().size(); i++) {
                System.out.println(productDAO.findLaptopMakersByMeketAsc().get(i).getMarker() + " "
                        + productDAO.findLaptopMakersByMeketAsc().get(i).getTypeOfModel());
            }
        }
    }
}
