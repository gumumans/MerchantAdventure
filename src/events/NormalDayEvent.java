package events;

import entity.Seller;

public class NormalDayEvent extends Event{

    public NormalDayEvent() {
        super("������� ����", true);
    }

    @Override
    public void doEvent(Seller seller) {
        System.out.println("������ �� ���������");
    }
}
