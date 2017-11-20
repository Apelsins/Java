package lvl25.lesson05;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Task01 {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread iterTread : threads)
            switch (iterTread.getState()) {
                case NEW :
                    iterTread.start();
                    break;
                case BLOCKED:
                    iterTread.interrupt();
                    break;
                case WAITING:
                    iterTread.interrupt();
                    break;
                case TIMED_WAITING:
                    iterTread.interrupt();
                    break;
                case RUNNABLE:
                    iterTread.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(iterTread.getPriority());
                    break;
            }
    }
}
