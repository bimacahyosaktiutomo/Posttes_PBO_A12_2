import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ReqLaptop extends Laptop {
    private String user_req;

    public ReqLaptop(String nama, String merek, String user_req) {
        super(nama, merek,"", "");
        this.user_req = user_req;
    }

    static ArrayList<ReqLaptop> ListReq = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    protected static void display_info() throws Exception {
        if (ListReq.isEmpty()) {
            System.out.println("=====================================");
            System.out.println("          Tidak ada request          ");
            System.out.println("=====================================");
            TimeUnit.SECONDS.sleep(1);
            App.Home();
        }
        for (int i = 0;i < ListReq.size();i++){
            ReqLaptop request = ListReq.get(i);
            System.out.println("=====================================");
            System.out.println(i + ". Nama  : " + request.nama);
            System.out.println("  Merek : " + request.merek);
            System.out.println("-------------------------------------");
        }
        System.out.println("=====================================");
        System.out.println("Tekan enter untuk kembali");
        scanner.nextLine();
        App.Home();
    }

    public String getUser_req() {
        return user_req;
    }

    public void setUser_req(String user_req) {
        this.user_req = user_req;
    }
}
