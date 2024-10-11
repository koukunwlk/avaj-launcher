public abstract class Flyable {
    protected WeatherTower wt;

    abstract void updateConditions();

    void registerTower(WeatherTower wt) {
        this.wt = wt;
    }

}