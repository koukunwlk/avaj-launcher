import java.util.List;

public class Tower {
    private List<Flyable> observers;

    void register(Flyable flyable) {
        this.observers.add(flyable);
    }

    void unregister(Flyable flyable) {
        this.observers.remove(flyable);
    }

    protected void conditionsChanged() {
        
    }
}