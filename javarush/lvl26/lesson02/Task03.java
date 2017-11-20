package lvl26.lesson02;


import java.util.Comparator;

public class Task03 {
    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {

        private Comparator<T> []comparators;

        public CustomizedComparator(Comparator<T> ...comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T c1, T c2) {
            int result = 0;
            for (Comparator iter : comparators) {
                result = iter.compare(c1, c2);
                if (result != 0)
                    break;
            }
            return result;
        }
    }

}


