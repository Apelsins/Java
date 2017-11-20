package MyPrograms;

/**
 * Created by ATarasevich on 25.04.2017.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {-9, 0, 2, 2, 8, 4, 1, 1, -2, -9, 10, 11, -11};
        for (Integer iter : selectSort(array)) {
            System.out.print(iter + " ");
        }
    }

    static int[] selectSort (int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[min] > array[j]) min = j;
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }
}
