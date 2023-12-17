package events;

import entity.Product;
import entity.Seller;

import java.util.ArrayList;
import java.util.List;

import static utilities.Rnd.rnd;

public class FoundEateryEvent extends Event {

    public FoundEateryEvent() {
        super("Придорожный трактир", true);
    }

    @Override
    public void doEvent(Seller seller) {
        double overnightMoney = rnd(8) + 8d;
        System.out.print("\t");
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

        /// Здесь нужна проверка есть ли место у торговца в повозке
        if (rnd(100) > 50) {
            System.out.println("Торговец решил закупиться");
            for (int i = 0; i < (rnd(4) + 1); i++)
                seller.purchase(new Product());
        } else {
            System.out.println("Торговец решил продать часть товара");

            List<Product> products = new ArrayList<>();
            long limit = (rnd(3) + 1);

            for (Product product1 : seller.getCart()) {
                if (limit-- == 0) break;
                products.add(product1);
            }

            for (Product product : products) {
                seller.selling(product);
            }
        }
        seller.printCart();
        seller.moveToCity();
    }
}
