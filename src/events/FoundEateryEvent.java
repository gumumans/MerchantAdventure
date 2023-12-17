package events;

import entity.Product;
import entity.Seller;

import java.util.ArrayList;
import java.util.List;

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
            for (int i = 0; i < (rnd(4) + 1); i++)
                seller.purchase(new Product());
        } else {
            System.out.println("�������� ����� ������� ����� ������");

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
