package ITCompany;


import ITCompany.DAO.LaptopDAO;
import ITCompany.DAO.PCDao;
import ITCompany.DAO.ProductDAO;
import ITCompany.Entity.Laptop;
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

/*
        List allPC = pc.findAll();
        System.out.println(allPC.size());
        for (Object obj : allPC) {
            System.out.println(obj.toString());
        }

        System.out.println();
        System.out.println("allPCBySelectedSpeedAndPrice");
        List allPCSelected = pc.allPCBySelectedSpeedAndPrice();
        System.out.println(allPCSelected.size());
        for (Object obj : allPCSelected) {
            System.out.println(obj.toString());
        }

        System.out.println();
        System.out.println("allPCBySelectedSpeedInPriceRange");
        List ddd = pc.allPCBySelectedSpeedInPriceRange();
        System.out.println(ddd.size());
        for (Object obj : ddd) {
            System.out.println(obj.toString());
        }

        System.out.println();
        System.out.println("showAllPCWhichModelContainTwoSameNumbers");
        List vvv = pc.showAllPCWhichModelContainTwoSameNumbers();
        System.out.println(vvv.size());
        for (Object obj : vvv) {
            System.out.println(obj.toString());
        }

        System.out.println();
        System.out.println("showAllPCManufacturersBySelectedSpeed");
        List www = pc.showAllPCManufacturersBySelectedSpeed();
        System.out.println(www.size());
        for (Object obj : www) {
            System.out.println(obj.toString());
        }


    boolean status = laptopDAO.isTheLaptopExist(3);
    System.out.println(status);
        Laptop laptop = new Laptop(3,"1750",750,128,12,1200,14);
        boolean l = laptopDAO.create(laptop);
        System.out.println(l);

        System.out.println(laptop.getUnicCode());
*/
        LaptopDAO laptopDAO = new LaptopDAO();
/*
        boolean q = laptopDAO.create(laptop2);
        System.out.println("If exist " + laptopDAO.isTheLaptopExist(laptop2.getUnicCode()));
        System.out.println("Laptop 2 " + q);



        Laptop laptop2 = new Laptop(4,"1111",750,128,12,3,14);

//        boolean isAdded = laptopDAO.create(laptop2);
//        System.out.println(isAdded);
        List<Laptop> laptList = laptopDAO.findAll();
        for (Laptop l : laptList) {
            System.out.println(l.toString());
        }

        HashSet lall = laptopDAO.showAllPCManufacturersBySpeedMoreThen();
        System.out.println(lall.size());
        for (Object l : lall) {
            System.out.println(l.toString());
        } */

        System.out.println("allPCBySelectedSpeedAndPrice");
        List vvv = pc.allPCBySelectedSpeedAndPrice();
        System.out.println(vvv.size());
        for (Object obj : vvv) {
            System.out.println(obj.toString());
        }
    }
}
