package entity;

import java.util.ArrayList;
import java.util.List;

import static utilities.Colors.*;
import static utilities.Rnd.rnd;

public class Seller {
    private int speed;
    private double balance;
    private final int loadCapacity;
    private final List<Product> cart;
    private int cartCapacity;
    private int distanceToCity;

    public Seller(int distanceToCity) {
        this.speed = rnd(5) + 1;
        this.balance = rnd(301) + 200d;
        this.loadCapacity = rnd(121) + 80;
        this.cartCapacity = 0;
        this.cart = new ArrayList<>();
        this.distanceToCity = distanceToCity;
    }

    public void purchase(Product product) {
        if (balance >= product.getPurchasePrice()) {
            if (loadCapacity >= (cartCapacity + product.getWeight())) {
                cart.add(product);
                balance -= product.getPurchasePrice();
                cartCapacity += product.getWeight();
                System.out.println(product);
            } else
                System.out.println("У торговца не осталось места");
        } else
            System.out.println("У торговца закончились деньги");
    }

    public void selling(Product product) {
        if (!cart.isEmpty()) {
            this.balance += product.getSellingPrice();
            this.cart.remove(product);
            this.cartCapacity -= product.getWeight();
            System.out.printf("%sБыл продан %-17s %s+$%-7.2f%n%sТекущий баланс: %.2f%s%n", RED, product, GREEN, product.getSellingPrice(), YELLOW, balance, RST);
        } else
            System.out.println("У торговца ничегошеньки нет :(");
    }

    public void calculateCapacityCart() {
        this.cartCapacity = cart.stream().mapToInt(Product::getWeight).sum();
    }

    public void printCart() {
        StringBuilder sb = new StringBuilder("Товары торговца:\n");
        cart.forEach(p -> sb.append((String.format("%s%s%s%n", YELLOW, p.toString(), RST))));
        System.out.println(sb);
    }

    public void moveToCity() {
        distanceToCity = Math.max((distanceToCity - speed), 0);
    }

    public void moveToCity(int value) {
        distanceToCity = Math.max((distanceToCity - (speed + value)), 0);
    }

    public void changeSpeed(int value) {
        final int maxSpeed = 5;
        final int minSpeed = 1;
        this.speed = Math.max(Math.min(this.speed + value, maxSpeed), minSpeed);
    }

    public void stop() {
        this.speed = 0;
    }

    public int getDistanceToCity() {
        return distanceToCity;
    }

    public void takeMoney(double value) {
        this.balance = (balance - value) < 0 ? 0 : balance - value;
    }

    public double getBalance() {
        return balance;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public List<Product> getCart() {
        return cart;
    }

    public int getCartCapacity() {
        return cartCapacity;
    }

    @Override
    public String toString() {
        return String.format("%sТекущая скорость: %d | Баланс %.2f | Вес телеги: %d" +
                "%n%sРасстояние до города: %d%s", BLUE, speed, balance, cartCapacity, GREEN, distanceToCity, RST);
    }
}
