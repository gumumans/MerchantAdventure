package events;

import entity.Product;
import entity.Seller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static utilities.Rnd.rnd;

public class RobbersEvent extends Event {

    public RobbersEvent() {
        super("Разбойники большой дороги", false);
    }

    @Override
    public void doEvent(Seller seller) {
        double robbersCoin = rnd(6) + 5D;

        if (rnd(100) > 50 && seller.getBalance() > robbersCoin) {
            seller.takeMoney(robbersCoin);
            System.out.printf("Торговца ограбили на %s монет%n", robbersCoin);
        } else {
            seller.getCart().sort(Comparator.comparingDouble(p -> p.getQuality().getRatio()));

            List<Product> robbersProducts = new ArrayList<>();
            long limit = (rnd(3) + 1);
            for (Product product : seller.getCart()) {
                if (limit-- == 0) break;
                robbersProducts.add(product);
            }

            System.out.println("Торговца ограбили на такие товары: ");
            robbersProducts.forEach(System.out::println);

            seller.getCart().removeAll(robbersProducts);
            seller.calculateCapacityCart();
            seller.printCart();
        }
        seller.moveToCity();
    }
}
