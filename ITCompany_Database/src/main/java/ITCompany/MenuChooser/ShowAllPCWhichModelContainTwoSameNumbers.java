package ITCompany.MenuChooser;

import ITCompany.DAO.PCDao;

import java.sql.SQLException;

public class ShowAllPCWhichModelContainTwoSameNumbers implements Command {

    private PCDao pcDao;

    ShowAllPCWhichModelContainTwoSameNumbers(PCDao aPcDao) {
        pcDao = aPcDao;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        System.out.println(pcDao.showAllPCWhichModelContainTwoSameNumbers());
    }
}
