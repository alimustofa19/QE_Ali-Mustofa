package OOP_Prio1_1;

public class ProductApp {
    public static void main(String[] args) {
        var product = new Product();
        System.out.println("INFO PRODUK");
        System.out.println("Nama : " + product.getNama());
        System.out.println("Deskripsi : " + product.getDeskripsi());
        System.out.println("Harga : " + product.getHarga());
        System.out.println("Jumlah Stok : " + product.getJmlStok());
        System.out.println("===");
        System.out.println("===");
        System.out.println("INFO PRODUK");
        System.out.println("Nama : " + product.getName());
        System.out.println("Deskripsi : " + product.getDescription());
        System.out.println("Harga : " + product.getPrice());
        System.out.println("Jumlah Stok : " + product.getAmmount());
    }
}
