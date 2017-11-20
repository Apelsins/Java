package lvl5;

import java.util.*;

/**
 * Created by ATarasevich on 03.05.2017.
 */
public class ReducerSearchShotestWay {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String prev = "";
            int minValue = Integer.MAX_VALUE / 2;
            Set<String> set = new LinkedHashSet<>();
            String s;
            while (scanner.hasNextLine() && !(s = scanner.nextLine()).equals("")) {

                String[] tempBrokenLine = s.split("\t");
                String numberVertex = tempBrokenLine[0];
                String lengthWay = tempBrokenLine[1];
                String[] outVertexs = tempBrokenLine[2].split("\\W+");

                if (!prev.equals("") && !prev.equals(numberVertex)) {
                    set.remove("");
                    System.out.println(prev + "\t" +
                            (minValue == Integer.MAX_VALUE / 2 ? "INF" : minValue) + "\t" +
                            ptintSet(set));

                    minValue = Integer.MAX_VALUE / 2;
                    set.clear();
                }

                // нужно отслеживать изменение вершины
                prev = numberVertex;

                // чтобы сравнивать не string, а int
                int tempMinValue = 0;
                if (lengthWay.equals("INF"))
                    tempMinValue = Integer.MAX_VALUE / 2;
                else tempMinValue = Integer.parseInt(lengthWay);
                // определение минимального пути до вершины
                if (minValue > tempMinValue)
                    minValue = tempMinValue;
                // множство связей в вершиной
                set.addAll(Arrays.asList(outVertexs));
            }

            set.remove("");
            System.out.println(prev + "\t" +
                    (minValue == Integer.MAX_VALUE / 2 ? "INF" : minValue) + "\t" +
                    ptintSet(set));
        }
    }

    public static String ptintSet(Set set) {
        Iterator var1 = set.iterator();
        if(!var1.hasNext()) {
            return "{}";
        } else {
            StringBuilder var2 = new StringBuilder();
            var2.append('{');

            while(true) {
                Object var3 = var1.next();
                var2.append(var3 == set?"(this Collection)":var3);
                if(!var1.hasNext()) {
                    return var2.append('}').toString();
                }

                var2.append(',').append(' ');
            }
        }
    }
}
