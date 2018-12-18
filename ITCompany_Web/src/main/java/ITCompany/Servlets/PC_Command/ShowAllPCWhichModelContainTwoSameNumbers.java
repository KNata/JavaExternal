package ITCompany.Servlets.PC_Command;

import ITCompany.DAO.PCDao;
import ITCompany.Servlets.Command;

import java.sql.SQLException;

public class ShowAllPCWhichModelContainTwoSameNumbers implements Command {

    private PCDao pcDao;

    public ShowAllPCWhichModelContainTwoSameNumbers(PCDao aPcDao) {
        pcDao = aPcDao;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        if (pcDao.showAllPCWhichModelContainTwoSameNumbers().size() == 0) {
            System.out.println("Unfortunately, PCs by requested criteria are not avaliable in out IT Department");
        } else {
            for (int i = 0; i < pcDao.showAllPCWhichModelContainTwoSameNumbers().size(); i++) {
                System.out.println(pcDao.showAllPCWhichModelContainTwoSameNumbers().get(i).toString());
            }
        }
    }
}
