

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 250.75),
            new Order(102, "Bob", 89.99),
            new Order(103, "Charlie", 430.00),
            new Order(104, "Diana", 15.50),
            new Order(105, "Ethan", 320.20)
        };

        Order[] bubbleOrders = orders.clone();
        Order[] quickOrders = orders.clone();

        BubbleSort.sort(bubbleOrders);
        QuickSort.sort(quickOrders, 0, quickOrders.length - 1);

        System.out.println("Bubble Sort Result:");
        for (Order o : bubbleOrders) System.out.println(o);

        System.out.println("\nQuick Sort Result:");
        for (Order o : quickOrders) System.out.println(o);
    }

    static class Order {
        int id;
        String name;
        double amount;

        Order(int id, String name, double amount) {
            this.id = id;
            this.name = name;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
        }
    }

    static class BubbleSort {
        static void sort(Order[] orders) {
            int n = orders.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (orders[j].amount > orders[j + 1].amount) {
                        Order temp = orders[j];
                        orders[j] = orders[j + 1];
                        orders[j + 1] = temp;
                    }
                }
            }
        }
    }

    static class QuickSort {
        static void sort(Order[] orders, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(orders, low, high);
                sort(orders, low, pivotIndex - 1);
                sort(orders, pivotIndex + 1, high);
            }
        }

        private static int partition(Order[] orders, int low, int high) {
            double pivot = orders[high].amount;
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (orders[j].amount <= pivot) {
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
    }
}
