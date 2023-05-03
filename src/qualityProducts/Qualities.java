package qualityProducts;

public enum Qualities {
    NORMAL("нормальное", 1.2), SLIGHTLY_SPOILED("слегка испорчен", 0.95), HALF_SPOILED("половина испортилась", 0.55), ALMOST_ALL_DISAPPEARED("почти весь пропал", 0.25), SPOILED_THE_TRASH("испорчен в хлам", 0.1);

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
