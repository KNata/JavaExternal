package AbctractVechicle;

import java.util.ArrayList;
public class App 
{
    public static void main( String[] args )
    {
        CCar bmv = new CCar(4.5, 33.33, 44, 90, 1999);
        CCar pegeoue = new CCar(0, 165555.5555, 444444, 100, 2018);
        CCar porshe= new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar mersedes = new CCar(4.5, 33.33, 57877, 90, 2018);
        CCar lanos = new CCar(4.5, 33.33, 10000000, 90, 2000);
        CCar tesla = new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar audi = new CCar(43.5, 33.33, 10000000, 90, 3908);
        CCar infinity = new CCar(14.5, 33.33, 10000000, 90, 1999);
        CCar hundai = new CCar(4.5, 33.33, 10000000, 90, 2019);
        CCar suzuki = new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar seat = new CCar(4.3335, 33.33, 7873254, 90, 1999);
        CCar honda = new CCar(4.5, 33.33, 89346557, 90, 1999);
        CCar nissan = new CCar(4.5, 33.33, 10000000, 90, 900);

        ArrayList<CCar> carsList = new ArrayList<CCar>();
        carsList.add(bmv);
        carsList.add(pegeoue);
        carsList.add(porshe);
        carsList.add(mersedes);
        carsList.add(lanos);
        carsList.add(tesla);
        carsList.add(audi);
        carsList.add(infinity);
        carsList.add(hundai);
        carsList.add(suzuki);
        carsList.add(seat);
        carsList.add(honda);
        carsList.add(nissan);

        CShip auroraShip = new CShip(21.5, 33,66666, 43,1999,543,"Edinburg");
        CShip maiaShip = new CShip(100.9, 33,444444, 43,1997,543,"Tallin");
        CShip albatrossShip = new CShip(21.5, 33,90000, 43,1880,4563,"Iurmalla");
        CShip mirageShip = new CShip(21.5, 33,65784, 43,2018,543,"Odessa");
        CShip otakiShip = new CShip(6785.4, 33,90000, 43,1880,1000,"Nikolaiev");
        CShip poseidonShip = new CShip(6745.0, 9000,90000, 43,1993,543,"KHerson");
        CShip blackPerlineShip = new CShip(21.5, 33,90000, 43,1880,543,"Ostende");
        CShip pandaShip = new CShip(647.0, 800,90000, 43,1880,543,"Tallin");
        CShip nikoShip = new CShip(21.5, 33,90000, 43,1864,66,"Odessa");
        CShip revellShip = new CShip(21.5, 33,543, 43,2018,543,"Ialta");
        CShip wavelineShip = new CShip(4353.9, 366669,324432, 43,1880,543,"Edinburg");
        CShip sanvaShip = new CShip(21.5, 33,975, 43,1880,44,"Edinburg");

        ArrayList<CShip> shipsList = new ArrayList<CShip>();
        shipsList.add(auroraShip);
        shipsList.add(maiaShip);
        shipsList.add(albatrossShip);
        shipsList.add(mirageShip);
        shipsList.add(otakiShip);
        shipsList.add(poseidonShip);
        shipsList.add(blackPerlineShip);
        shipsList.add(pandaShip);
        shipsList.add(nikoShip);
        shipsList.add(revellShip);
        shipsList.add(wavelineShip);
        shipsList.add(sanvaShip);

        CPlane wizzair = new CPlane(1000.4, 9000.9, 32432,789.9,2018, 200,800);
        CPlane ryinail = new CPlane(33.2, 9000.9, 90000,789.9,2018, 200,800);
        CPlane turkishAirlines = new CPlane(33.2, 900.9, 50000000,789.9,2018, 200,800);
        CPlane britishAirlines = new CPlane(123.2, 9000.9, 43555,789.9,2018, 200,800);
        CPlane lot = new CPlane(33.2, 9000.9, 50000000,789.9,2018, 200,800);
        CPlane austrianAirlines = new CPlane(543, 10000, 23456,789.9,2018, 200,800);

        ArrayList<CPlane> plainesList = new ArrayList<CPlane>();
        plainesList.add(wizzair);
        plainesList.add(ryinail);
        plainesList.add(turkishAirlines);
        plainesList.add(britishAirlines);
        plainesList.add(lot);
        plainesList.add(austrianAirlines);
    }
}
