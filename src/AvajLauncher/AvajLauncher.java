public class AvajLauncher{

    public static void main(String args[]) {
        Coordinates coor = new Coordinates(65, 63, 20);
        Coordinates coor2 = new Coordinates(35, 35, 20);
        WeatherTower wt = new WeatherTower();
        AircraftFactory af =  AircraftFactory.getInstance();
        Flyable f = af.newAircraft("JetPlane", "j1", coor);
        Flyable f2 = af.newAircraft("Baloon", "b1", coor2);
        wt.register(f);
        wt.register(f2);
        f.registerTower(wt);
        f2.registerTower(wt);
        wt.conditionsChanged();
        wt.conditionsChanged();
        wt.conditionsChanged();
    }
}