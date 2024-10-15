public class Helicopter extends Aircraft{
    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    void updateConditions() {
        String condition = this.wt.getWeather(this.coordinates);
        int height = this.coordinates.getHeight();
        int longitude = this.coordinates.getLongitude();

        if(condition == "SUN") {
            this.coordinates.setLongitude(longitude + 10);
            this.coordinates.setHeight(height + 2);
        } else if (condition == "RAIN") {
            this.coordinates.setLongitude(longitude + 5);
        } else if (condition == "FOG") {
            this.coordinates.setLongitude(longitude + 1);
        } else if(condition == "SNOW") {
            this.coordinates.setHeight(height - 12);
        }
    }
}