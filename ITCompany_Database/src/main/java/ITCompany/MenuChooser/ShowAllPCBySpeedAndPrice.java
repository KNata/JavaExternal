package ITCompany.MenuChooser;

import ITCompany.DAO.PCDao;

import java.sql.SQLException;
import java.util.List;

public class ShowAllPCBySpeedAndPrice implements Command {

    private PCDao pcDAO;

    ShowAllPCBySpeedAndPrice(PCDao aPcDAO) {
        pcDAO = aPcDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        System.out.println(pcDAO.allPCBySelectedSpeedAndPrice());
    }
}
