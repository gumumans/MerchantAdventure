package entity;

import static utilities.Rnd.rnd;

public class City {
    private final String name;
    private final int distance;

    public City() {
        String[] citiesName = {"������", "����� � ������", "���������", "���������", "����������"};
        this.name = citiesName[rnd(citiesName.length)];
        this.distance = rnd(51) + 50;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("����� ����������: %s%n���������� �� ������: %d",name,distance);
    }
}
