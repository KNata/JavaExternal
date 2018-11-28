package ITCompany.MenuChooser;

import ITCompany.DAO.PrinterDAO;

import java.sql.SQLException;

public class ShowPrintersByNeededPrice implements Command {

    private PrinterDAO printerDAO;

    ShowPrintersByNeededPrice(PrinterDAO aPrinterDAO) {
        printerDAO = aPrinterDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        System.out.println(printerDAO.showAllPrintersByPriceLessThenSelected());
    }
}
