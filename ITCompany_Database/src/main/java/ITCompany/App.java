package ITCompany;


import ITCompany.DAO.LaptopDAO;
import ITCompany.DAO.ProductDAO;
import ITCompany.MenuChooser.Command;
import ITCompany.MenuChooser.RemoteControl;
import ITCompany.MenuChooser.ShowAllLaptopManufacturesByCriteria;


import java.sql.SQLException;
import java.util.HashSet;


public class App {

    public static void main (String[] args) throws ClassNotFoundException, SQLException {

        RemoteControl remoteControl = new RemoteControl();
        LaptopDAO laptopDAO = new LaptopDAO();
        Command pc = new ShowAllLaptopManufacturesByCriteria(laptopDAO);
        remoteControl.setCommand(pc);
        remoteControl.chooseCommand();


//        HashSet allPC = pc.showAllPCManufacturersBySpeedMoreThen();
//        System.out.println(allPC.size());
//        for (Object obj : allPC) {
//            System.out.println(obj.toString());
//        }

    }
}
