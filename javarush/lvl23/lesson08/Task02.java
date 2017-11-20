package lvl23.lesson08;

/**
 * Created by ATarasevich on 01.08.2017.
 */
public class Task02 {
    public final String name;
    public final String food;
    public final String sound;

    public Task02(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " sec");
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    someActions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                Task02.this.sleep(1000);
            }
        };
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Task02("Amigo", "beef", "knock").live();
    }
}
