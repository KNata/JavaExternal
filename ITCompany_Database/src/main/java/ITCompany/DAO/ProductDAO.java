package ITCompany.DAO;

import ITCompany.Entity.Product;

import java.util.List;

public class ProductDAO extends AbstractDAO {
    @Override
    public List findAll() {
        String sql = "select * from Product";
        return null;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }

    public List<Product> showAllProductsExeptPrinters() {
        String sql = "select pr.maker, pr.model, pr.type, lapt.price, pc.price from Product pr, Laptop lapt, PC pc where not pr.type = 'Printer'";
        return null;
    }



}
