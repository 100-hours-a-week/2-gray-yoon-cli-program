package cafe;

import cafe.menu.Menu;
import cafe.menu.MenuItem;
import cafe.order.Order;
import cafe.order.OrderItem;
import cafe.order.Payment;

public class Cafe {
    private Menu menu = new Menu();
    private Order orders = new Order();

    public void open() {
        System.out.println("|   OO카페에 오신것을 환영합니다  |");
        System.out.println("|   ☕️ 메뉴를 확인해주세요 🥐   |\n");

        menu.displayBeverageMenus();
        menu.displayBakeryMenus();
    }

    public boolean order() {
        boolean result = false;

        while (true) {
            int category = menu.selectCategory();

            if (category == 3) {
                System.out.println("주문을 종료합니다!\n");
                break;
            }

            result = true;
            MenuItem selected = menu.selectMenu(category);
            int count = menu.getQuantity(selected);

            orders.addItem(new OrderItem(count, selected));
        }

        return result;
    }

    public void checkOrder() {
        orders.displayOrders();
    }

    public void calculatePayment() {
        Payment payment = new Payment(orders.getTotalPrice());
        int amount =  payment.pay();
        payment.calculateChange(amount);
    }

    public void close() {
        System.out.println("감사합니다. 즐거운 하루 되세요 🍀");
    }
}
