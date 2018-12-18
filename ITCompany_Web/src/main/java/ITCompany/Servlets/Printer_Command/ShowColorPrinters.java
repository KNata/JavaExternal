package ITCompany.Servlets.Printer_Command;

import ITCompany.DAO.PrinterDAO;
import ITCompany.Entity.Printer;
import ITCompany.Servlets.Command;

import java.sql.SQLException;

public class ShowColorPrinters implements Command {

    private PrinterDAO printerDAO;

    public ShowColorPrinters(PrinterDAO aPrinterDAO) {
        printerDAO = aPrinterDAO;
    }


    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        if (printerDAO.showAllColorPrintersByDesc().size() == 0) {
            System.out.println("Unfortunately, our IT Company has only black and white printers");
        } else {
            for (Printer printer : printerDAO.showAllColorPrintersByDesc()) {
                System.out.println(printerDAO.showAllColorPrintersByDesc().toString());
            }
        }
    }
}
