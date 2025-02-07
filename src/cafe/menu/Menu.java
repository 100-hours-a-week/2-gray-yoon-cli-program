package cafe.menu;

import cafe.menu.bakery.Bakery;
import cafe.menu.baverage.Beverage;
import cafe.menu.baverage.Coffee;
import util.InputHandler;

import java.util.List;

public class Menu {
    public static final int MAX_ORDER_COUNT = 10;
    public static final List<Beverage> beverageMenu = List.of(
            new Coffee("에스프레소", 3200, 1),
            new Coffee("아메리카노", 3900, 1),
            new Coffee("카푸치노", 4500, 1),
            new Coffee("라떼", 5200, 1),
            new Beverage("그린티", 2600, 0),
            new Beverage("얼그레이", 3200, 0),
            new Beverage("허브티", 3600, 0),
            new Beverage("아이스티", 3000, 0)
    );
    public static final List<Bakery> bakeryMenu = List.of(
            new Bakery("초콜릿 칩 쿠키", 1900),
            new Bakery("오트밀 쿠키", 2300),
            new Bakery("피넛버터 쿠키", 2600),
            new Bakery("더블 초콜릿 쿠키", 2800),
            new Bakery("크루아상", 3900),
            new Bakery("베이글", 3200)
    );

    public void displayBakeryMenus() {
        System.out.println("--------------------------");
        System.out.println("        베이커리 메뉴         ");
        System.out.println("--------------------------");
        for (int i = 1; i < bakeryMenu.size() + 1; i++) {
            MenuItem menuItem = bakeryMenu.get(i - 1);
            System.out.println(i + ". " + menuItem.toString());
        }
    }

    public void displayBeverageMenus() {
        System.out.println("--------------------------");
        System.out.println("         음료 메뉴          ");
        System.out.println("--------------------------");
        for (int i = 1; i < beverageMenu.size() + 1; i++) {
            MenuItem menuItem = beverageMenu.get(i - 1);
            System.out.println(i + ". " + menuItem.toString());
        }
    }

    public int selectCategory() {
        System.out.println("카테고리를 선택해주세요");
        System.out.println("--------------------------");
        System.out.println("1. 음료");
        System.out.println("2. 베이커리");
        System.out.println("3. 종료 (선택 시 더이상 주문할 수 없습니다.)");
        System.out.println("--------------------------");

        return InputHandler.getIntInputInRange("번호를 입력해주세요: ", 1, 3);
    }

    public MenuItem selectMenu(int category) {
        if (category == 1) {
            displayBeverageMenus();
        } else if (category == 2) {
            displayBakeryMenus();
        }

        int menuChoice;
        int maxChoice = (category == 1) ? beverageMenu.size() : bakeryMenu.size();
        menuChoice = InputHandler.getIntInputInRange("\n메뉴를 선택해주세요 (1 ~ " + maxChoice + "번 중 선택): ", 1, maxChoice);

        MenuItem selected =  (category == 1) ? beverageMenu.get(menuChoice - 1) : bakeryMenu.get(menuChoice - 1);

        if (category == 1) {
            System.out.println("\n샷을 추가하시겠습니까?");
            System.out.println("1. 네, 2. 아니요");
            int choice = InputHandler.getIntInputInRange("번호를 입력해주세요: ", 1, 2);

            if (choice == 2) {
                return selected;
            }

            int extraShots = InputHandler.getIntInputInRange("\n개수를 입력해주세요.(추가 요금 1샷 - " + Beverage.SHOT_PRICE + "원, 최대 " + Beverage.MAX_SHOT_COUNT +"개): ", 0, Beverage.MAX_SHOT_COUNT);
            System.out.println("샷 " + extraShots + "개(+" + (Beverage.SHOT_PRICE * extraShots) + "원)가 추가되었습니다.\n");

            ((Beverage) selected).addShot(extraShots);
        }

        return selected;
    }

    public int getQuantity(MenuItem menu) {
        return InputHandler.getIntInputInRange(menu.getName() + "의 개수를 입력해주세요(최소 1개, 최대 " + MAX_ORDER_COUNT + "개): ", 1, MAX_ORDER_COUNT);
    }
}
