import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ����� ��������� ���������� � ������� ��������� �����-�������-������.
 * ������� �� 5000 ��������, ���� ��������� �� ������� ���������� ����� ������ �� 4940 ���������.
 */
public class SearchSubstring {
    private String pat;
    private int[][] dfa;
    public SearchSubstring(String pat) { // ���������� ��� �� �������
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) { // ���������� dfa[][j]
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X]; // ����������� ������� ������������
            dfa[pat.charAt(j)][j] = j+1; // ������ ����������
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) { // ������������� ������ ��� ��� txt
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == M) return i - M; // ������� ������ (��������� ����� ������)
        else        return N;     // �� ������ (��������� ����� ������)
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // ������ ���������
            String pat = reader.readLine();
            long start = System.currentTimeMillis();
            //System.out.println(start);
            // ��������, ��� ��� �� ������
            if (pat.isEmpty())
                break;

            // ������ ���������
            int sizePat = pat.length();

            String txt = "";
            SearchSubstring searchSubstring = new SearchSubstring(pat);

            int addToAnswer = 0;
            int getString = 5000; // ��������� ����� ������ �����
            long nextNum = 1;
            int offset = 5000;
            while (offset >= getString) {

                // ���� ������� ����� ������ (������ 45 ���) �����������
                if (System.currentTimeMillis() > start + 60000) {
                    System.out.println("Not found for 60 sec =(");
                    break;
                }

                // ��� ��������� ������ ������������ StringBuilder
                StringBuilder txtBuilder = new StringBuilder(txt);

                while (txtBuilder.length() <= getString) {
                    txtBuilder.append(nextNum++);
                }
                // ���������� String
                txt = txtBuilder.toString();
                // ����� ��������� ���������
                offset = searchSubstring.search(txt);

                //���� ��������� �� ������� ���������� ������
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

