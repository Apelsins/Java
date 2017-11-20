package MyPrograms;

/**
 * Created by ATarasevich on 25.04.2017.
 */
public class InsertionSortTest {
    public static void main(String[] args) {
        int[] array = {-9, 0, 2, 2, 8, 4, 1, 1, -2, -9, 10, 11, -11};
        InsertionSort insertSort = new InsertionSort(array);
        insertSort.insertionSort();
        insertSort.print();
    }
}

class InsertionSort {
    private int[] array;

    public InsertionSort(int[] array) {
        this.array = array;
    }

    public void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int current = i;

            while (current > 0 && array[current-1] >= temp) {
                array[i] = array[i-1];
                --current;
            }
            array[current] = temp;
        }
    }

    public void print() {
        for (Integer iter : array) {
            System.out.print(iter + " ");
        }
    }

}
