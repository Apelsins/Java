package lvl5;

import java.util.Scanner;

/**
 * Created by ATarasevich on 27.04.2017.
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {

        // матрица смежности и путь, который нужно получить
        int[][] matrix;
        int resultOut;
        int resultIn;

        try (Scanner scanner = new Scanner(System.in)) {
            // количество вершин и ребер графа
            String s = "";
            int width = 0;
            int count = 0;
            if (scanner.hasNextLine()) {
                width = scanner.nextInt() - 1;
                count = scanner.nextInt() - 1;
            }

            matrix = new int[width+1][width+1];

            // заполенние матрицы
            // -1 - чтобы проще было работать с матрицей
            for (; count >= 0; count--) {
                int out = scanner.nextInt() - 1;
                int in = scanner.nextInt() - 1;
                int weight = scanner.nextInt();
                matrix[out][in] = weight;
            }

            resultOut = scanner.nextInt() - 1;
            resultIn = scanner.nextInt() - 1;

        }

        int minWay = searchShortestWay(matrix, resultOut, resultIn);

        System.out.println(minWay != 0 ? minWay : -1);

        // printMatrix(matrix);
        // System.out.println(resultOut);
        // System.out.println(resultIn);
    }

    public static int searchShortestWay (int[][] matrix, int out, int in) {
        int maxInt = Integer.MAX_VALUE / 2;
        // количество вершин
        int countTops = matrix.length;
        // минимальнйы вес до каждой вершины
        int[] d = new int[countTops];
        // посещенные вершины
        boolean[] q = new boolean[countTops];
        // Расстояние до всех вершин бесконечность (почти)
        for (int i = 0; i < d.length; i++) {
            d[i] = maxInt;
        }

        printMatrix(matrix);

        // от этой вершины нужно узнать расстояние
        d[out] = 0;

        for (;;) {

            // свободная вершина
            int v = -1;

            for (int i = 0; i < countTops; i++) {
                // если верщина еще не бралась
                if (!q[i] && d[i] < maxInt && (v == -1 || d[v] > d[i]))
                    v = i;
            }

            // если вершина не найдена
            if (v == -1) break;

            // помечаем
            q[v] = true;

            for (int i = 0; i < countTops; i++) {
                if (!q[i] && matrix[v][i] < maxInt)  // для всех непомеченных смежных
                    d[i] = min(d[i], d[v] + matrix[v][i]);
            }
        }

        return d[in];

    }

    public static int min (int x, int y) {
        return x <= y ? x : y;
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
