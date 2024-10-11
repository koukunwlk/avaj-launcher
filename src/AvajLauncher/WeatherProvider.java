public class WeatherProvider {
    private static WeatherProvider instance;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
        
    }

    public String getCurrentWeather(Coordinates coor) {
        return this.weather[0];
    }

    public static WeatherProvider getInstance() {
        if(instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }
}