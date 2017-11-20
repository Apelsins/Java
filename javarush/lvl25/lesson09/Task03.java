package lvl25.lesson09;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ATarasevich on 11.02.2017.
 */
public class Task03 implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable>throwables = new ArrayList<>();
        Throwable x=e;
        while (x!=null){
            throwables.add(0,x);
            x=x.getCause();
        }
        for(Throwable xx:throwables){
            System.out.println(xx);
        }
    }

    public static void main(String[] args) {
    }
}