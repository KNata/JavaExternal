package ITCompany.Servlets.Product_Command;

import ITCompany.DAO.ProductDAO;
import ITCompany.Servlets.Command;

import java.sql.SQLException;

public class ShowAllProductsExeptPrinters implements Command {

    private ProductDAO productDAO;

    public ShowAllProductsExeptPrinters(ProductDAO aProductDAO) {
        productDAO = aProductDAO;
    }


    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        if (productDAO.showAllProductsExeptPrinters().size() == 0) {
            System.out.println("Unfortunately, our IT Company has only Printers");
        } else {
            for (Object obj : productDAO.showAllProductsExeptPrinters()) {
                System.out.println(obj.toString());
            }
        }
    }
}
