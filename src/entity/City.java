package entity;

import static utilities.Rnd.nextInt;

public class City {
    private final String name;
    private final int distance;

    public City() {
        String[] citiesName = {"Мордор", "Содом и гомора", "Карабалта", "Караганда", "Братиславу"};
        this.name = citiesName[nextInt(citiesName.length)];
        this.distance = nextInt(51) + 50;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return String.format("Город назначения: %s%nРасстояние до города: %d",name,distance);
    }
}
