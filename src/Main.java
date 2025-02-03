import cafe.Cafe;

public class Main {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        // 인사
        cafe.open();

        // 주문 받기
        if (!cafe.order()) {
            cafe.close();
            return;
        }

        // 주문 종료 후 주문 확인
        cafe.checkOrder();

        // 계산 (지불 및 거스름돈)
        cafe.calculatePayment();

        // 인사
        cafe.close();
    }
}