package ITCompany.DAO;


import ITCompany.Entity.PC;

import java.util.List;

public class PCDao extends AbstractDAO {


    @Override
    public List findAll() {
        String sql = "select * from PC";
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

    public List<PC> allPCBySelectedSpeedAndPrice() {
        String sql = "select * from PC where speed > 550 and price < 800 order by price ASC";
        return null;
    }

    public List<PC> allPCBySelectedSpeedInPriceRange() {
        String sql = " select model, speed from PC where speed BETWEEN 400 and 600 order by hd des";
        return null;
    }

    public List<PC> showAllPCWhichModelContainTwoSameNumbers() {
        String sql = "select * from PC where model like '%11%'";
        return null;
    }

    public List<PC> showAllPCManufacturersBySelectedHD() {
        String sql = "select marker, type, speed, hd from PC where hd > 8";
        return null;
    }

    public List<PC> showAllPCManufacturersBySelectedSpeed() {
        String sql = "select pr.maker from Product pr inner join Laptop lapt where lapt.speed <= 500";
        return null;
    }

}
