public class AvajLauncher{

    public static void main(String args[]) {
        Coordinates coor = new Coordinates(10, 15, 20);
        AircraftFactory af =  AircraftFactory.getInstance();
        Flyable f = af.newAircraft("", "jetplane", coor);
        System.out.println(f.toString());
    }
}