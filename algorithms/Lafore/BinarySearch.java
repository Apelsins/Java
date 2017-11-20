package MyPrograms;

/**
 * Created by ATarasevich on 20.04.2017.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 6, 10, 11, 23, 72, 56, 98, 100};
        System.out.println(find(100, array));
    }

    public static int find(int elem, int[] array) {
        int indexFirst = 0;
        int indexEnd = array.length - 1;
        while (true) {
            int midd = (indexFirst + indexEnd) / 2;
            if (array[midd] == elem) return midd;
            if (indexFirst > indexEnd) return -1;
            else if (array[midd] < elem) indexFirst = midd + 1;
            else if (array[midd] > elem) indexEnd = midd - 1;
        }
    }
}
