package events;

import entity.Seller;

public class WellBrokenEvent extends Event {

    public WellBrokenEvent() {
        super("��������� ������", false);
    }

    @Override
    public void doEvent(Seller seller) {
        seller.stop();
    }
}
