import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Laptop {
    protected String nama;
    protected String merek;
    protected String harga;
    protected String stok;

    public Laptop() {

    }

    public Laptop(String nama,String merek,String harga, String stok){ // Constructor Overloading
        this.nama = nama;
        this.merek = merek;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    static ArrayList<Laptop> ListLaptop = App.getListLaptop();
    static Scanner scanner = new Scanner(System.in);

        protected void Tambah_Laptop() throws Exception {
        System.out.print("Masukan Nama : ");
        String nama = scanner.nextLine();
        System.out.print("Masukan Merek : ");
        String merek = scanner.nextLine();
        System.out.print("Masukan Harga : ");
        String harga = scanner.nextLine();
        System.out.print("Masukan Stok : ");
        String stok = scanner.nextLine();
        App.ListLaptop.add(new Spek(nama, merek, harga, stok));
        System.out.println("Laptop berhasil ditambah");
        TimeUnit.SECONDS.sleep(1);
        Admin InstAdmin = new Admin();
        InstAdmin.HomeAdmin();
    }
    
    protected void Tambah_Laptop(String buah) throws Exception { // Overload
        System.out.print("Masukan Nama : ");
        String nama = scanner.nextLine();
        System.out.print("Masukan Harga : ");
        String harga = scanner.nextLine();
        System.out.print("Masukan Stok : ");
        String stok = scanner.nextLine();
        App.ListLaptop.add(new Macbook(nama, harga, stok, buah));
        System.out.println("Laptop berhasil ditambah");
        TimeUnit.SECONDS.sleep(1);
        Admin InstAdmin = new Admin();
        InstAdmin.HomeAdmin();;
    }

    protected void display_info(int index) throws Exception {
        System.out.println("1. Nama    : " + ListLaptop.get(index).nama);
        System.out.println("2. Merek   : " + ListLaptop.get(index).merek);
        System.out.println("3. Harga   : Rp." + ListLaptop.get(index).harga);
        System.out.println("4. Stok    : " + ListLaptop.get(index).stok);
    }

    protected void Tambah_Spek(int index) throws Exception {
        Spek InstSpek = new Spek();
        Macbook InstMacbook = new Macbook();
        if (ListLaptop.get(index) instanceof Spek) {
            InstSpek.Tambah_Spek(index);
        }
        else if (ListLaptop.get(index) instanceof Macbook) {
            InstMacbook.Tambah_Spek(index);
        }
    }
}
