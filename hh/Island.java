import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * �������� �� �������:
 * A=
 * 5 3 4 5
 * 6 2 1 4
 * 3 1 1 4
 * 8 5 4 3
 * 1) ��� ���������� ����������� � ���������� ������ (������� ����� ����� � ����) ������� � ��������� ������ B (=2).
 * ��� ������� ������� ��������� � ����� ��������. ��� ������ � ���� ������� � HashSet {3, 4, 5, 6}.
 * B =
 * 0 2 2 0
 * 2 0 0 2
 * 2 0 0 2
 * 0 2 2 0
 * 2) ���� ���������� min(hashSet) = 3.
 * 3) ���� A[i][j] == min(hashSet) && B[i][j] == 2
 * 3.1) ���� ��� �������, ������� ������, ��� min(hashSet) ����� � A[i][j] �� ������� �� �������:
 *      ������� �����, ����� �����, ����, ������. � ���� ��������� ������� ������, ��� min (hashSet) ������� �� � hashSet. �������� ����� ������������� ��������� � ���� �������.
 * 3.2) ���� ����� ������� ������, �� ������������ � �� ���������� � ������������ ��� � min(hashSet), � B[i][j] = 2.
 * 3.3) ���������, ����� ��� ��������� ������� ������, ��� min(hashSet).
 * i,j ���� ���������� !
 * A=           B=
 * 5 3! 4 5     0 2! 2 0
 * 6 2 1 4      2 0 0 2
 * 3 1 1 4      2 0 0 2
 * 8 5 4 3      0 2 2 0
 * A=           B=
 * 5 3 4 5      0 2 2 0
 * 6 3! 1 4     2 2! 0 2
 * 3 1 1 4      2 0 0 2
 * 8 5 4 3      0 2 2 0
 * A=           B=
 * 5 3 4 5      0 2 2 0
 * 6 3 1 4      2 2 0 2
 * 3 3! 1 4     2 2! 0 2
 * 8 5 4 3      0 2 2 0
 * A=           B=
 * 5 3 4 5      0 2 2 0
 * 6 3 1 4      2 2 0 2
 * 3 3 3! 4     2 2 2! 2
 * 8 5 4 3      0 2 2 0
 * A=           B=
 * 5 3 4 5      0 2 2 0
 * 6 3 3! 4     2 2 2! 2
 * 3 3 3 4      2 2 2 2
 * 8 5 4 3      0 2 2 0
 * ��� ������� B ��������.
 */

public class Island {

    public static int[][] arrIsland = {{0}};

    public static int water = 0; //������� ���������� ����

    public static int sizeN = arrIsland.length; // ���������� �����
    public static int sizeM = arrIsland[0].length; // ���������� ��������
    // ��������������� ������, �� ������� ������������ ����� � ����
    public static byte[][] arrGostIsland = new byte[sizeN][sizeM];
    // �������� ��� ������ ������ � ����
    public static HashSet<Integer> heightExit = new HashSet<>();


    public static int searchMinInSet(HashSet<Integer> hashSet) {
        int minElement = 1001; // �� ������� ������
        for (Integer iterInt : hashSet) {
            if (iterInt < minElement)
                minElement = iterInt;
        }
        return minElement;
    }

    public static void passWay(int i, int j, int edgeSea) {
        arrGostIsland[i][j] = 2;
        //heightExit.add(arrIsland[i][j]);
        if (arrIsland[i - 1][j] >= edgeSea) {
            arrGostIsland[i - 1][j] = 2;
            heightExit.add(arrIsland[i - 1][j]);
        }
        if (arrIsland[i][j - 1] >= edgeSea) {
            arrGostIsland[i][j - 1] = 2;
            heightExit.add(arrIsland[i][j - 1]);
        }
        if (arrIsland[i + 1][j] >= edgeSea) {
            arrGostIsland[i + 1][j] = 2;
            heightExit.add(arrIsland[i + 1][j]);
        }
        if (arrIsland[i][j + 1] >= edgeSea) {
            arrGostIsland[i][j + 1] = 2;
            heightExit.add(arrIsland[i][j + 1]);
        }
    }

    public static void searchCavity(int startI, int startJ) {
        int i = startI;
        int j = startJ;
        int edge = arrIsland[startI][startJ]; // ������ ��������� �����
        int prevStep = 0; // 1 - up, 2 - left, 3 - down, 4 - right
        // ���� �� ������� �������
        if (i == 0) {
            if (arrIsland[i + 1][j] <= edge) {
                water += edge - arrIsland[i + 1][j];
                i++;
                passWay(i, j, edge);
                arrIsland[i][j] = edge;
                arrGostIsland[i][j] = 2;
            } else {
                arrGostIsland[i + 1][j] = 2;
                heightExit.add(arrIsland[i + 1][j]);
                return;
            }
        }

        if (j == 0) {
            if (arrIsland[i][j + 1] <= edge) {
                water += edge - arrIsland[i][j + 1];
                j++;
                passWay(i, j, edge);
                arrIsland[i][j] = edge;
                arrGostIsland[i][j] = 2;
            } else {
                arrGostIsland[i][j + 1] = 2;
                heightExit.add(arrIsland[i][j + 1]);
                return;
            }
        }

        if (i == sizeN - 1) {
            if (arrIsland[i - 1][j] <= edge) {
                water += edge - arrIsland[i - 1][j];
                i--;
                passWay(i, j, edge);
                arrIsland[i][j] = edge;
                arrGostIsland[i][j] = 2;
            } else {
                arrGostIsland[i - 1][j] = 2;
                heightExit.add(arrIsland[i - 1][j]);
                return;
            }
        }

        if (j == sizeM - 1) {
            if (arrIsland[i][j - 1] <= edge) {
                water += edge - arrIsland[i][j - 1];
                j--;
                passWay(i, j, edge);
                arrIsland[i][j] = edge;
                arrGostIsland[i][j] = 2;
            } else {
                arrGostIsland[i][j - 1] = 2;
                heightExit.add(arrIsland[i][j - 1]);
                return;
            }
        }

        while (!(arrGostIsland[i - 1][j] == 2 && arrGostIsland[i][j - 1] == 2 &&
                arrGostIsland[i + 1][j] == 2 && arrGostIsland[i][j + 1] == 2)) {

            passWay(i, j, edge); // ?? ���� ������ ������ �������� ��������

            // ���� ������. �������: 1) ������� ���� ������ ����� ����� � ����, ����������� �� ���������
            // 2) ������� ���� �� ������� (����� ����� � ����) 3) �� �������� ����� (prevStep != 3)
            if (arrGostIsland[i - 1][j] != 2 && arrIsland[i - 1][j] <= edge && prevStep != 3) {
                water += edge - arrIsland[i - 1][j];
                arrIsland[i - 1][j] = edge;
                i--; // ���� �����
                // ����������� � ������� ���� �������� ������ , ���� ��� ������ edge
                passWay(i, j, edge);
                prevStep = 1;
                continue;
            }
            // ���� �����
            if (j != 0 && arrGostIsland[i][j - 1] != 2 && arrIsland[i][j - 1] <= edge && prevStep != 4) {
                water += edge - arrIsland[i][j - 1];
                arrIsland[i][j - 1] = edge;
                j--; // ���� �����
                passWay(i, j, edge);
                prevStep = 2;
                continue;
            }
            // ���� ����
            if (i != sizeN - 1 && arrGostIsland[i + 1][j] != 2 && arrIsland[i + 1][j] <= edge && prevStep != 1) {
                water += edge - arrIsland[i + 1][j];
                arrIsland[i + 1][j] = edge;
                i++; // ���� ����
                passWay(i, j, edge);
                prevStep = 3;
                continue;
            }
            // ���� ������
            if (j != sizeM - 1 && arrGostIsland[i][j + 1] != 2 && arrIsland[i][j + 1] <= edge && prevStep != 2) {
                water += edge - arrIsland[i][j + 1];
                arrIsland[i][j + 1] = edge;
                j++; // ���� ������
                passWay(i, j, edge);
                prevStep = 4;
                continue;
            }
        }
    }

    public static boolean areaRed(int i, int j) {
        if (i == 0 && arrGostIsland[i + 1][j] != 2)
            return true;
        if (j == 0 && arrGostIsland[i][j + 1] != 2)
            return true;
        if (i == sizeN - 1 && arrGostIsland[i - 1][j] != 2)
            return true;
        if (j == sizeM - 1 && arrGostIsland[i][j - 1] != 2)
            return true;

        // ���� ��� 1 ��� ������, ����� �� ����� �� �������
        if (i == 0 && arrGostIsland[i + 1][j] == 2)
            return false;
        if (j == 0 && arrGostIsland[i][j + 1] == 2)
            return false;
        if (i == sizeN - 1 && arrGostIsland[i - 1][j] == 2)
            return false;
        if (j == sizeM - 1 && arrGostIsland[i][j - 1] == 2)
            return false;


        // ��� �������
        if (arrGostIsland[i][j] == 2 && arrGostIsland[i - 1][j] == 2 && arrGostIsland[i][j - 1] == 2 &&
                arrGostIsland[i + 1][j] == 2 && arrGostIsland[i][j + 1] == 2)
            return false;
        // �������� �������, � ���� ���� ������ ���
        if (arrGostIsland[i][j] == 2 && (arrGostIsland[i - 1][j] == 2 || arrGostIsland[i][j - 1] == 2 ||
                arrGostIsland[i + 1][j] == 2 || arrGostIsland[i][j + 1] == 2))
            return true;

        return false;
    }

    public static int removeCavity() {
        // ���� ��� ���������. ������ ��� ��� ����� ���������
        while (!heightExit.isEmpty()) {

            boolean allMinPassed = true; // ���� true, �� ������� �� heightExit

            int minEdge = searchMinInSet(heightExit);
            for (int i = 0; i < sizeN; i++) {
                for (int j = 0; j < sizeM; j++) {
                    // �� ����� ������� �������
                    if (i == 0 && j == 0)
                        j++;
                    if (i == 0 && j == sizeM - 1) {
                        i = 1;
                        j = 0;
                    }
                    if (i == sizeN - 1 && j == 0)
                        j++;
                    if (i == sizeN - 1 && j == sizeM - 1)
                        break;

                    // ������� ����������
                    if (arrIsland[i][j] == minEdge) {

                        // ������� ��� ���� ����� �� ������� �������)
                        if (areaRed(i, j)) {

                            allMinPassed = false;

                            searchCavity(i, j);
                        }
                    }
                }
            }
            if (allMinPassed)
                heightExit.remove(minEdge);
        }
        return water;
    }


    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // ������ ���������� ��������
        String firstLine = reader.readLine();
        if (firstLine.equals("")) {
            System.out.println("System.in - empty");
        }

        int numIslands = Integer.parseInt(firstLine);


        for (int island = 0; island < numIslands; island++) {

            // ������ ������ �������
            String[] sizeArray = reader.readLine().split("\\s+");
            int sizeArrayI = Integer.parseInt(sizeArray[0]);
            int sizeArrayJ = Integer.parseInt(sizeArray[1]);

            int[][] arrIslandIn = new int[sizeArrayI][sizeArrayJ];

            for (int i = 0; i < sizeArrayI; i++) {
                // String -> []int
                String[] arrayLine = reader.readLine().split("\\s+");
                int[] arrayInt = new int[arrayLine.length];
                for (int j = 0; j < arrayInt.length; j++)
                    arrayInt[j] = Integer.parseInt(arrayLine[j]);
                // ��������� ������� ������ �� �������
                arrIslandIn[i] = arrayInt;
            }

            Island.arrIsland = arrIslandIn;

            Island.water = 0; //������� ���������� ����
            Island.sizeN = arrIsland.length; // ���������� �����
            Island.sizeM = arrIsland[0].length; // ���������� ��������
            // ��������������� ������, �� ������� ������������ ����� � ����
            Island.arrGostIsland = new byte[sizeN][sizeM];
            // �������� ��� ������ ������ � ����
            heightExit = new HashSet<>();

            // ����������� ������ �������
            for (int j = 1; j < sizeM - 1; j++) {
                int i = 0;
                arrGostIsland[i][j] = 2;
                heightExit.add(arrIsland[i][j]);
                i = sizeN - 1;
                arrGostIsland[i][j] = 2;
                heightExit.add(arrIsland[i][j]);
            }

            for (int i = 1; i < sizeN - 1; i++) {
                int j = 0;
                arrGostIsland[i][j] = 2;
                heightExit.add(arrIsland[i][j]);
                j = sizeM - 1;
                arrGostIsland[i][j] = 2;
                heightExit.add(arrIsland[i][j]);
            }


            // ��� ��� � ����������

            System.out.println(removeCavity());

        /*
        System.out.println("Island");

        for (int i = 0; i < arrIsland.length; i++) {
            for (int j = 0; j < arrIsland[i].length; j++) {
                System.out.print(" " + arrIsland[i][j]);
            }
            System.out.println();
        }
        */
        /*
        System.out.println("GhostIsland");

        for (int i = 0; i < sizeN; i++) {
            for (int j = 0; j < sizeM; j++) {
                System.out.print(" " + arrGostIsland[i][j]);
            }
            System.out.println();
        }
        */

        }
    }
}
