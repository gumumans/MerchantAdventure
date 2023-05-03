package events;

import entity.Seller;

public class NormalDayEvent extends Event{

    public NormalDayEvent() {
        super("Обычный день", true);
    }

    @Override
    public void doEvent(Seller seller) {
        System.out.println("Ничего не произошло");
    }
}
