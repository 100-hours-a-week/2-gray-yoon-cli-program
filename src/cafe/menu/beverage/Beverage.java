package cafe.menu.beverage;

import cafe.menu.MenuItem;

public class Beverage extends MenuItem {
    public static final int SHOT_PRICE = 500;
    public static final int MAX_SHOT_COUNT = 5;
    private int shotCount;

    public Beverage(String name, int price, int shotCount) {
        super(name, price);
        this.shotCount = shotCount;
    }

    public void addShot(int count) {
        shotCount += count;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + shotCount * SHOT_PRICE;
    }

    @Override
    public String toString() {
        return super.toString() + " (샷: " + shotCount + ")";
    }
}
