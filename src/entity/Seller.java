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

    public Seller() {
        this.speed = rnd(5) + 1;
        this.balance = rnd(301) + 200;
        this.loadCapacity = rnd(121) + 80;
        this.cartCapacity = 0;
        this.cart = new ArrayList<>();
    }

// TODO: 03.05.2023 добавить реализацию перемещения торговца, его покупка товаров, продажа


    public int getSpeed() {
        return speed;
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
