package events;

import entity.Product;
import entity.Seller;

import static utilities.Rnd.rnd;

public class RainyDayEvent extends Event {
    public RainyDayEvent() {
        super("Дождь", false);
    }

    @Override
    public void doEvent(Seller seller) {
        System.out.println("\tCнижается скорость передвижения на 2 единицы");
        seller.changeSpeed(-2);
        if (rnd(10) <= 2) {
            System.out.println("Случайно испортился один из товаров");
            int rndNum = rnd(seller.getCart().size());
            Product pr = seller.getCart().get(rndNum);
            pr.decreaseQuality();
            seller.printCart();
        }
        seller.moveToCity();
    }
}
