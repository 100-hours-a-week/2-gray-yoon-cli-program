package cafe.menu;


import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    public static final List<MenuItem> beverageMenu = List.of(
            new MenuItem("에스프레소", 3200),
            new MenuItem("아메리카노", 3900),
            new MenuItem("카푸치노", 4500),
            new MenuItem("라떼", 5200),
            new MenuItem("그린티", 2600),
            new MenuItem("얼그레이", 3200),
            new MenuItem("허브티", 3600)
    );
    public static final List<MenuItem> bakeryMenu = List.of(
            new MenuItem("초콜릿 칩 쿠키", 1900),
            new MenuItem("오트밀 쿠키", 2300),
            new MenuItem("피넛버터 쿠키", 2600),
            new MenuItem("더블 초콜릿 쿠키", 2800),
            new MenuItem("크루아상", 3900),
            new MenuItem("베이글", 3200)
    );

    public void displayBakeryMenus() {
        System.out.println("--------------------------");
        System.out.println("        베이커리 메뉴         ");
        System.out.println("--------------------------");
        for (int i = 1; i < bakeryMenu.size() + 1; i++) {
            MenuItem menuItem = bakeryMenu.get(i - 1);
            System.out.println(i + ". " + menuItem.toString());
        }
        System.out.println("--------------------------\n");
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
        int category;
        System.out.println("카테고리를 선택해주세요");
        System.out.println("--------------------------");
        System.out.println("1. 음료");
        System.out.println("2. 베이커리");
        System.out.println("3. 종료(선택 시 더이상 주문할 수 없습니다.)");
        System.out.println("--------------------------");
        System.out.print("번호를 입력해주세요: ");
        category = scanner.nextInt();

        return category;
    }

    public MenuItem selectMenu(int category) {
        if (category == 1) {
            displayBeverageMenus();
        } else if (category == 2) {
            displayBakeryMenus();
        }

        int menuChoice;
        System.out.print("메뉴를 선택해주세요 (1 ~ " + ((category == 1) ? beverageMenu.size() : bakeryMenu.size()) + "번 중 선택): ");
        menuChoice = scanner.nextInt();

        return (category == 1) ? beverageMenu.get(menuChoice - 1) : bakeryMenu.get(menuChoice - 1);
    }

    public int getQuantity(MenuItem menu) {
        int quantity = 0;
        System.out.print(menu.getName() + "의 개수를 입력해주세요: ");
        quantity = scanner.nextInt();

        return quantity;
    }
}
