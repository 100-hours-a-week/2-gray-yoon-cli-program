package cafe.menu;

import cafe.menu.bakery.Bakery;
import cafe.menu.beverage.Beverage;
import cafe.menu.beverage.Coffee;

import java.util.List;

public abstract class MenuList {
    public static final List<MenuItem> beverageMenu = List.of(
            new Coffee("에스프레소", 3200, 1),
            new Coffee("아메리카노", 3900, 1),
            new Coffee("카푸치노", 4500, 1),
            new Coffee("라떼", 5200, 1),
            new Beverage("그린티", 2600, 0),
            new Beverage("얼그레이", 3200, 0),
            new Beverage("허브티", 3600, 0),
            new Beverage("아이스티", 3000, 0)
    );

    public static final List<MenuItem> bakeryMenu = List.of(
            new Bakery("초콜릿 칩 쿠키", 1900),
            new Bakery("오트밀 쿠키", 2300),
            new Bakery("피넛버터 쿠키", 2600),
            new Bakery("더블 초콜릿 쿠키", 2800),
            new Bakery("크루아상", 3900),
            new Bakery("베이글", 3200)
    );

    public static void displayBakeryMenus() {
        System.out.println("--------------------------");
        System.out.println("        베이커리 메뉴         ");
        System.out.println("--------------------------");
        for (int i = 1; i < MenuList.bakeryMenu.size() + 1; i++) {
            MenuItem menuItem = MenuList.bakeryMenu.get(i - 1);
            System.out.println(i + ". " + menuItem.toString());
        }
    }

    public static void displayBeverageMenus() {
        System.out.println("--------------------------");
        System.out.println("         음료 메뉴          ");
        System.out.println("--------------------------");
        for (int i = 1; i < MenuList.beverageMenu.size() + 1; i++) {
            MenuItem menuItem = MenuList.beverageMenu.get(i - 1);
            System.out.println(i + ". " + menuItem.toString());
        }
    }
}
