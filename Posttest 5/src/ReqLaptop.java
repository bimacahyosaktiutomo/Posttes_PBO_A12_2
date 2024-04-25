import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ReqLaptop extends Laptop {
    private String user_req;

    public ReqLaptop() {

    }

    public ReqLaptop(String nama, String merek, String user_req) { // Constructor Overloading
        super(nama, merek,"", "");
        this.user_req = user_req;
    }

    static ArrayList<ReqLaptop> ListReq = new ArrayList<>();
    public ArrayList<ReqLaptop> getListReq() {
        return ListReq;
    }

    Scanner scanner = new Scanner(System.in);

    protected void display_req() throws Exception {
        Admin InstAdmin = new Admin();
        if (ListReq.isEmpty()) {
            System.out.println("=====================================");
            System.out.println("          Tidak ada request          ");
            System.out.println("=====================================");
            TimeUnit.SECONDS.sleep(1);
            InstAdmin.HomeAdmin();
        }
        for (int i = 0;i < ListReq.size();i++){
            ReqLaptop request = ListReq.get(i);
            System.out.println("=====================================");
            System.out.print(i+1 + ". " + request.nama + " | ");
            System.out.print(request.merek  + " | ");
            System.out.println(request.user_req + " | " );
            System.out.println("-------------------------------------");
        }
        System.out.println("=====================================");
        System.out.println("Tekan enter untuk kembali");
        scanner.nextLine();
        InstAdmin.HomeAdmin();
    }

    public String getUser_req() {
        return user_req;
    }

    public void setUser_req(String user_req) {
        this.user_req = user_req;
    }
}
