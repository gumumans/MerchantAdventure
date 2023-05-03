package qualityProducts;

public enum Qualities {
    NORMAL("����������", 1.2), SLIGHTLY_SPOILED("������ ��������", 0.95), HALF_SPOILED("�������� �����������", 0.55), ALMOST_ALL_DISAPPEARED("����� ���� ������", 0.25), SPOILED_THE_TRASH("�������� � ����", 0.1);

    private String name;
    private double ratio;

    Qualities(String name, double ratio) {
        this.name = name;
        this.ratio = ratio;
    }

    public String getName() {
        return name;
    }

    public double getRatio() {
        return ratio;
    }
}
