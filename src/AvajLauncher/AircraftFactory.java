public class AircraftFactory {
    private static AircraftFactory instance;

    private AircraftFactory(){}

    public Flyable newAircraft(String type, String name, Coordinates coordinates) {
        long id = (long)Math.random();
        Flyable newFlyable; 
        newFlyable = new JetPlane(id, name, coordinates);
        return newFlyable;
    }

    public static AircraftFactory getInstance() {
        if(instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }
}