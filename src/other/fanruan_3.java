package other;

import java.util.Arrays;

public class fanruan_3 {
    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1, 2, -1},
                {2, 1, -1}
        };
        int[][] b = new int[][] {
                {1, 2},
                {-1, 3},
                {1, 1}
        };
        int[][] r = fun(a, b);
        for (int[] i : r) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] fun(int[][] a, int[][] b) {
        if (a[0].length != b.length) return  null;
        int m = a.length, n = a[0].length, p = b[0].length;
        int[][] result = new int[m][p];
        int temp;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                temp = 0;
                for(int k = 0; k < n; k++) {
                    temp += a[i][k] * b[k][j];
                }
                result[i][j] = temp;
            }
        }
        return result;
    }
}
