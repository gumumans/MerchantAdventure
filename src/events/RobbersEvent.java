package events;

import entity.Seller;
import entity.product.Product;

import java.util.Comparator;
import java.util.List;

import static utilities.Rnd.rnd;

public class RobbersEvent extends Event {

    public RobbersEvent() {
        super("���������� ������� ������", false);
    }

    @Override
    public void doEvent(Seller seller) {
        double robbersCoin = rnd(6) + 5D;
        if ((rnd(100) > 50) && seller.getBalance() > robbersCoin) {
            seller.takeMoney(robbersCoin);
            System.out.printf("�������� �������� �� %s �����%n", robbersCoin);
        } else {
            seller.getCart().sort(Comparator.comparingDouble(p -> p.getQuality().getRatio()));

            List<Product> robbersProducts = seller.getCart().stream()
                    .limit((rnd(3) + 1))
                    .toList();

            System.out.println("�������� �������� �� ����� ������: ");
            robbersProducts.forEach(System.out::println);

            seller.getCart().removeAll(robbersProducts);
            seller.calculateCapacityCart();
            seller.printCart();
        }
        seller.moveToCity();
    }
}
