package ITCompany;


import ITCompany.DAO.LaptopDAO;
import ITCompany.DAO.PCDao;
import ITCompany.DAO.ProductDAO;
import ITCompany.MenuChooser.Command;
import ITCompany.MenuChooser.RemoteControl;
import ITCompany.MenuChooser.ShowAllLaptopManufacturesByCriteria;
import org.apache.log4j.Logger;


import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;


public class App {

    public static void main (String[] args) throws ClassNotFoundException, SQLException {


//        RemoteControl remoteControl = new RemoteControl();
        PCDao pc = new PCDao();
//        Command pc = new ShowAllLaptopManufacturesByCriteria(laptopDAO);
//        remoteControl.setCommand(pc);
//        remoteControl.chooseCommand();


        List allPC = pc.findAll();
        System.out.println(allPC.size());
        for (Object obj : allPC) {
            System.out.println(obj.toString());
        }

    }
}
