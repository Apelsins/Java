package lvl23.lesson08;

/* Напряги извилины!
Метод printName должен выводить свое собственное имя, т.е. "sout"
Сделайте минимум изменений.
*/
public class Task01 {
    private String name;

    Task01(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void sout() {
        new Task01("sout") {
            void printName() {
                System.out.println(super.getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Task01("main").sout();
    }
}
