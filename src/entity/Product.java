package entity;

import static utilities.Rnd.rnd;

public class Product {
    private final String type;
    private final int weigth;
    private final double purchasePrice;
    private double sellingPrice;
    private String quality;

    public Product() {
        String[] typesProduct = {"����", "����������", "�����", "����", "�����", "������"};
        this.type = typesProduct[rnd(typesProduct.length)];
        this.weigth = rnd(5) + 6;
        this.purchasePrice = rnd(14) + 8;
        this.quality = "";
    }

    @Override
    public String toString() {
        return String.format("%s | ���: %d | �-��: %s | ������ ��: %.2f | �������� ��: %.2f", type, weigth, quality, purchasePrice, sellingPrice);
    }
}
