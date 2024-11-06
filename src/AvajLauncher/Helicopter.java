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
            try {
                this.coordinates.setLongitude(longitude + 10);
            } catch (Exception e) {}
            this.coordinates.setHeight(height + 2);
            System.out.println("Let's climb high as we can");
        } else if (condition == "RAIN") {
            try {
                this.coordinates.setLongitude(longitude + 5);
            } catch (Exception e) {}
            System.out.println("Take caution with ou rotor");
        } else if (condition == "FOG") {
            try {
                this.coordinates.setLongitude(longitude + 1);
            } catch (Exception e) {}
            System.out.println("Let's see this fog from above");
        } else if(condition == "SNOW") {
            this.coordinates.setHeight(height - 12);
            System.out.println("Winter is coming!");
        }
    }
}