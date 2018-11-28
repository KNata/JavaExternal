package ITCompany.MenuChooser;

import ITCompany.DAO.PrinterDAO;

import java.sql.SQLException;

public class ShowColorPrinters implements Command {

    private PrinterDAO printerDAO;

    ShowColorPrinters(PrinterDAO aPrinterDAO) {
        printerDAO = aPrinterDAO;
    }


    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        System.out.println(printerDAO.showAllColorPrintersByDesc());
    }
}
