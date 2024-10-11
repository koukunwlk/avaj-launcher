public class WeatherTower {
    public String getWeather(Coordinates coordinates) {
        WeatherProvider wp = WeatherProvider.getInstance();
        String currentWeather = wp.getCurrentWeather(coordinates);
        return currentWeather;
    }
}