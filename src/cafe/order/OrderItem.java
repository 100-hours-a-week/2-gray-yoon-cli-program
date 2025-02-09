package cafe.order;

import cafe.menu.MenuItem;

public class OrderItem {
    private int count;
    private MenuItem item;

    public OrderItem(int count, MenuItem item) {
        this.count = count;
        this.item = item;
    }

    public int getTotalPrice() {
        return count * item.getPrice();
    }

    @Override
    public String toString() {
        return item.toString() + " - " + count + "개, 합계: " + getTotalPrice() + "원";
    }
}
