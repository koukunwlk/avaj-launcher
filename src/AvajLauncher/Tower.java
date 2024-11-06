import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if(flyable == null) {
            System.out.println("Tower: Ghost aircraft, please contact ghost tower");
            return ;
        }
        Aircraft aircraft = (Aircraft)flyable;
        System.out.printf("Tower: %s#%s<%d> registered to weather tower\n", aircraft.getClass().getName(), aircraft.getName(), aircraft.getId());
        aircraft.registerTower((WeatherTower)this);
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        Aircraft aircraft = (Aircraft)flyable;
        System.out.printf("Tower: %s#%s<%d> unregistered to weather tower\n", aircraft.getClass().getName(), aircraft.getName(), aircraft.getId());
        this.observers.remove(flyable);
    }

    protected void conditionsChanged() {
        Iterator<Flyable> it = observers.iterator();
        while(it.hasNext()) {
            it.next().updateConditions();
        }
    }
}