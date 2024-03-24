public class Admin extends Akun {
    private String permision;

    public Admin(String permision, String username, String password) {
        super(username, password);
        this.permision = permision;
    }

    public String getPermision() {
        return permision;
    }

    public void setPermision(String permision) {
        this.permision = permision;
    }
}
