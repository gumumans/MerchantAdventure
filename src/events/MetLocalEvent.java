package events;

import entity.Seller;

import static utilities.Rnd.rnd;

public class MetLocalEvent extends Event {
    public MetLocalEvent() {
        super("�������� ��������", true);
    }

    @Override
    public void doEvent(Seller seller) {
        int shortCutDistance = rnd(4) + 3;
        System.out.printf("\t������� ������� ����� ���� (� ���� ���� �������� ������ �� %d ���)%n",shortCutDistance);
        seller.moveToCity(shortCutDistance);
    }
}
