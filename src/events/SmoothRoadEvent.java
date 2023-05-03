package events;

import entity.Seller;

public class SmoothRoadEvent extends Event {
    public SmoothRoadEvent() {
        super("Ровная дорога", true);
    }

    @Override
    public void doEvent(Seller seller) {
        System.out.println("\tТорговцу попалась ровная дорога и ему хорошо, скорость передвижения увеличилась на 2");
        seller.changeSpeed(2);
        seller.moveToCity();
    }
}
