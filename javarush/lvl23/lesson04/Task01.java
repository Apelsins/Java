package lvl23.lesson04;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Task03.
Для каждого экземпляра класса Task03 инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Task01 {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Task01[] getTwoSolutions() {
        Task01[] arrayTasks = {new Task01(), new Task01()};
        arrayTasks[0].innerClasses[0] = new Task01().new InnerClass();
        arrayTasks[0].innerClasses[1] = new Task01().new InnerClass();
        arrayTasks[1].innerClasses[0] = new Task01().new InnerClass();
        arrayTasks[1].innerClasses[1] = new Task01().new InnerClass();
        return arrayTasks;
    }
}
