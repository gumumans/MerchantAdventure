package events;

import entity.Seller;
import entity.product.Product;

import static utilities.Rnd.rnd;

public class FoundEateryEvent extends Event {

    public FoundEateryEvent() {
        super("����������� �������", true);
    }

    @Override
    public void doEvent(Seller seller) {
        double overnightMoney = rnd(8) + 8d;

        System.out.print("\t");
        if (rnd(100) > 50) {
            System.out.println("�������� ����� �� ���������� � ������� ���� ������");
            seller.moveToCity();
            return;
        }
        if (seller.getBalance() < overnightMoney) {
            System.out.println("� �������� ������������ �����, �� ���� ������");
            seller.moveToCity();
            return;
        }
        System.out.println("�������� ����� �������� � �������� ����� �� ������");
        System.out.println("-$" + overnightMoney);
        seller.takeMoney(overnightMoney);

        /// ����� ����� �������� ���� �� ����� � �������� � �������
        if (rnd(100) > 50) {
            System.out.println("�������� ����� ����������");
            int countGoods = rnd(4) + 1;
            for (int i = 0; i < countGoods; i++)
                seller.purchase(new Product());
        } else {
            System.out.println("�������� ����� ������� ����� ������");

            seller.getCart().stream()
                    .limit((rnd(3) + 1))
                    .toList()
                    .forEach(seller::selling);
        }
        seller.printCart();
        seller.moveToCity();
    }
}
