package lvl4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by ATarasevich on 26.04.2017.
 */
public class TfIdfMapper2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            String prev = "";
            String s;
            int count = 0;
            while (scanner.hasNextLine() && !(s = scanner.nextLine()).equals("")) {

                if (!prev.equals("") && !prev.split("\t")[0].equals(s.split("\t")[0])) {
                    printReplace(list, count);
                    list.clear();
                    count = 0;
                }

                prev = s;
                count++;
                list.add(s);
            }

            printReplace(list, count);
        }
    }

    public static void printReplace (List<String> list, int count) {
        for (String iter : list) {
            // распарсить строку нужно
            String[] arrayParam = Pattern.compile("\\W+").split(iter);
            System.out.println(arrayParam[0] + "#" +
                    arrayParam[1] + "\t" +
                    arrayParam[2] + "\t" + count);
        }
    }
}
