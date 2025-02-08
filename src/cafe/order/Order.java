package cafe.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orders = new ArrayList<>();

    public void addItem(OrderItem item) {
        orders.add(item);
        System.out.println(item.toString() + "가(이) 추가되었습니다.\n");
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem item : orders) {
            totalPrice += item.getTotalPrice();
        }

        return totalPrice;
    }

    public void displayOrders() {
        if (getOrdersCount() == 0) {
            return;
        }

        System.out.println("--------------------------");
        System.out.println("          주문 확인         ");
        for (int i = 1; i < orders.size() + 1; i++) {
            OrderItem orderItem = orders.get(i - 1);
            System.out.println(i + ". " + orderItem.toString());
        }
        System.out.println("--------------------------");
        System.out.println("총 합계: " + getTotalPrice() + "원");
        System.out.println("--------------------------");
    }

    public int getOrdersCount() {
        return orders.size();
    }
}
