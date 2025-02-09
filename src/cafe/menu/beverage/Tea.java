package cafe.menu.beverage;

public class Tea extends Beverage {
    public Tea(String name, int price, int shotCount) {
        super(name, price, shotCount);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + getShotCount() * SHOT_PRICE;
    }
}
