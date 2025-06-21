import java.util.*;

// Subject Interface
interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

// Observer Interface
interface Observer {
    void update(String stockName, double price);
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public void setStockData(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers();
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}

// Concrete Observer: MobileApp
class MobileApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("[MobileApp] " + stockName + " is now $" + price);
    }
}

// Concrete Observer: WebApp
class WebApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("[WebApp] " + stockName + " is now $" + price);
    }
}

// Test Class
public class OP {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        System.out.println("== Updating stock price for AAPL ==");
        stockMarket.setStockData("AAPL", 150.25);

        System.out.println("\n== Deregistering MobileApp ==");
        stockMarket.deregister(mobileApp);

        System.out.println("\n== Updating stock price for GOOG ==");
        stockMarket.setStockData("GOOG", 2725.50);
    }
}

