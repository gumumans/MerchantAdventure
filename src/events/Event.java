package events;

import entity.Seller;

public abstract class Event {
    private final String name;
    private final boolean isLucky;

    protected Event(String name, boolean isLucky) {
        this.name = name;
        this.isLucky = isLucky;
    }

    public abstract void doEvent(Seller seller);

    @Override
    public String toString() {
        return String.format("Событие: %s", name);
    }
}
