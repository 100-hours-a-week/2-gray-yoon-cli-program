package cafe;

import cafe.menu.Menu;
import cafe.menu.MenuItem;
import cafe.menu.MenuList;
import cafe.menu.beverage.Beverage;
import cafe.order.Order;
import cafe.order.OrderItem;
import cafe.order.Payment;

public class Cafe {
    private final Menu menu = new Menu();
    private final Order orders = new Order();

    public void open() {
        System.out.println("|   OO카페에 오신것을 환영합니다  |");
        System.out.println("|   ☕️ 메뉴를 확인해주세요 🥐   |");

        MenuList.displayBeverageMenus();
        MenuList.displayBakeryMenus();
    }

    public void order() {
        while (true) {
            // 카테고리(음료/베이커리/종료) 선택받기
            int category = menu.selectCategory();

            if (category == 3) {
                System.out.println("주문을 종료합니다!\n");
                break;
            }

            // 선택 카테고리에 대한 메뉴 보여주기
            MenuList.displayCategoryMenuList(category);

            // 메뉴 선택
            MenuItem selected = menu.selectMenu(category);

            // 샷 추가
            if (selected instanceof Beverage selectedBeverage) {
                menu.selectShotOption(selectedBeverage);
            }

            int count = menu.getQuantity(selected);

            orders.addItem(new OrderItem(count, selected));
        }
    }

    public void checkOrder() {
        orders.displayOrders();
    }

    public void calculatePayment() {
        if (orders.getOrdersCount() == 0) {
            return;
        }

        Payment payment = new Payment(orders.getTotalPrice());
        int amount =  payment.pay();
        payment.calculateChange(amount);
    }

    public void close() {
        System.out.println("감사합니다. 즐거운 하루 되세요 🍀");
    }
}
