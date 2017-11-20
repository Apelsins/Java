package lvl26.lesson02;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5
*/
public class Task01 {

    public static void main(String[] args) {
        Integer[] mass = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(sort(mass)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        // Находим медиану
        final double mediana;
        if (array.length % 2 == 0)
            mediana = (array[array.length/2 - 1] + array[array.length/2]) / 2.;
        else mediana = array[array.length/2];

        //System.out.println(mediana);

        Comparator<Integer> compareMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                double x = Math.abs(integer - mediana) + Math.abs(t1 - mediana);
                if (x == 0)
                    x = integer - t1;

                return (int) x;
            }
        };

        return array;
    }


}