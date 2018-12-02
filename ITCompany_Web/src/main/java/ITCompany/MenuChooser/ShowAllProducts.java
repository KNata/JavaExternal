package ITCompany.MenuChooser;

import ITCompany.DAO.ProductDAO;

import java.sql.SQLException;

public class ShowAllProducts implements Command {

    private ProductDAO productDAO;

    public ShowAllProducts (ProductDAO aProductDao) {
        productDAO = aProductDao;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        for (int i = 0; i < productDAO.findAll().size(); i++) {
            System.out.println(productDAO.findAll().get(i).toString());
        }

    }
}
