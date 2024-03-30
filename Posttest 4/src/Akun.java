import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Akun {
    private String username;
    private String password;

    public Akun() {

    }

    public Akun(String username, String password) { // Constructor Overloading
        this.username = username;
        this.password = password;
    }

    static Scanner scanner = new Scanner(System.in);

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    static ArrayList<Akun> ListAkun = App.getListAkun();

    protected void Home(String user_req) throws Exception {
        App.cls();
        System.out.println("=========================");
        System.out.println("1. Lihat Laptop");
        System.out.println("2. Request Laptop");
        System.out.println("3. Request Laptop Anonim");
        System.out.println("0. Keluar");
        System.out.println("=========================");
        System.out.print("Pilih : ");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            Lihat_laptop(user_req);
        } else if (input.equals("2")) {
            Request(user_req);
        } else if (input.equals("3")) {
            Request();
            Home(user_req);
        } else if (input.equals("0")) {
            App.Lobby();
        } else {
            System.out.println("Invalid");
            TimeUnit.SECONDS.sleep(1);
            Home(user_req);
        }
    }

    protected void Lihat_laptop(String user_req) throws Exception {
        if (App.ListLaptop.isEmpty()) {
            System.out.println("Data Kosong");
            TimeUnit.SECONDS.sleep(1);
            Home(user_req);
        }
        while (true) {
            System.out.println("==========================");
            for (int i = 0; i < App.ListLaptop.size(); i++) {
                System.out.println(i + 1 + ". " + App.ListLaptop.get(i).nama);
            }
            System.out.println("==========================");
            System.out.println("Pilih laptop yang ingin di lihat : 0 Untuk Kembali");
            System.out.print(">> ");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if (index > 0 && index <= App.ListLaptop.size()) {
                    Spek InstSpek = new Spek();
                    Macbook InstMacbook = new Macbook();
                    if (App.ListLaptop.get(index-1) instanceof Spek) {
                        InstSpek.display_info(index-1);
                    }
                    else if (App.ListLaptop.get(index-1) instanceof Macbook) {
                        InstMacbook.display_info(index-1);
                    }
                    System.out.println("Tekan enter untuk kembali");
                    scanner.nextLine();
                    Home(user_req);
                } else if (index == 0) {
                    Home(user_req);
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

    protected static void Register() throws Exception {
        System.out.print("Masukan Username : ");
        String username = scanner.nextLine();
    
        if (username == null || username.isEmpty() || !cekUsername(username)) {
            System.out.println("Gunakan Username lain!!!");
            TimeUnit.SECONDS.sleep(1);
            Register();
        } else if (username.equals("batal")) {
            App.Lobby();
        }
        String password;
        while (true) {
            System.out.print("Masukan Password : ");
            password = scanner.nextLine();
            if (password == null || password.isEmpty()) {
                System.out.println("Password tidak boleh kosong!!!");
                TimeUnit.SECONDS.sleep(1);
            } else if (password.equals("batal")) {
                App.Lobby();
            }else {
                break;
            }
        }
        ListAkun.add(new Akun(username, password));
        System.out.println("Register Berhasil");
        TimeUnit.SECONDS.sleep(1);
        App.Lobby();
    }
    
    protected void Request(String user_req) throws Exception {
        System.out.println("Ketik 'batal' untuk membatalkan");
        System.out.print("Masukan Nama : ");
        String nama = scanner.nextLine();
        if (nama.equals("batal")){
            Home(user_req);
        }
        System.out.print("Masukan Merek : ");
        String merek = scanner.nextLine();
        if (merek.equals("batal")){
            Home(user_req);
        }
        ReqLaptop.ListReq.add(new ReqLaptop(nama,merek, user_req));
        System.out.println("Request berhasil ditambah");
        TimeUnit.SECONDS.sleep(1);
        Home(user_req);
    }
    
    protected void Request() throws Exception { // Overloading
        System.out.println("Ketik 'batal' untuk membatalkan");
        System.out.print("Masukan Nama : ");
        String nama = scanner.nextLine();
        if (nama.equals("batal")){
            return;
        }
        System.out.print("Masukan Merek : ");
        String merek = scanner.nextLine();
        if (merek.equals("batal")){
            return;
        }
        ReqLaptop.ListReq.add(new ReqLaptop(nama,merek, "Anonymous"));
        System.out.println("Request berhasil ditambah");
        TimeUnit.SECONDS.sleep(1);
        return;
    }

    private static boolean cekUsername(String username) {
        for (int i = 0;i < ListAkun.size();i++) {
            Akun akun = ListAkun.get(i);
            if (akun.getUsername().equals(username) ) {
                return false;
            }
        }
        return true;
    }
}
