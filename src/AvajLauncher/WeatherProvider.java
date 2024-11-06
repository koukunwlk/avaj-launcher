import java.util.ArrayList;
import java.util.Arrays;

public class WeatherProvider {
    private static WeatherProvider instance;
    private ArrayList<String> weather = new ArrayList<String>();

    private WeatherProvider() {
        weather.addAll(Arrays.asList("SNOW", "SUN", "RAIN", "FOG"));
    }

    public String getCurrentWeather(Coordinates coor) {
        if(coor.getLatitude() > 50) {
            String[] polarWeather = {"SNOW", "SUN", "RAIN"};
            double[] probabilities = {0.8, 0.1, 0.4};
            return randomizeWeather(polarWeather, probabilities);
        } else if(coor.getLatitude() > 30) {
            String[] temperateWeater = {"SNOW", "SUN", "RAIN", "FOG"};
            double[] probabilities = {0.2, 0.3, 0.3, 0.3};
            return randomizeWeather(temperateWeater, probabilities);
        } else {
            String[] tropicalWeather = {"SNOW", "SUN", "RAIN", "FOG"};
            double[] probabilities = {0.1, 0.7, 0.2, 0.1};
            return randomizeWeather(tropicalWeather, probabilities);
        }
    }

    private String randomizeWeather(String[] locationWeathers, double[] probabilities) {
        double sum = 0;
        
        for(double probability : probabilities) {
            sum += probability;
        }

        double rand = Math.random() * sum;

        for(int i = 0; i < probabilities.length; i++) {
            if(rand < probabilities[i]) {
                return locationWeathers[i];
            } 
            else {
                rand -= probabilities[i];
            }
        }
        return locationWeathers[0];
    }

   

    public static WeatherProvider getInstance() {
        if(instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }
}