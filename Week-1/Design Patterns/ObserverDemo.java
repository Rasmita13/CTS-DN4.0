import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class NewsAgency {
    private List<Observer> observers = new ArrayList<>();

    public void register(Observer o) {
        observers.add(o);
    }

    public void notifyAllObservers(String news) {
        for (Observer o : observers) {
            o.update(news);
        }
    }
}

class UserObserver implements Observer {
    private String name;

    public UserObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }
}

class ObserverDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        agency.register(new UserObserver("Alice"));
        agency.register(new UserObserver("Bob"));
        agency.notifyAllObservers("Design Patterns are awesome!");
    }
}
