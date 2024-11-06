public class Baloon extends Aircraft{
    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    void updateConditions() {
        String condition = this.wt.getWeather(this.coordinates);
        int height = this.coordinates.getHeight();
        int longitude = this.coordinates.getLongitude();
        System.out.printf("%s#%s<%d>(%s): ", this.getClass().getName(), this.name, this.id, condition);

        if(condition == "SUN") {
            this.coordinates.setLongitude(longitude + 2);
            this.coordinates.setHeight(height + 4);
            System.out.println("Let's enjoy the good weather and take some pics.");
        } else if (condition == "RAIN") {
            this.coordinates.setHeight(height - 5);
            System.out.println("I think that we need an umbrella");
        } else if (condition == "FOG") {
            System.out.println("We need to go down I can't see in this fog");
            this.coordinates.setHeight(height - 3);
        } else if(condition == "SNOW") {
            System.out.println("We must go down the baloon will be freezed");
            this.coordinates.setHeight(height - 15);
        }   
    }
}