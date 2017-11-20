package lvl4;

import java.util.Scanner;

/**
 * Created by ATarasevich on 24.04.2017.
 */
public class CrossReducer {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String prev = "";
            String s;
            String writenPrevElem = "";
            while (scanner.hasNextLine() && !(s = scanner.nextLine()).equals("") ) {
                String elem = s.split("\t")[0];
                String marker = s.split("\t")[1];
                // Если уже взяли хотя бы одну строку и
                // если маркеры множества разные и
                // если элементы одинаковые и
                // если элемент уже записан
                if (!prev.equals("") && !prev.split("\t")[1].equals(marker) && prev.split("\t")[0].equals(elem) && !writenPrevElem.equals(elem)) {
                    System.out.println(elem);
                    writenPrevElem = elem;
                }
                prev = s;
            }
        }
    }
}
