package BasicProgramming;

import java.util.*;
public class BP_Prio2_1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan Jumlah Kelipatan: ");
        int n = in.nextInt();

        if (n < 1 || n > 10) {
            System.out.println("Masukkan Jumlah Kurang dari 10 !");
            return;
        }
        char bp1 = 'X', bp2 = 'Y', bp3= 'Z';
        char m[][] = new char[n][n];
        char x = bp2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || (i + j) == n - 1) {
                    m[i][j] = bp3;
                }
                else if (i == 0 || i == n - 1) {
                    m[i][j] = bp1;
                }
                else if (j == 0 || j == n - 1 || i % 2 == 0) {
                    m[i][j] = bp2;
                }
                else {
                    m[i][j] = bp1;
                }
            }
        }
        System.out.println("Hasil:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
}