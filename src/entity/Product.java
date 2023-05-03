package entity;

import qualityProducts.Qualities;

import static utilities.Rnd.rnd;

public class Product {
    private final String type;
    private final int weight;
    private final double purchasePrice;
    private double sellingPrice;
    private Qualities quality;

    public Product() {
        String[] typesProduct = {"����", "����������", "�����", "����", "�����", "������"};
        this.type = typesProduct[rnd(typesProduct.length)];
        this.weight = rnd(5) + 6;
        this.purchasePrice = rnd(14) + 8;
        this.quality = Qualities.NORMAL;
    }

    public void setQuality(Qualities quality) {
        this.quality = quality;
        System.out.printf("��������� �������� %s ���������� �� %s%n",this.type, this.quality.getName());
    }

    public void decreaseQuality() {
        quality.decreaseQuality(this);
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



    @Override
    public String toString() {
        return String.format("%s | ���: %d | �-��: %s | ������ ��: %.2f | �������� ��: %.2f", type, weight, quality.getName(), purchasePrice, sellingPrice);
    }
}
