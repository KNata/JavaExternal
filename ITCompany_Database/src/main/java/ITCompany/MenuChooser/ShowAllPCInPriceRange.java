package ITCompany.MenuChooser;

import ITCompany.DAO.PCDao;

import java.sql.SQLException;
import java.util.List;

public class ShowAllPCInPriceRange implements Command {

    private PCDao pcDao;

    ShowAllPCInPriceRange(PCDao aPcDao) {
        pcDao = aPcDao;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        System.out.println(pcDao.allPCBySelectedSpeedInPriceRange());
    }
}
