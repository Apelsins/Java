package MyPrograms.Chapter_6;

/**
 * Created by ATarasevich on 25.09.2017.
 */

public class _6_1AdditionInsteadMultipl {
    public static void main(String[] args) {
        System.out.println(mult(5, 10));
    }

    static int mult(int x, int y) {

        if (y == 0) return 0;

        return x + mult(x, y-1);
    }
}
