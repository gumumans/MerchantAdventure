package quality;

import entity.Product;

public enum Qualities implements Quality {
    NORMAL("����������", 1.2) {
        @Override
        public void decreaseQuality(Product product) {
            product.setQuality(SLIGHTLY_SPOILED);
        }
    }, SLIGHTLY_SPOILED("������ ��������", 0.95) {
        @Override
        public void decreaseQuality(Product product) {
            product.setQuality(HALF_SPOILED);
        }
    }, HALF_SPOILED("�������� �����������", 0.55) {
        @Override
        public void decreaseQuality(Product product) {
            product.setQuality(ALMOST_ALL_DISAPPEARED);

        }
    }, ALMOST_ALL_DISAPPEARED("����� ���� ������", 0.25) {
        @Override
        public void decreaseQuality(Product product) {
            product.setQuality(SPOILED_THE_TRASH);

        }
    }, SPOILED_THE_TRASH("�������� � ����", 0.1) {
        @Override
        public void decreaseQuality(Product product) {
            // TODO document why this method is empty
        }
    };

    private final String name;
    private final double ratio;

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
