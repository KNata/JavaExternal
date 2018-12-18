package ITCompany.Servlets.PC_Command;

import ITCompany.DAO.PCDao;
import ITCompany.Servlets.Command;

import java.sql.SQLException;

public class ShowAllPC implements Command {

    private PCDao pcDao;

    public ShowAllPC (PCDao aPcDao) {
        pcDao = aPcDao;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        for (int i = 0; i < pcDao.findAll().size(); i++) {
            System.out.println(pcDao.findAll().get(i).toString());
        }

    }
}
