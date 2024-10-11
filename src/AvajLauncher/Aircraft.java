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
    void updateConditions() {}

    @Override
    public String toString() {
        return "id: " + this.id + " name: " + this.name + " coordinates: " + this.coordinates.toString();
    }
}