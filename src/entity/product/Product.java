package entity.product;

import static utilities.Colors.*;
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
        this.purchasePrice = rnd(14) + 8D;
        this.quality = Qualities.NORMAL;
        setSellingPrice();
    }

    protected void setQuality(Qualities quality) {
        this.quality = quality;
        System.out.printf(PURPLE + "��������� �������� %s ���������� �� %s%n" + RST, this.type, this.quality.getName());
    }

    public void decreaseQuality() {
        quality.decrease(this);
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
                "%s%-18s | ���: %-4d| ��������: %-27s | ����� ����: %6.2f, ���� ����: %6.2f%s", YELLOW,
                type, weight, quality.getName(), purchasePrice, sellingPrice, RST);
    }
}
