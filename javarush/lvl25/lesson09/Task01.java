package lvl25.lesson09;

/**
 * Created by ATarasevich on 11.02.2017.
 * Все исключения, которые возникают в процессе работы нити Task03, должны быть обработаны одним из вариантов:
 1. Если это Error, то вывести в консоль «Нельзя дальше работать«.
 2. Если это Exception, то вывести в консоль «Надо обработать«.
 3. Если это Throwable, то вывести в консоль «ХЗ«.
 Реализуй эту логику.
 */
public class Task01 extends Thread {

    public Task01() {
    }

    public static void main(String[] args) {
        Thread thread = new Task01();
        thread.setUncaughtExceptionHandler((thread1, throwable) -> {
            if (throwable instanceof Error)
                System.out.println("Нельзя дальше работать");
            else if (throwable instanceof Exception)
                System.out.println("Надо обработать");
            else if (throwable instanceof Throwable)
                System.out.println("ХЗ");
        });
    }
}
