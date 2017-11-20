package lvl5;

import java.util.Scanner;

/**
 * Created by ATarasevich on 04.05.2017.
 */
public class ModificReducerPageRank {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String prevVertex = "";
            String prevOutVertex = "";
            double resultVer = 0;
            String s;
            while (scanner.hasNextLine() && !(s = scanner.nextLine()).equals("")) {
                String[] tempBrokenLine = s.split("\t");
                String numberVertex = tempBrokenLine[0];
                String ver = tempBrokenLine[1];
                String outVertexs = tempBrokenLine[2];

                if (!prevVertex.equals("") && !prevVertex.equals(numberVertex)) {
                    System.out.printf("%s\t%.3f\t%s\n", prevVertex, 0.02+0.9*resultVer, prevOutVertex);

                    resultVer = 0;
                    prevOutVertex = "";
                }

                prevVertex = numberVertex;

                if (!outVertexs.equals("{}")) prevOutVertex = outVertexs;
                else resultVer += Double.parseDouble(ver);
            }

            System.out.printf("%s\t%.3f\t%s\n", prevVertex, 0.02+0.9*resultVer, prevOutVertex);
        }
    }
}
