package cafe.menu;

import cafe.menu.beverage.Beverage;
import util.InputHandler;

import java.util.List;

public class Menu {
    public static final int MAX_ORDER_COUNT = 10;

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
        List<MenuItem> menuList = MenuList.getCategoryMenuList(category);

        int maxChoice = menuList.size();
        int menuChoice = InputHandler.getIntInputInRange("\n메뉴를 선택해주세요 (1 ~ " + maxChoice + "번 중 선택): ", 1, maxChoice);

        return  menuList.get(menuChoice - 1);
    }

    public void selectShotOption(Beverage menu) {
        boolean isAddShot = askShotOption();

        if (!isAddShot) {
            return;
        }

        addShot(menu);
    }

    private boolean askShotOption() {
        System.out.println("\n샷을 추가하시겠습니까?");
        System.out.println("1. 네, 2. 아니요");
        int choice = InputHandler.getIntInputInRange("번호를 입력해주세요: ", 1, 2);

        return choice == 1;
    }

    private void addShot(MenuItem menu) {
        int extraShots = InputHandler.getIntInputInRange("\n개수를 입력해주세요.(추가 요금 1샷 - " + Beverage.SHOT_PRICE + "원, 최대 " + Beverage.MAX_SHOT_COUNT +"개): ", 0, Beverage.MAX_SHOT_COUNT);
        System.out.println("샷 " + extraShots + "개(+" + (Beverage.SHOT_PRICE * extraShots) + "원)가 추가되었습니다.\n");

        ((Beverage) menu).addShot(extraShots);
    }

    public int getQuantity(MenuItem menu) {
        return InputHandler.getIntInputInRange(menu.getName() + "의 개수를 입력해주세요(최소 1개, 최대 " + MAX_ORDER_COUNT + "개): ", 1, MAX_ORDER_COUNT);
    }
}
