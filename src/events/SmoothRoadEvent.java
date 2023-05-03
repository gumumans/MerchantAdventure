package events;

import entity.Seller;

public class SmoothRoadEvent extends Event {
    public SmoothRoadEvent() {
        super("������ ������", true);
    }

    @Override
    public void doEvent(Seller seller) {
        System.out.println("\t�������� �������� ������ ������ � ��� ������, �������� ������������ ����������� �� 2");
        seller.changeSpeed(2);
        seller.moveToCity();
    }
}
