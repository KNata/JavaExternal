package ITCompany;

import ITCompany.DAO.LaptopDAO;
import ITCompany.DAO.PCDao;
import ITCompany.DAO.PrinterDAO;
import ITCompany.DAO.ProductDAO;
import ITCompany.MenuChooser.*;

import java.sql.SQLException;
import java.util.Scanner;

public class App2 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        RemoteControl remoteControl = new RemoteControl();
        ProductDAO productDAO = new ProductDAO();
        LaptopDAO laptopDAO = new LaptopDAO();
        PCDao pcDao = new PCDao();
        PrinterDAO printerDAO = new PrinterDAO();

        Command allObjectsExeptPrinters = new ShowAllProductsExeptPrinters(productDAO);
        Command showAllLaptopManufactures = new ShowAllLaptopManufacturesByCriteria(productDAO);
        Command showAllPCInPriceRange = new ShowAllPCInPriceRange(pcDao);
        Command showAllPCBySppedAndPrice = new ShowAllPCBySpeedAndPrice(pcDao);
        Command showAllPCWithTwoSameNumbers = new ShowAllPCWhichModelContainTwoSameNumbers(pcDao);
        Command showAllColorPrinters = new ShowColorPrinters(printerDAO);
        Command showPrintersByNeededPrice = new ShowPrintersByNeededPrice(printerDAO);
        Command showAllLaptops = new ShowAllListOfLaptops(laptopDAO);
        Command showAllPC = new ShowAllPC(pcDao);
        Command showAllPrinters = new ShowAllPrinters(printerDAO);
        Command showAllProducts = new ShowAllProducts(productDAO);

        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("Choose the preffered cathegory: ");
            System.out.println("To see avaliable information in Laptop category, press 1");
            System.out.println("To see avaliable information in PC category, press 2");
            System.out.println("To see avaliable information in Printer category, press 3");
            System.out.println("To see avaliable information in Printer category, press 4");
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Thank you for visiting our IT Company. \nHave a nice day!");
                break;
            } else if (choice > 4) {
                System.out.println("Wrong input. Try again");
            } else {
                if (choice == 1) { // Laptops
                    remoteControl.setCommand(showAllLaptops);
                    System.out.println("List of avaliable laptops");
                    remoteControl.chooseCommand();
                    System.out.println();
                    remoteControl.setCommand(showAllLaptopManufactures);
                    System.out.println("List of Avaliable Laptop manufacturers with speed > 600");
                    remoteControl.chooseCommand();
                    System.out.println();
                } else if (choice == 2) { // PC
                    remoteControl.setCommand(showAllPC);
                    System.out.println("List of avaliable PC");
                    remoteControl.chooseCommand();
                    System.out.println();
                    remoteControl.setCommand(showAllPCBySppedAndPrice);
                    System.out.println("Avaliable PC with speed > 550 and price < 800");
                    remoteControl.chooseCommand();
                    System.out.println();
                    remoteControl.setCommand(showAllPCInPriceRange);
                    System.out.println("Avaliable PC in price range $400-600");
                    remoteControl.chooseCommand();
                    System.out.println();
                    remoteControl.setCommand(showAllPCWithTwoSameNumbers);
                    System.out.println("Avaliable PC which model contains '11'");
                    remoteControl.chooseCommand();
                    System.out.println();
                } else if (choice == 3) { // Pinters
                    remoteControl.setCommand(showAllPrinters);
                    System.out.println("List of avaliable Printers");
                    remoteControl.chooseCommand();
                    System.out.println();
                    remoteControl.setCommand(showAllColorPrinters);
                    System.out.println("List of avaliable color Printers");
                    remoteControl.chooseCommand();
                    System.out.println();
                    remoteControl.setCommand(showPrintersByNeededPrice);
                    System.out.println("List of avaliable Printers by price less then $300");
                    remoteControl.chooseCommand();
                    System.out.println();
                } else if (choice == 4) { // Products
                    remoteControl.setCommand(showAllProducts);
                    System.out.println("List of avaliable Poducts");
                    remoteControl.chooseCommand();
                    System.out.println();
                    remoteControl.setCommand(allObjectsExeptPrinters);
                    System.out.println("List of all Poducts exept Printers");
                    remoteControl.chooseCommand();
                    System.out.println();
                }
            }
        }
    }
}
