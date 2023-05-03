package events;

import entity.Product;
import entity.Seller;

import java.util.List;
import java.util.stream.Collectors;

import static utilities.Rnd.rnd;

public class FoundEateryEvent extends Event {

    public FoundEateryEvent() {
        super("Придорожный трактир", true);
    }

    @Override
    public void doEvent(Seller seller) {
        double overnightMoney = rnd(8) + 8;
        if (rnd(100) > 50) {
            System.out.println("Торговец решил не оставаться и поэтому едет дальше");
            seller.moveToCity();
            return;
        }
        if (seller.getBalance() < overnightMoney) {
            System.out.println("У торговца недостаточно денег, он едет дальше");
            seller.moveToCity();
            return;
        }
        System.out.println("Торговец решил остаться и потратил денег на ночлег");
        System.out.println("-$" + overnightMoney);
        seller.takeMoney(overnightMoney);

        if (rnd(100) > 50) {
            System.out.println("Торговец решил закупиться");
            for (int i = 0; i < (rnd(4) + 1); i++)
                seller.purchase(new Product());
        } else {
            System.out.println("Торговец решил продать часть товара");

            seller.getCart().stream()
                    .limit((rnd(3) + 1))
                    .forEach(seller::selling);
        }
        seller.moveToCity();
    }
}
