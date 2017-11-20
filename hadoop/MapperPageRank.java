package lvl5;

import java.util.*;

/**
 * Created by ATarasevich on 04.05.2017.
 */
public class MapperPageRank {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String s;
            while (scanner.hasNextLine() && !(s = scanner.nextLine()).equals("")) {
                String[] tempBrokenLine = s.split("\t");
                String numberVertex = tempBrokenLine[0];
                String lengthWay = tempBrokenLine[1];
                String[] outVertexs = tempBrokenLine[2].split("\\W+");

                System.out.println(s);
                for (int i = 0; i < outVertexs.length ; i++) {
                    if (!outVertexs[i].equals(""))
                    //System.out.println(outVertexs[i] + "\t" + Double.parseDouble(lengthWay)/(outVertexs.length - 1) + "\t" + "{}");
                    System.out.printf("%s\t%.3f\t{}\n", outVertexs[i], Double.parseDouble(lengthWay)/(outVertexs.length - 1));
                }

            }
        }
    }
}
