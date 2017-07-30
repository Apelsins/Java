import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Поиск подстроки происходит с помощью алгоритма Кнута-Морриса-Пратта.
 * Берется по 5000 символов, если подстрока не найдена происходит сдвиг вправо на 4940 элементов.
 */
public class SearchSubstring {
    private String pat;
    private int[][] dfa;
    public SearchSubstring(String pat) { // Построение ДКА из образца
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) { // Вычисление dfa[][j]
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X]; // Копирование случаев несовпадения
            dfa[pat.charAt(j)][j] = j+1; // Случай совпадения
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) { // Моделирование работы ДКА для txt
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == M) return i - M; // Образец найден (достигнут конец образа)
        else        return N;     // Не найден (достигнут конец текста)
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // Читаем подстроку
            String pat = reader.readLine();
            long start = System.currentTimeMillis();
            //System.out.println(start);
            // Проверка, что она не пустая
            if (pat.isEmpty())
                break;

            // Размер подстроки
            int sizePat = pat.length();

            String txt = "";
            SearchSubstring searchSubstring = new SearchSubstring(pat);

            int addToAnswer = 0;
            int getString = 5000; // Примерное число взятия строк
            long nextNum = 1;
            int offset = 5000;
            while (offset >= getString) {

                // Если слишком долго ищется (больше 45 сек) прерывается
                if (System.currentTimeMillis() > start + 60000) {
                    System.out.println("Not found for 60 sec =(");
                    break;
                }

                // Для ускорения работы используется StringBuilder
                StringBuilder txtBuilder = new StringBuilder(txt);

                while (txtBuilder.length() <= getString) {
                    txtBuilder.append(nextNum++);
                }
                // Возвращаем String
                txt = txtBuilder.toString();
                // Сдвиг найденной подстроки
                offset = searchSubstring.search(txt);

                //Если подстрока не найдена сдвигаемся вправо
                if (offset >= getString) {
                    txtBuilder = new StringBuilder(txt.substring(4940, txt.length()));
                    while (txtBuilder.length() <= getString) {
                        txtBuilder.append(nextNum++);
                        addToAnswer += 4940;
                    }
                    txt = txtBuilder.toString();
                }
            }
            //System.out.println("text:  " + txt);
            //System.out.println("pat:   " + pat);
            System.out.println(offset + addToAnswer + 1);


        }
    }
}

