public class WeatherTower extends Tower {
    public String lastWeather;
    public WeatherProvider wp = WeatherProvider.getInstance();;
    public String getWeather(Coordinates coordinates) {
        this.lastWeather = this.wp.getCurrentWeather(coordinates);
        return this.lastWeather;
    }

    public void changeWeather() {
        super.conditionsChanged();
    }

}