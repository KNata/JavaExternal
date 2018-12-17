package ITCompany.MenuChooser;

import ITCompany.DAO.PCDao;

import java.sql.SQLException;
import java.util.List;

public class ShowAllPCBySpeedAndPrice implements Command {

    private PCDao pcDAO;

    public ShowAllPCBySpeedAndPrice(PCDao aPcDAO) {
        pcDAO = aPcDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        if (pcDAO.allPCBySelectedSpeedAndPrice().size() == 0) {
            System.out.println("Unfortunately, PCs by requested criteria are not avaliable in out IT Department");
        } else {
            for (int i = 0; i < pcDAO.allPCBySelectedSpeedAndPrice().size(); i++) {
                System.out.println(pcDAO.allPCBySelectedSpeedAndPrice().get(i).toString());
            }
        }
    }
}
