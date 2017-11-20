package MyPrograms;

/**
 * Created by ATarasevich on 25.04.2017.
 */
class BubbleSort {

    public static void main(String[] args) {
        int[] array = {-9, 0, 2, 2, 8, 4, 1, 1, -2, -9};
        for (Integer iter : bubbleSort(array)) {
            System.out.print(iter + " ");
        }
    }

    public static int[] bubbleSort (int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
