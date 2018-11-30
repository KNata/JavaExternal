package ITCompany.MenuChooser;

import ITCompany.DAO.PrinterDAO;
import ITCompany.Entity.Printer;

import java.sql.SQLException;

public class ShowPrintersByNeededPrice implements Command {

    private PrinterDAO printerDAO;

    public ShowPrintersByNeededPrice(PrinterDAO aPrinterDAO) {
        printerDAO = aPrinterDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException, SQLException {
        if (printerDAO.showAllColorPrintersByDesc().size() == 0) {
            System.out.println("Unfortunately, our IT Company has only black and white printers");
        } else {
            for (int i = 0; i < printerDAO.showAllColorPrintersByDesc().size(); i++) {
                System.out.println("Model: " + printerDAO.showAllColorPrintersByDesc().get(i).getModel() + " type: "
                        + printerDAO.showAllColorPrintersByDesc().get(i).getType() + " price: " + printerDAO.showAllColorPrintersByDesc().get(i).getPrice());
            }
        }
    }
}
