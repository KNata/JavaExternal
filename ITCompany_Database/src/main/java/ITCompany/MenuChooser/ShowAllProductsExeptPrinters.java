package ITCompany.MenuChooser;

import ITCompany.DAO.ProductDAO;

import java.sql.SQLException;

public class ShowAllProductsExeptPrinters implements Command {

    private ProductDAO productDAO;

    ShowAllProductsExeptPrinters(ProductDAO aProductDAO) {
        productDAO = aProductDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        for(Object obj : productDAO.showAllProductsExeptPrinters()) {
            System.out.println(obj.toString());
        }
    }
}
