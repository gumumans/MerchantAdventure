package entity;

import static utilities.Rnd.rnd;

public class Product {
    private final String type;
    private final int weigth;
    private final double purchasePrice;
    private double sellingPrice;
    private String quality;

    public Product() {
        String[] typesProduct = {"мясо", "сухофрукты", "зерно", "мука", "ткани", "краска"};
        this.type = typesProduct[rnd(typesProduct.length)];
        this.weigth = rnd(5) + 6;
        this.purchasePrice = rnd(14) + 8;
        this.quality = "";
    }

    @Override
    public String toString() {
        return String.format("%s | Вес: %d | К-во: %s | Купили за: %.2f | Продадим за: %.2f", type, weigth, quality, purchasePrice, sellingPrice);
    }
}
