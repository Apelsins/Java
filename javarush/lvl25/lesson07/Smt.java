package lvl25.lesson07;

/**
 * Created by ATarasevich on 06.02.2017.
 */
public class Smt {
    public static void main(String[] args) {
        Object o = new Long((long) 4);
        boolean isInt = o instanceof Integer;
        System.out.println(isInt);
    }
}
