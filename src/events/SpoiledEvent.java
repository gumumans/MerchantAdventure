package events;

import entity.Seller;
import entity.product.Product;

import static utilities.Rnd.rnd;

public class SpoiledEvent extends Event {
    public SpoiledEvent() {
        super("����� ����������", false);
    }

    @Override
    public void doEvent(Seller seller) {
        System.out.println("�������� ���������� ���� �� �������. ��� ��������. :`(");
        int rndNum = rnd(seller.getCart().size());
        Product pr = seller.getCart().get(rndNum);
        pr.decreaseQuality();
        seller.printCart();
        seller.moveToCity();
    }
}
