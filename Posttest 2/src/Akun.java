import java.util.ArrayList;

public class Akun {
    private String username;
    private String password;

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

    ArrayList<Akun> ListAkun = App.getListAkun();

    protected boolean cekAkun(String username,String password) {
        for (int i = 0;i < ListAkun.size();i++) {
            Akun akun = ListAkun.get(i);
            if (akun.getUsername().equals(username) && akun.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
