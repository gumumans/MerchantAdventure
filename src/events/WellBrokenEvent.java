package events;

import entity.Seller;

public class WellBrokenEvent extends Event {

    public WellBrokenEvent() {
        super("Сломалось колесо", false);
    }

    @Override
    public void doEvent(Seller seller) {
        seller.stop();
    }
}
