package lvl4;

import java.util.*;

/**
 * Created by ATarasevich on 25.04.2017.
 */
public class ReducerJoin {
    public static void main(String[] args) {

        List<String> listQuery = new ArrayList<>();
        List<String> listUrl = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            String prevKey = "";
            String s;
            while (scanner.hasNextLine() && !(s = scanner.nextLine()).equals("")) {
                String key = s.split("\t")[0];
                String marker = s.split("\t")[1].split(":")[0];
                String value = s.split("\t")[1].split(":")[1];

                if (!prevKey.equals(key)) {
                    // печатаем
                    printLists(listUrl, listQuery, prevKey);

                    // очищаем
                    listQuery.clear();
                    listUrl.clear();

//                    listQuery.add(marker);
//                    listUrl.add(value);
                }

                if (marker.equals("query")) listQuery.add(value);
                else listUrl.add(value);

                prevKey = key;
            }

            printLists(listUrl, listQuery, prevKey);

        }
    }

    public static <T> void printLists (List<T> listInner, List<T> listOuter, String s) {
        for (T iterOuter : listOuter) {
            for (T iterInner : listInner) {
                System.out.println(s + '\t' + iterOuter + '\t' + iterInner);
            }
        }
    }
}
