package events;

import entity.Product;
import entity.Seller;

import static utilities.Rnd.rnd;

public class SpoiledEvent extends Event {
    public SpoiledEvent() {
        super("Товар испортился", false);
    }

    @Override
    public void doEvent(Seller seller) {
        System.out.println("Случайно испортился один из товаров. Это печально. :`(");
        int rndNum = rnd(seller.getCart().size());
        Product pr = seller.getCart().get(rndNum);
        pr.decreaseQuality();
        seller.moveToCity();
    }
}
