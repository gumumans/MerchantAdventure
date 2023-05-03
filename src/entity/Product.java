package entity;

import qualityProducts.Qualities;

import static utilities.Colors.*;
import static utilities.Rnd.rnd;

public class Product {
    private final String type;
    private final int weight;
    private final double purchasePrice;
    private double sellingPrice;
    private Qualities quality;

    public Product() {
        String[] typesProduct = {"мясо", "сухофрукты", "зерно", "мука", "ткани", "краска"};
        this.type = typesProduct[rnd(typesProduct.length)];
        this.weight = rnd(5) + 6;
        this.purchasePrice = rnd(14) + 8;
        this.quality = Qualities.NORMAL;
        setSellingPrice();
    }

    public void setQuality(Qualities quality) {
        this.quality = quality;
        System.out.printf(PURPLE + "Состояние продукта %s изменилось на %s%n" + RST,this.type, this.quality.getName());
    }

    public void decreaseQuality() {
        quality.decreaseQuality(this);
        setSellingPrice();
    }

    public Qualities getQuality() {
        return quality;
    }

    public int getWeight() {
        return weight;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }



    private void setSellingPrice() {
        sellingPrice = purchasePrice * quality.getRatio();
    }
    @Override
    public String toString() {
        return String.format(
                "%s%-18s | Вес: %-4d| Качество: %-27s | Закуп цена: %.2f, Цена прод: %.2f%s",YELLOW,
                type, weight, quality.getName(), purchasePrice, sellingPrice, RST);
    }
}
