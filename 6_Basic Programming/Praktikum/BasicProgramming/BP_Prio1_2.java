package BasicProgramming;

import java.util.Scanner;

public class BP_Prio1_2 {
    public static void main(String[] args) {

        int hargaBeli;
        int hargaJual;

        // TODO: cek apakah hasil penjualan mengalami keuntungan / kerugian
        Scanner scanner = new Scanner(System.in);
        System.out.println("Keuntungan dan Kerugian Dari Penjulan");
        System.out.print("Harga Beli : ");
        hargaBeli = scanner.nextInt();
        System.out.print("Harga Jual : ");
        hargaJual = scanner.nextInt();
        int keuntungan = hargaJual - hargaBeli;

        System.out.println("===========");
        System.out.println("Laba, rugi yang didapat dari penjualan adalah : "+ keuntungan);
    }
}
