package cafe.order;

import util.InputHandler;

public class Payment {
    private int price;

    public Payment(int price) {
        this.price = price;
    }

    public int pay() {
        int amount;
        amount = InputHandler.getPositiveIntInput("지불할 금액을 입력해주세요(원): ");

        while (amount < price) {
            System.out.println("구매 금액보다 지불 금액이 적습니다.("+ price + "원)");
            amount = InputHandler.getPositiveIntInput("지불할 금액을 다시 입력해주세요(원): ");
        }

        return amount;
    }

    public void calculateChange(int amount) {
        System.out.println(amount + "원 받았습니다.");

        if (amount > price) {
            System.out.println("거스름돈 " + (amount - price) + "원입니다.");
        }
    }
}
