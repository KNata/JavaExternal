package ITCompany.Servlets.PC_Command;

import ITCompany.DAO.PCDao;
import ITCompany.Servlets.Command;

import java.sql.SQLException;

public class ShowAllPCInPriceRange implements Command {

    private PCDao pcDao;

    public ShowAllPCInPriceRange(PCDao aPcDao) {
        pcDao = aPcDao;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        if (pcDao.allPCBySelectedSpeedInPriceRange().size() == 0) {
            System.out.println("Unfortunately, PCs by requested criteria are not avaliable in out IT Department");
        } else {
            for (int i = 0; i < pcDao.allPCBySelectedSpeedInPriceRange().size(); i++) {
                System.out.println(pcDao.allPCBySelectedSpeedInPriceRange().get(i).toString());
            }
        }
    }
}
