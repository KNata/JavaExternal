package AbctractVechicle;

import java.util.ArrayList;
public class App 
{
    public static void main( String[] args )
    {
        CCar bmv = new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar pegeoue = new CCar(0, 165555.5555, 20000000, 100, 2018);
        CCar porshe= new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar mersedes = new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar lanos = new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar tesla = new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar audi = new CCar(43.5, 33.33, 10000000, 90, 1999);
        CCar infinity = new CCar(14.5, 33.33, 10000000, 90, 1999);
        CCar hundai = new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar suzuki = new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar seat = new CCar(4.3335, 33.33, 10000000, 90, 1999);
        CCar honda = new CCar(4.5, 33.33, 10000000, 90, 1999);
        CCar nissan = new CCar(4.5, 33.33, 10000000, 90, 1999);

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

        CShip auroraShip = new CShip(21.5, 33,90000, 43,1880,543,"Edinburg");
        CShip maiaShip = new CShip(21.5, 33,90000, 43,1880,543,"Tallin");
        CShip albatrossShip = new CShip(21.5, 33,90000, 43,1880,543,"Iurmalla");
        CShip mirageShip = new CShip(21.5, 33,90000, 43,1880,543,"Odessa");
        CShip otakiShip = new CShip(21.5, 33,90000, 43,1880,543,"Nikolaiev");
        CShip poseidonShip = new CShip(21.5, 33,90000, 43,1880,543,"KHerson");
        CShip blackPerlineShip = new CShip(21.5, 33,90000, 43,1880,543,"Ostende");
        CShip pandaShip = new CShip(21.5, 33,90000, 43,1880,543,"Tallin");
        CShip nikoShip = new CShip(21.5, 33,90000, 43,1880,543,"Odessa");
        CShip revellShip = new CShip(21.5, 33,90000, 43,1880,543,"Ialta");
        CShip wavelineShip = new CShip(21.5, 33,90000, 43,1880,543,"Edinburg");
        CShip sanvaShip = new CShip(21.5, 33,90000, 43,1880,543,"Edinburg");

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

        CPlane wizzair = new CPlane(33.2, 9000.9, 50000000,789.9,2018, 200,800);
        CPlane ryinail = new CPlane(33.2, 9000.9, 50000000,789.9,2018, 200,800);
        CPlane turkishAirlines = new CPlane(33.2, 9000.9, 50000000,789.9,2018, 200,800);
        CPlane britishAirlines = new CPlane(33.2, 9000.9, 50000000,789.9,2018, 200,800);
        CPlane lot = new CPlane(33.2, 9000.9, 50000000,789.9,2018, 200,800);
        CPlane austrianAirlines = new CPlane(33.2, 9000.9, 50000000,789.9,2018, 200,800);

        ArrayList<CPlane> plainesList = new ArrayList<CPlane>();
        plainesList.add(wizzair);
        plainesList.add(ryinail);
        plainesList.add(turkishAirlines);
        plainesList.add(britishAirlines);
        plainesList.add(lot);
        plainesList.add(austrianAirlines);
    }
}
