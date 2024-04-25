import java.util.ArrayList;
import java.util.Scanner;

public abstract class Akun {
    private String username;
    private String password;

    protected abstract void Lihat_laptop(String user_req) throws Exception;

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

    public static boolean cekUsername(String username) {
        for (int i = 0;i < ListAkun.size();i++) {
            Akun akun = ListAkun.get(i);
            if (akun.getUsername().equals(username) ) {
                return false;
            }
        }
        return true;
    }
}
