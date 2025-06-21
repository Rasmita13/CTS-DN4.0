class Order {
    String id, customerName;
    double totalPrice;

    public Order(String id, String customerName, double totalPrice) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
}

public class Sorting {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1 - i; j++)
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("O101", "Alice", 120.5),
            new Order("O102", "Bob", 89.99),
            new Order("O103", "Charlie", 250.0)
        };
        System.out.println("--- Bubble Sort Result ---");
        bubbleSort(orders);
        for (Order o : orders) {
            System.out.println(o.id + " | " + o.customerName + " | " + o.totalPrice);
        }

        Order[] quickOrders = {
            new Order("O101", "Alice", 120.5),
            new Order("O102", "Bob", 89.99),
            new Order("O103", "Charlie", 250.0)
        };
        quickSort(quickOrders, 0, quickOrders.length - 1);
        System.out.println("--- Quick Sort Result ---");
        for (Order o : quickOrders) {
            System.out.println(o.id + " | " + o.customerName + " | " + o.totalPrice);
        }
    }
}
