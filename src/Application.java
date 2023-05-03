import entity.City;
import entity.Product;
import entity.Seller;
import events.*;
import exception.SellerException;

import java.util.List;

import static utilities.Colors.*;
import static utilities.Rnd.rnd;

public class Application implements Runnable {
    private final Seller seller;
    private final City city;
    private double totalPurchase;

    public Application() {
        this.city = new City();
        this.seller = new Seller(city.getDistance());
    }

    @Override
    public void run() {
        System.out.println(city);
        purchaseOfGoods();
        totalPurchase = seller.getCart().stream().mapToDouble(Product::getPurchasePrice).sum();
        System.out.println(seller);
        int day = 0;
        try {
            do {
                System.out.println("=".repeat(108));
                System.out.printf("%sШёл %d день%s%n", CYAN, day, RST);
                seller.changeSpeed(rnd(5) + 1);
                Event event = getEvent();
                System.out.println(event);
                event.doEvent(seller);
                System.out.println(seller);

                if (seller.getCart().isEmpty())
                    throw new SellerException("Торговец так и не доехал на " + day + " день своего путешествия. Так как у него нет товара в телеги. И он грустный остался в пути");
                day++;
            } while (seller.getDistanceToCity() > 0);
        } catch (SellerException e) {
            System.out.printf("%s%s%s%n", RED_BOLD, e.getMessage(), RST);
        }
        System.out.println(YELLOW + "Торговец прибыл в " + city.getName() + " к " + day + " дню" + RST);

        calculateTotals();
    }

    private void calculateTotals() {
        double totalSelling;
        totalSelling = seller.getCart().stream().mapToDouble(Product::getSellingPrice).sum();
        seller.printCart();
        System.out.println();
        String message;
        if (totalPurchase > totalSelling)
            message = String.format("%sПоездка выдалась неудачной%nТорговец в минусе на %.2f%s", RED_BOLD, (totalPurchase - totalSelling), RST);
        else if (totalSelling > totalPurchase)
            message = String.format("%sТорговец удачно всё продал, вышел в плюс на %.2f%s", GREEN_BOLD, (totalSelling - totalPurchase), RST);
        else message = "Торговец продал всухую";
        System.out.println(message);
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
        List<Event> events = List.of(new FoundEateryEvent(), new MetLocalEvent(), new NormalDayEvent(), new RainyDayEvent(), new RiverEvent(), new RobbersEvent(), new SmoothRoadEvent(), new SpoiledEvent(), new WellBrokenEvent());
        return events.get(rnd(events.size()));
    }
}
