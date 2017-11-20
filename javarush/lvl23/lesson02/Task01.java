package lvl23.lesson02;

/* Запретите создание экземпляров класса
Запретите создание экземпляров класса Listener.
*/
public class Task01 {

    public static class Listener {

        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {
        Listener listener = new Listener();
    }
}