package utilities;

import java.util.Random;

public class Rnd {

    private Rnd(){}

    private static final Random random = new Random();

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
