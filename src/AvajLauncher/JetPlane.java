public class JetPlane extends Aircraft {
    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    void updateConditions() {
        String condition = this.wt.getWeather(this.coordinates);
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();
        System.out.printf("%s#%s<%d>(%s): ", this.getClass().getName(), this.name, this.id, condition);

        if(condition == "SUN") {
            this.coordinates.setLatitude(latitude + 10);
            this.coordinates.setHeight(height + 2);
            System.out.println("Let's enjoy the good weather and take some pics.");
        } else if (condition == "RAIN") {
            this.coordinates.setLatitude(latitude + 5);
            System.out.println("It's raining. Better watch out for lightings.");
        } else if (condition == "FOG") {
            this.coordinates.setLatitude(latitude + 1);
            System.out.println("I can't see nothing in this fog, let's change to ifr");
        } else if(condition == "SNOW") {
            System.out.println("Actvating anti-ice protections");
            this.coordinates.setHeight(height - 7);
        }

        if(this.coordinates.getHeight() == 0) {
            System.out.printf("%s#%s<%d>: ", this.getClass().getName(), this.name, this.id);
            System.out.println("Landing");
            this.wt.unregister(this);
        }
    }

}