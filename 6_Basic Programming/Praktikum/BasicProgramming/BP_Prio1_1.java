package BasicProgramming;
public class BP_Prio1_1 {
    public static void main(String[] args) {
        // segitiga
        float alas = 20;
        float tinggi = 25;

        // TODO: hitung luas segitiga
        double luasSegitiga = 0.5 * alas * tinggi;
        System.out.println("Luas Segitiga Adalah : "+luasSegitiga);

        // persegi panjang
        float panjang = 40;
        float lebar = 6;

        //TODO: hitung luas persegi panjang
        double luasPersegipanjang = panjang * lebar;
        System.out.println("Luas Persegi Panjang Adalah : "+luasPersegipanjang);

        // lingkaran
        double jari2 = 7;

        //TODO: hitung luas lingkaran
        double luasLingkaran = 3.14 * jari2 * jari2;
        System.out.println("Luas Lingkaran Adalah : "+luasLingkaran);
    }
}
