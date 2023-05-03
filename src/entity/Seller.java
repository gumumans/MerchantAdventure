package entity;

import java.util.ArrayList;
import java.util.List;

import static utilities.Rnd.rnd;

public class Seller {
    private int speed;
    private double balance;
    private int loadCapacity;
    private List<Product> cart;
    private int cartCapacity;
    private int distanceToCity;

    public Seller(int distanceToCity) {
        this.speed = rnd(5) + 1;
        this.balance = rnd(301) + 200;
        this.loadCapacity = rnd(121) + 80;
        this.cartCapacity = 0;
        this.cart = new ArrayList<>();
        this.distanceToCity = distanceToCity;
    }

    public void calculateCapacityCart(){
        this.cartCapacity = cart.stream().mapToInt(Product::getWeigh).sum();
    }

    public void moveToCity() {
        distanceToCity = distanceToCity - speed;
    }


    public  void moveToCity(int value){
        distanceToCity = distanceToCity - value - speed;
    }

    public void changeSpeed(int value) {
        final int maxSpeed = 5;
        final int minSpeed = 1;
        this.speed = Math.max(Math.min(this.speed + value, maxSpeed), minSpeed);
    }

    public void stop() {
        this.speed = 0;
    }

    public int getSpeed() {
        return speed;
    }

    public void takeMoney(double value){
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
        return String.format("Текущая скорость: %d | Баланс %.2f | Вес телеги: %d", speed, balance, cartCapacity);
    }
}
