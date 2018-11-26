package ITCompany.MenuChooser;

import ITCompany.DAO.PrinterDAO;

public class ShowPrintersByNeededPrice implements Command {

    private PrinterDAO printerDAO;

    ShowPrintersByNeededPrice(PrinterDAO aPrinterDAO) {
        printerDAO = aPrinterDAO;
    }

    @Override
    public void execute() throws ClassNotFoundException {
        System.out.println(printerDAO.showAllPrintersByPriceLessThenSelected());
    }
}
