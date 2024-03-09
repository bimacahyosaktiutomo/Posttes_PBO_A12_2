import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    static ArrayList<Laptop> ListLaptop = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Home();
    }

    static Scanner scanner = new Scanner(System.in);
    static void Home() throws Exception {
        cls();
        System.out.println("=========================");
        System.out.println("1. Tambah Laptop");
        System.out.println("2. Hapus Laptop");
        System.out.println("3. Ubah Laptop");
        System.out.println("4. Lihat Laptop");
        System.out.println("0. Keluar");
        System.out.println("=========================");
        System.out.print("Pilih : ");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            Tambah_Laptop();
        }
        else if (input.equals("2")) {
            Hapus_Laptop();
        }
        else if (input.equals("3")) {
            if (ListLaptop.isEmpty()) {
                System.out.println("Data Kosong");
                TimeUnit.SECONDS.sleep(1);
                Home();
            }
            while (true) {
                System.out.println("==============================================");
                for (int i = 0;i < ListLaptop.size();i++){
                    System.out.println(i+1 + ". " + ListLaptop.get(i).nama);
                }
                System.out.println("==============================================");
                System.out.println("Pilih laptop yang ingin di ubah : 0 Untuk Kembali");
                System.out.print("> > ");
                try {                    
                    int index = Integer.parseInt(scanner.nextLine());
                    if (index > 0 && index <= ListLaptop.size()) {
                        Ubah_Laptop(index-1);
                    } else if(index == 0) {
                        break;
                    }else {
                        System.out.println("Data tidak tersedia");
                        TimeUnit.SECONDS.sleep(1);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
            Home();
        }
        else if (input.equals("4")) {
            if (ListLaptop.isEmpty()) {
                System.out.println("Data Kosong");
                TimeUnit.SECONDS.sleep(1);
                Home();
            }
            while (true) {
                System.out.println("==========================");
                for (int i = 0;i < ListLaptop.size();i++){
                    System.out.println(i+1+". "+ ListLaptop.get(i).nama);
                }
                System.out.println("==========================");
                System.out.println("Pilih laptop yang ingin di lihat : 0 Untuk Kembali");
                System.out.print("> > ");
                try {                    
                    int index = Integer.parseInt(scanner.nextLine());
                    if (index > 0 && index <= ListLaptop.size()) {
                        Lihat_laptop(index-1);
                    } else if(index == 0) {
                        break;
                    }else {
                        System.out.println("Data tidak tersedia");
                        TimeUnit.SECONDS.sleep(1);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
            Home();
        }
        else if (input.equals("0")) {
            scanner.close();
            System.exit(0);
        }
        else {
            System.out.println("Invalid");
            TimeUnit.SECONDS.sleep(1);
            Home();
        }
    }

    static void Tambah_Laptop() throws Exception {
        System.out.print("Masukan Nama : ");
        String nama = scanner.nextLine();
        System.out.print("Masukan Merek : ");
        String merek = scanner.nextLine();
        System.out.print("Masukan Harga : ");
        String harga = scanner.nextLine();
        System.out.print("Masukan Stok : ");
        String stok = scanner.nextLine();
        ListLaptop.add(new Laptop(nama, merek, harga, stok));
        System.out.println("Laptop berhasil ditambah");
        TimeUnit.SECONDS.sleep(1);
        Home();
    }

    static void Hapus_Laptop() throws Exception {
        if (ListLaptop.isEmpty()) {
            System.out.println("Data Kosong");
            Home();
        }
        while (true) {
            System.out.println("==============================================");
            for (int i = 0;i < ListLaptop.size();i++){
                System.out.println(i+1 + ". " + ListLaptop.get(i).nama);
            }
            System.out.println("==============================================");
            System.out.println("Masukan Laptop yang ingin dihapus : 0 Untuk Kembali");
            System.out.print("> > ");
            try {                
                int index = Integer.parseInt(scanner.nextLine());
                if (index > 0 && index <= ListLaptop.size()) {
                    ListLaptop.remove(index-1);
                    System.out.println("Laptop berhasil dihapus");
                    TimeUnit.SECONDS.sleep(1);
                    Home();
                } else if(index == 0) {
                    Home();
                }else {
                    System.out.println("Data tidak tersedia");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

    static void Ubah_Laptop(int index) throws Exception {
        String input;
        do {
            cls();
            System.out.println("Pilih atribut yang ingin diubah :");
            System.out.println("1. Nama    : " + ListLaptop.get(index).nama);
            System.out.println("2. Merek   : " + ListLaptop.get(index).merek);
            System.out.println("3. Harga   : " + ListLaptop.get(index).harga);
            System.out.println("4. Stok    : " + ListLaptop.get(index).stok);
            System.out.println("5. Ubah Semua");
            System.out.println("0. Kembali");
            System.out.println("==================================");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Nama Baru : ");
                    String nama = scanner.nextLine();
                    if (nama.equals("batal")){
                        break;
                    }
                    Laptop NewLaptop = new Laptop(nama, ListLaptop.get(index).merek, ListLaptop.get(index).harga, ListLaptop.get(index).stok);
                    ListLaptop.set(index, NewLaptop);
                    break;
                case "2":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Merek Baru : ");
                    String merek = scanner.nextLine();
                    if (merek.equals("batal")){
                        break;
                    }
                    NewLaptop = new Laptop( ListLaptop.get(index).harga,merek, ListLaptop.get(index).harga, ListLaptop.get(index).stok);
                    ListLaptop.set(index, NewLaptop);
                    break;
                case "3":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Harga Baru : ");
                    String harga = scanner.nextLine();
                    if (harga.equals("batal")){
                        break;
                    }
                    NewLaptop = new Laptop( ListLaptop.get(index).harga,ListLaptop.get(index).merek, harga, ListLaptop.get(index).stok);
                    ListLaptop.set(index, NewLaptop);
                    break;
                case "4":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Stok Baru : ");
                    String stok = scanner.nextLine();
                    if (stok.equals("batal")){
                        break;
                    }
                    NewLaptop = new Laptop( ListLaptop.get(index).harga,ListLaptop.get(index).merek, ListLaptop.get(index).harga, stok);
                    ListLaptop.set(index, NewLaptop);
                    break;
                case "5":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Nama Baru : ");
                    nama = scanner.nextLine();
                    if (nama.equals("batal")){
                        break;
                    }
                    System.out.print("Masukan Merek Baru : ");
                    merek = scanner.nextLine();
                    if (merek.equals("batal")){
                        break;
                    }
                    System.out.print("Masukan Harga Baru : ");
                    harga = scanner.nextLine();
                    if (harga.equals("batal")){
                        break;
                    }
                    System.out.print("Masukan Stok Baru : ");
                    stok = scanner.nextLine();
                    if (stok.equals("batal")){
                        break;
                    }
                    NewLaptop = new Laptop(nama, merek, harga, stok);
                    ListLaptop.set(index, NewLaptop);
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        } while (!input.equals("0"));
        Home();
    }

    static void Lihat_laptop(int index) throws Exception {
        System.out.println("=====================================");
        System.out.println("Nama  : " + ListLaptop.get(index).nama);
        System.out.println("Merek : " + ListLaptop.get(index).merek);
        System.out.println("Harga : " + ListLaptop.get(index).harga);
        System.out.println("Stok  : " + ListLaptop.get(index).stok);
        System.out.println("=====================================");
        System.out.println("Tekan enter untuk kembali");
        scanner.nextLine();
        Home();
    }

    static void cls(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
