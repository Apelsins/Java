package lvl25.lesson07;

/**
 * Created by ATarasevich on 11.02.2017.
 */

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    Thread threadTask;

    @Override
    public void run() {

            try {
                while(!threadTask.isInterrupted()) {
                    threadTask.sleep(0);
                    System.out.println(Thread.currentThread().getName());
                    threadTask.sleep(100);
                }
            } catch (InterruptedException e) {
            }

    }

    @Override
    public void start(String threadName) {
        threadTask = new Thread(this);
        threadTask.setName(threadName);
        threadTask.start();
    }

    @Override
    public void stop() {
        threadTask.interrupt();
    }
}
