package lvl5;

import java.util.Scanner;

/**
 * Created by ATarasevich on 02.05.2017.
 */
public class MapperSearchShotestWay {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String s;
            while (scanner.hasNextLine() && !(s = scanner.nextLine()).equals("")) {
                String[] tempBrokenLine = s.split("\t");
                String numberVertex = tempBrokenLine[0];
                String lengthWay = tempBrokenLine[1];
                String[] outVertexs = tempBrokenLine[2].split("\\W+");

                System.out.println(s);
                for (int i = 0; i < outVertexs.length; i++) {
                    // регулярка возвращает пусутю строку, а + не помогает
                    if (outVertexs[i].equals("")) continue;
                    System.out.println(outVertexs[i] + "\t" +
                            (lengthWay.equals("INF") ? "INF" : Integer.parseInt(lengthWay) + 1 + "") +
                            "\t" + "{}");
                }
            }
        }
    }
}
