package ITCompany.Servlets.Printer_Command;

import ITCompany.DAO.PrinterDAO;
import ITCompany.Servlets.Command;

import java.sql.SQLException;

public class ShowPrintersByNeededPrice implements Command {

    private PrinterDAO printerDAO;

    public ShowPrintersByNeededPrice(PrinterDAO aPrinterDAO) {
        printerDAO = aPrinterDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        if (printerDAO.showAllColorPrintersByDesc().size() == 0) {
            System.out.println("Unfortunately, our IT Company doesn't own a printers in selected price range");
        } else {
            for (int i = 0; i < printerDAO.showAllColorPrintersByDesc().size(); i++) {
                System.out.println("Model: " + printerDAO.showAllColorPrintersByDesc().get(i).getModel() + " type: "
                        + printerDAO.showAllColorPrintersByDesc().get(i).getType() + " price: " + printerDAO.showAllColorPrintersByDesc().get(i).getPrice());
            }
        }
    }
}
