public class JetPlane extends Aircraft {
    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    void updateConditions() {
        String condition = this.wt.getWeather(this.coordinates);
        if(condition == "SNOW") {
            int aircraftHeight = this.coordinates.getHeight();
            this.coordinates.setHeight(aircraftHeight - 7);
        }
    }

}