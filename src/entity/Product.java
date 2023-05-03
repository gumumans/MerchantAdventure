package entity;

import qualityProducts.Qualities;

import static utilities.Rnd.rnd;

public class Product {
    private final String type;
    private final int weigth;
    private final double purchasePrice;
    private double sellingPrice;
    private Qualities quality;

    public Product() {
        String[] typesProduct = {"����", "����������", "�����", "����", "�����", "������"};
        this.type = typesProduct[rnd(typesProduct.length)];
        this.weigth = rnd(5) + 6;
        this.purchasePrice = rnd(14) + 8;
        this.quality = Qualities.NORMAL;
        setSellingPrice();
    }

    public void setQuality(Qualities quality) {
        this.quality = quality;
        System.out.printf("��������� �������� %s ���������� �� %s%n",this.type, this.quality.getName());
    }

    public void decreaseQuality() {
        quality.decreaseQuality(this);
        setSellingPrice();
    }
    private void setSellingPrice() {
        sellingPrice = purchasePrice * quality.getRatio();
    }
    @Override
    public String toString() {
        return String.format("%s | ���: %d | �-��: %s | ������ ��: %.2f | �������� ��: %.2f", type, weigth, quality.getName(), purchasePrice, sellingPrice);
    }
}
