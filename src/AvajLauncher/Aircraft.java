public class Aircraft extends Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    void updateConditions() {
        
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }


    @Override
    public String toString() {
        return "id: " + this.id + " name: " + this.name + " coordinates: " + this.coordinates.toString();
    }

    public class InvalidAircraftType extends Exception {
        public InvalidAircraftType(String type) {
            super("Invalid plane type: " + type);
        }
    }



    public class InvalidAircraftLineConfig extends Exception {
        public InvalidAircraftLineConfig(String line) {
            super("there are some missing infos in the line: " + line);
        }
    }
}