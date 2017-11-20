package lvl4;

import java.util.*;

/**
 * Created by ATarasevich on 19.04.2017.
 */
public class CombinerAvarageTime {
    public static void main(String[] args) {
        String result = "";
        Map<String, List<Integer>> map = new LinkedHashMap<>();

        try (Scanner scanner = new Scanner(System.in)) {
            String s = "";
            while (scanner.hasNextLine() && !(s = scanner.nextLine()).equals("") ) {
                String adressPage = s.replaceAll("\\s*\\d*;\\d*$", "");
                String[] array = s.replaceAll("^\\S*\\D*", "").split(";");
                int timeSession = Integer.parseInt(array[0]);
                //System.out.println(adressPage + "  " + sec);
                if (!map.containsKey(adressPage)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(timeSession);
                    list.add(1);
                    map.put(adressPage, list);
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(map.get(adressPage).get(0) + timeSession);
                    list.add(map.get(adressPage).get(1) + 1);
                    map.put(adressPage, list);
                }

            }
        }

        for (Map.Entry<String, List<Integer>> pair : map.entrySet()) {
            result += pair.getKey() + '\t' + pair.getValue().get(0) + ";" + pair.getValue().get(1) + '\n';
        }

        System.out.println(result);
    }
}
