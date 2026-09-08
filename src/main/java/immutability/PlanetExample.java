package immutability;

import java.util.Date;

public class PlanetExample {
    static void main(String[] args) {
        Planet p = new Planet(900.6, "MyPlanet", new Date());
        Date date = p.getDateOfDiscovery();
        date.setTime(6000);
        System.out.println(date);
        System.out.println(p.getDateOfDiscovery());


        System.out.println();
        PlanetRecord planetRecord = new PlanetRecord(900.6, "MyPlanet", new Date());
        Date date1 = planetRecord.fDateOfDiscovery();
        System.out.println(date1);
        date1.setTime(6000); // the date will be changed
        // Records provide only shallow immunity
        System.out.println(planetRecord.fDateOfDiscovery());



    }
}
