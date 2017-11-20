package lvl25.lesson05;

public class Task02 {

    public static void main(String[] args) {
        MyThread myThread = new Task02().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                try {
                    Thread.sleep(500);
                    System.out.printf("%s %s %s",secretKey, thread.getName(), throwable.getMessage());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}