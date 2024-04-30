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
                    User.Register();
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
                    Admin IntsnceAdmin = new Admin();
                    IntsnceAdmin.HomeAdmin();
                }else {
                    User InstanceAkun = new User();
                    InstanceAkun.Home(username);
                }
            }
        }

        System.out.println("Username atau Password salah!!!");
        TimeUnit.SECONDS.sleep(1);
    }

    public static final void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
