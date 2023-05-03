package events;

import entity.Product;
import entity.Seller;
import qualityProducts.Qualities;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static utilities.Rnd.rnd;

public class RobbersEvent extends Event {

    public RobbersEvent() {
        super("Разбойники большой дороги", false);
    }

    @Override
    public void doEvent(Seller seller) {
        double robbersCoin = rnd(6) + 5;

        if (rnd(100) > 50 && seller.getBalance() > robbersCoin) {
            seller.takeMoney(robbersCoin);
            System.out.printf("Торговца ограбили на %s монет%n", robbersCoin);
        } else {
            seller.getCart().sort(Comparator.comparingDouble(p -> p.getQuality().getRatio()));

            List<Product> robbersProducts = seller.getCart().stream()
                    .limit((rnd(3) + 1))
                    .collect(Collectors.toList());
            System.out.println("Торговца ограбили на такие товары: ");
            robbersProducts.forEach(System.out::println);

            seller.getCart().removeAll(robbersProducts);
            seller.calculateCapacityCart();
        }
        seller.moveToCity();
    }
}
