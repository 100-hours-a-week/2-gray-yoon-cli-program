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

    public boolean order() {
        // 주문한 메뉴가 있는지 확인하기 위한 값
        boolean result = false;

        while (true) {
            // 카테고리(음료/베이커리/종료) 선택받기
            int category = menu.selectCategory();

            if (category == 3) {
                System.out.println("주문을 종료합니다!\n");
                break;
            }

            result = true;

            // 선택 카테고리에 대한 메뉴 보여주기
            menu.displayCategoryMenuList(category);

            // 메뉴 선택
            MenuItem selected = menu.selectMenu(category);

            // 샷 추가
            if (selected instanceof Beverage selectedBeverage) {
                menu.selectShotOption(selectedBeverage);
            }

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
