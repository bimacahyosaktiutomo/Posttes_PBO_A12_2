import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    static ArrayList<Laptop> ListLaptop = new ArrayList<>();
    public static ArrayList<Laptop> getListLaptop() {
        return ListLaptop;
    }

    static ArrayList<Akun> ListAkun = new ArrayList<>();
    public static ArrayList<Akun> getListAkun() {
        return ListAkun;
    }

    public static void main(String[] args) throws Exception {
        ListAkun.add(new Admin("admin", "admin", "admin"));
        Lobby();
    }

    static Scanner scanner = new Scanner(System.in);

    protected static void Lobby() throws Exception {
        String input;
        do {
            cls();
            System.out.println("===============");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Keluar");
            System.out.println("===============");
            System.out.print(">> ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    Login();
                    break;
                case "2":
                    Akun.Register();
                    break;
                default:
                    break;
            }
        } while (!input.equals("0"));
        scanner.close();
        System.exit(0);
    }

    private static void Login() throws Exception {
        System.out.print("Masukan Username >> ");
        String username = scanner.nextLine();
        System.out.print("Masukan Password >> ");
        String password = scanner.nextLine();

        for (int i = 0;i < ListAkun.size();i++) {
            Akun akun = ListAkun.get(i);
            if (akun.getUsername().equals(username) && akun.getPassword().equals(password)) {
                if (akun instanceof Admin) {
                    Home();
                }else {
                    Akun.Home(username);
                }
            }
        }

        System.out.println("Username atau Password salah!!!");
        TimeUnit.SECONDS.sleep(1);
    }

    protected static void Home() throws Exception {
        cls();
        System.out.println("=========================");
        System.out.println("1. Tambah Laptop");
        System.out.println("2. Hapus Laptop");
        System.out.println("3. Ubah Laptop");
        System.out.println("4. Lihat Laptop");
        System.out.println("5. Tambah Spesifikasi");
        System.out.println("6. Lihat Request");
        System.out.println("0. Keluar");
        System.out.println("=========================");
        System.out.print("Pilih : ");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            Tambah_Laptop();
        } else if (input.equals("2")) {
            Hapus_Laptop();
        } else if (input.equals("3")) {
            Pilih_Laptop(1);
        } else if (input.equals("4")) {
            Lihat_laptop();
        } else if (input.equals("5")) {
            Pilih_Laptop(2);
        } else if (input.equals("6")) {
            ReqLaptop.display_info();
        } else if (input.equals("0")) {
            Lobby();
        } else {
            System.out.println("Invalid");
            TimeUnit.SECONDS.sleep(1);
            Home();
        }
    }

    private static void Tambah_Laptop() throws Exception {
        cls();
        System.out.println("=========================");
        System.out.println("1. Windows");
        System.out.println("2. Macbook");
        System.out.println("0. Keluar");
        System.out.println("=========================");
        System.out.print("Pilih : ");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            Spek.Tambah_Laptop();
        } else if (input.equals("2")) {
            Macbook.Tambah_Laptop();
        } else if (input.equals("0")) {
            Home();
        } else {
            System.out.println("Invalid");
            TimeUnit.SECONDS.sleep(1);
            Tambah_Laptop();
        }
    }

    private static void Hapus_Laptop() throws Exception {
        if (ListLaptop.isEmpty()) {
            System.out.println("Data Kosong");
            TimeUnit.SECONDS.sleep(1);
            Home();
        }
        while (true) {
            System.out.println("==============================================");
            for (int i = 0; i < ListLaptop.size(); i++) {
                System.out.println(i + 1 + ". " + ListLaptop.get(i).nama);
            }
            System.out.println("==============================================");
            System.out.println("Masukan Laptop yang ingin dihapus : 0 Untuk Kembali");
            System.out.print("> > ");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if (index > 0 && index <= ListLaptop.size()) {
                    ListLaptop.remove(index - 1);
                    System.out.println("Laptop berhasil dihapus");
                    TimeUnit.SECONDS.sleep(1);
                    Home();
                } else if (index == 0) {
                    Home();
                } else {
                    System.out.println("Data tidak tersedia");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

    private static void Ubah_Laptop(int index) throws Exception {
        String input;
        do {
            cls();
            Laptop UbahLaptop = ListLaptop.get(index);
            System.out.println("==================================");
            System.out.println("Pilih atribut yang ingin diubah :");
            System.out.println("1. Nama    : " + ListLaptop.get(index).nama);
            System.out.println("2. Merek   : " + ListLaptop.get(index).merek);
            System.out.println("3. Harga   : Rp." + ListLaptop.get(index).harga);
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
                    if (nama.equals("batal")) {
                        break;
                    }
                    UbahLaptop.nama = nama;
                    break;
                case "2":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Merek Baru : ");
                    String merek = scanner.nextLine();
                    if (merek.equals("batal")) {
                        break;
                    }
                    UbahLaptop.merek = merek;
                    break;
                case "3":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Harga Baru : ");
                    String harga = scanner.nextLine();
                    if (harga.equals("batal")) {
                        break;
                    }
                    UbahLaptop.harga = harga;
                    break;
                case "4":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Stok Baru : ");
                    String stok = scanner.nextLine();
                    if (stok.equals("batal")) {
                        break;
                    }
                    UbahLaptop.stok = stok;
                    break;
                case "5":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    String[] atribut = { "Nama", "Merek", "Harga", "Stok" };
                    String[] value = new String[4];
                    boolean batal = false;
                    for (int i = 0; i < atribut.length; i++) {
                        System.out.print("Masukan " + atribut[i] + " Baru : ");
                        value[i] = scanner.nextLine();
                        if (value[i].equals("batal")) {
                            batal = true;
                            break;
                        }
                    }
                    if (!batal) {
                        if (UbahLaptop instanceof Spek) {
                            Spek newSpek = (Spek) UbahLaptop;
                            newSpek.nama = value[0];
                            newSpek.merek = value[1];
                            newSpek.harga = value[2];
                            newSpek.stok = value[3];
                        } else if (UbahLaptop instanceof Macbook) {
                            Macbook newMacbook = (Macbook) UbahLaptop;
                            newMacbook.nama = value[0];
                            newMacbook.merek = value[1];
                            newMacbook.harga = value[2];
                            newMacbook.stok = value[3];
                        }
                    }
                    break;
                default:
                    break;
            }
        } while (!input.equals("0"));
        Home();
    }

    protected static void Lihat_laptop() throws Exception {
        if (ListLaptop.isEmpty()) {
            System.out.println("Data Kosong");
            TimeUnit.SECONDS.sleep(1);
            Home();
        }
        while (true) {
            System.out.println("==========================");
            for (int i = 0; i < ListLaptop.size(); i++) {
                System.out.println(i + 1 + ". " + ListLaptop.get(i).nama);
            }
            System.out.println("==========================");
            System.out.println("Pilih laptop yang ingin di lihat : 0 Untuk Kembali");
            System.out.print(">> ");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if (index > 0 && index <= ListLaptop.size()) {
                    if (ListLaptop.get(index-1) instanceof Spek) {
                        Spek.display_info(index-1);
                    }
                    else if (ListLaptop.get(index-1) instanceof Macbook) {
                        Macbook.display_info(index-1);
                    }
                    System.out.println("Tekan enter untuk kembali");
                    scanner.nextLine();
                    Home();
                } else if (index == 0) {
                    Home();
                } else {
                    System.out.println("Data tidak tersedia");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

    private static void Tambah_Spek(int index) throws Exception {
        if (ListLaptop.get(index) instanceof Spek) {
            Spek.Tambah_Spek(index);
        }
        else if (ListLaptop.get(index) instanceof Macbook) {
            Macbook.Tambah_Spek(index);
        }
    }

    private static void Pilih_Laptop(int code) throws Exception {
        if (ListLaptop.isEmpty()) {
            System.out.println("Data Kosong");
            TimeUnit.SECONDS.sleep(1);
            Home();
        }
        while (true) {
            System.out.println("==============================================");
            for (int i = 0; i < ListLaptop.size(); i++) {
                System.out.println(i + 1 + ". " + ListLaptop.get(i).nama);
            }
            System.out.println("==============================================");
            System.out.println("Pilih laptop yang ingin di ubah : 0 Untuk Kembali");
            System.out.print("> > ");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if (index > 0 && index <= ListLaptop.size()) {
                    if (code == 1) {
                        Ubah_Laptop(index - 1);
                    } else if (code == 2) {
                        Tambah_Spek(index - 1);
                    }
                } else if (index == 0) {
                    break;
                } else {
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

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
