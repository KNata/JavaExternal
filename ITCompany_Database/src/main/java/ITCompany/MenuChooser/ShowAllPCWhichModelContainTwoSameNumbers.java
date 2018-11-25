package ITCompany.MenuChooser;

import ITCompany.DAO.PCDao;

public class ShowAllPCWhichModelContainTwoSameNumbers implements Command {

    private PCDao pcDao;

    ShowAllPCWhichModelContainTwoSameNumbers(PCDao aPcDao) {
        pcDao = aPcDao;
    }

    @Override
    public void execute() throws ClassNotFoundException {
        System.out.println(pcDao.showAllPCWhichModelContainTwoSameNumbers());
    }
}
