package events;

import entity.Seller;

import static utilities.Rnd.rnd;

public class MetLocalEvent extends Event {
    public MetLocalEvent() {
        super("Встретил местного", true);
    }

    @Override
    public void doEvent(Seller seller) {
        int shortCutDistance = rnd(4) + 3;
        System.out.printf("\tУдалось срезать часть пути (в этот день проехали больше на %d лиг)%n",shortCutDistance);
        seller.moveToCity(shortCutDistance);
    }
}
