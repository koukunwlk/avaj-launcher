public class AircraftFactory {
    private static AircraftFactory instance;
    private static long lastId = 0;
    private AircraftFactory(){}

    public Flyable newAircraft(String type, String name, Coordinates coordinate) {
        Flyable newFlyable = null; 
        long id = AircraftFactory.lastId++;
        switch (type) {
            case "JetPlane":
                newFlyable = new JetPlane(id, name, coordinate);
                break;
            case "Baloon":
                newFlyable = new Baloon(id, name, coordinate);
                break;
            case "Helicoper":
                newFlyable = new Helicopter(id, name, coordinate);
                break;
            default:
                break;
        }
        return newFlyable;
    }

    public static AircraftFactory getInstance() {
        if(instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }
}