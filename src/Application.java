import entity.City;
import entity.Product;
import entity.Seller;
import events.*;

import java.util.List;

import static utilities.Rnd.rnd;

public class Application implements Runnable {
    private final Seller seller;
    private final City city;

    public Application() {
        this.city = new City();
        this.seller = new Seller(city.getDistance());
    }

    @Override
    public void run() {
        System.out.println(city);
        purchaseOfGoods();
        System.out.println(seller);
        int day = 0;
        try {
            while (true) {
                System.out.printf("Шёл %dдень%n", day);
                seller.changeSpeed(rnd(5) + 1);
                Event event = getEvent();
                System.out.println(event);
                event.doEvent(seller);
                System.out.println(seller);

                if (seller.getCart().isEmpty())
                    throw new SellerException("Торговец так и не доехал на " + day + " день своего путешествия. Так как у него нет товара в телеги. И он грустный остался в пути");

                day++;
            }
        } catch (SellerException e){
            System.out.println(e.getMessage());
        }

    }

    private void purchaseOfGoods() {
        System.out.println("Произошла закупка товаров");
        while (true) {
            Product pr = new Product();
            if (seller.getBalance() >= pr.getPurchasePrice() && seller.getLoadCapacity() >= (seller.getCartCapacity() + pr.getWeight())) {
                seller.purchase(pr);
            } else break;
        }
    }

    private Event getEvent() {
        List<Event> events = List.of(
                new FoundEateryEvent(),
                new MetLocalEvent(),
                new NormalDayEvent(),
                new RainyDayEvent(),
                new RiverEvent(),
                new RobbersEvent(),
                new SmoothRoadEvent(),
                new SpoiledEvent(),
                new WellBrokenEvent()
        );
        return events.get(rnd(events.size()));
    }
}
