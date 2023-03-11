package OOP_Prio2_1;
import  java.util.*;
public class Kalkulator {
    public static void main(String[] args) {
        char operator;
        Double angka1, angka2, hasil;

        // Untuk Membuat input dari user
        Scanner input = new Scanner(System.in);
        System.out.println("angka pertama");
        angka1 = input.nextDouble();

        System.out.println("Pilih Operasi : +, -, *, or /");
        operator = input.next().charAt(0);

        System.out.println("angka kedua");
        angka2 = input.nextDouble();

        switch (operator) {

            // Untuk penjumlahan
            case '+':
                hasil = angka1 + angka2;
                System.out.println("Penjumlahan");
                System.out.println(angka1 + " + " + angka2 + " = " + hasil);
                break;
            // Untuk Pengurangan
            case '-':
                hasil = angka1 - angka2;
                System.out.println("Pengurangan");
                System.out.println(angka1 + " - " + angka2 + " = " + hasil);
                break;
            // Untuk Perkalian
            case '*':
                hasil = angka1 * angka2;
                System.out.println("Perkalian");
                System.out.println(angka1 + " * " + angka2 + " = " + hasil);
                break;
            // Untuk Pembagian
            case '/':
                hasil = angka1 / angka2;
                System.out.println("Pembagian");
                System.out.println(angka1 + " / " + angka2 + " = " + hasil);
                break;
            default:
                System.out.println("Invalid operator!");
                break;
        }
        input.close();
    }
}