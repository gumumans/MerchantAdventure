package events;

import entity.Seller;

public class WellBrokenEvent extends Event {

    public WellBrokenEvent() {
        super("��������� ������", false);
    }

    protected WellBrokenEvent(String name, boolean isLucky) {
        super(name, isLucky);
    }

    @Override
    public void doEvent(Seller seller) {
        seller.stop();
    }
}
