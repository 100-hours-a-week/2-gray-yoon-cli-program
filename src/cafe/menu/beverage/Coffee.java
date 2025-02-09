package cafe.menu.beverage;

public class Coffee extends Beverage {
    public Coffee(String name, int price, int shotCount) {
        super(name, price, shotCount);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + (getShotCount() - 1) * SHOT_PRICE;
    }
}
