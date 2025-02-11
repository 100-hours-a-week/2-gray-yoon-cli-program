package cafe.menu.beverage;

public class Tea extends Beverage {
    public Tea(String name, int price, int shotCount) {
        super(name, price, shotCount);
    }

    @Override
    protected int calculateShotPrice() {
        return getShotCount() * SHOT_PRICE;
    }
}
