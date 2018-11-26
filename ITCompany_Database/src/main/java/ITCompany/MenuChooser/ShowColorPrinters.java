package ITCompany.MenuChooser;

import ITCompany.DAO.PrinterDAO;

public class ShowColorPrinters implements Command {

    private PrinterDAO printerDAO;

    ShowColorPrinters(PrinterDAO aPrinterDAO) {
        printerDAO = aPrinterDAO;
    }


    @Override
    public void execute() throws ClassNotFoundException {
        System.out.println(printerDAO.showAllColorPrintersByDesc());
    }
}
