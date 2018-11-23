package ITCompany.DAO;

import ITCompany.Entity.Printer;

import java.util.List;

public class PrinterDAO extends AbstractDAO {


    @Override
    public List findAll() {
        String sql = "select * from Printer";
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

    public List<Printer> showAllColorPrintersByDesc() {
        String sql = "select * from Printer where color = 'y' order by price desc";
        return null;
    }

    public List<Printer> showAllPrintersByPriceLessThenSelected() {
        String sql = "select model, type, price from Printer where price < 300 order by type desc";
        return null;
    }
}
