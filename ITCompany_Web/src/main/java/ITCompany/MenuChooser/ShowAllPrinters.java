package ITCompany.MenuChooser;

import ITCompany.DAO.PrinterDAO;

import java.sql.SQLException;

public class ShowAllPrinters implements Command {

    private PrinterDAO printerDAO;

    public ShowAllPrinters (PrinterDAO aPrinterDao) {
        printerDAO = aPrinterDao;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        for (int i = 0; i < printerDAO.findAll().size(); i++) {
            System.out.println(printerDAO.findAll().get(i).toString());
        }

    }
}
