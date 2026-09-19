package lesson_1;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders;

    public OrderHistory() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    @Override
    public String toString() {
        if (orders.isEmpty()) {
            return "Історія замовлень порожня.";
        }
        StringBuilder sb = new StringBuilder("=== Історія замовлень ===\n");
        for (int i = 0; i < orders.size(); i++) {
            sb.append("№").append(i + 1).append(" | ");
            sb.append(orders.get(i).toString()).append("\n");
            sb.append("-------------------------\n");
        }
        return sb.toString();
    }
}
