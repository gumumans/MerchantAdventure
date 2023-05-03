package quality;

import entity.Product;

public enum Qualities implements Quality {
    NORMAL("нормальное", 1.2) {
        @Override
        public void decreaseQuality(Product product) {
            product.setQuality(SLIGHTLY_SPOILED);
        }
    }, SLIGHTLY_SPOILED("слегка испорчен", 0.95) {
        @Override
        public void decreaseQuality(Product product) {
            product.setQuality(HALF_SPOILED);
        }
    }, HALF_SPOILED("половина испортилась", 0.55) {
        @Override
        public void decreaseQuality(Product product) {
            product.setQuality(ALMOST_ALL_DISAPPEARED);

        }
    }, ALMOST_ALL_DISAPPEARED("почти весь пропал", 0.25) {
        @Override
        public void decreaseQuality(Product product) {
            product.setQuality(SPOILED_THE_TRASH);

        }
    }, SPOILED_THE_TRASH("испорчен в хлам", 0.1) {
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
