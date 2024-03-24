import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Spek extends Laptop{
    private String RAM = "";
    private String CPU = "";
    private String GPU1 = "";
    private String GPU2 = "";

    static Scanner scanner = new Scanner(System.in);

    public Spek(String nama, String merek, String harga, String stok) {
        super(nama, merek, harga, stok);
    }

    public void updateAtribut(String CPU, String RAM,  String GPU1, String GPU2) {
        this.RAM = RAM;
        this.CPU = CPU;
        this.GPU1 = GPU1;
        this.GPU2 = GPU2;
    }
    
    protected static void Tambah_Laptop() throws Exception {
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
        App.Home();
    }

    protected static void Tambah_Spek(int index) throws Exception {
        String input;
        do {
            App.cls();
            Spek UbahSpek = (Spek) App.ListLaptop.get(index);
            System.out.println("==================================");
            System.out.println("Nama    : " + UbahSpek.nama);
            System.out.println("Merek   : " + UbahSpek.merek);
            System.out.println("==================================");
            System.out.println("Pilih atribut yang ingin diubah :");
            System.out.println("1. CPU     : " + UbahSpek.getCPU());
            System.out.println("2. RAM     : " + UbahSpek.getRAM() + " GB");
            System.out.println("3. GPU1    : " + UbahSpek.getGPU1());
            System.out.println("4. GPU2    : " + UbahSpek.getGPU2());
            System.out.println("5. Ubah Semua");
            System.out.println("0. Kembali");
            System.out.println("==================================");
            System.out.print(">> ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan CPU Baru : ");
                    String CPU = scanner.nextLine();
                    if (!CPU.equals("batal")) {
                        UbahSpek.setCPU(CPU);
                    }
                    break;
                case "2":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan RAM Baru : ");
                    String RAM = scanner.nextLine();
                    if (!RAM.equals("batal")) {
                        UbahSpek.setRAM(RAM);
                    }
                    break;
                case "3":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan GPU1 Baru : ");
                    String GPU1 = scanner.nextLine();
                    if (!GPU1.equals("batal")) {
                        UbahSpek.setGPU1(GPU1);
                    }
                    break;
                case "4":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan GPU2 Baru : ");
                    String GPU2 = scanner.nextLine();
                    if (!GPU2.equals("batal")) {
                        UbahSpek.setGPU2(GPU2);
                    }
                    break;
                case "5":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    String[] atribut = { "CPU", "RAM", "GPU1", "GPU2" };
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
                        UbahSpek.updateAtribut(value[0], value[1], value[2], value[3]);
                    }
                    break;
                default:
                    break;
            }
        } while (!input.equals("0"));
        App.Home();
    }

    protected static void display_info(int index) throws Exception {
        Spek LihatLaptop = (Spek) App.ListLaptop.get(index);
        System.out.println("=====================================");
        System.out.println("Nama  : " + LihatLaptop.nama);
        System.out.println("Merek : " + LihatLaptop.merek);
        System.out.println("Harga : Rp." + LihatLaptop.harga);
        System.out.println("Stok  : " + LihatLaptop.stok);
        System.out.println("=====================================");
        System.out.println("CPU   : " + LihatLaptop.getCPU());
        System.out.println("RAM   : " + LihatLaptop.getRAM() + " GB");
        System.out.println("GPU1  : " + LihatLaptop.getGPU1());
        System.out.println("GPU2  : " + LihatLaptop.getGPU2());
        System.out.println("=====================================");
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String rAM) {
        RAM = rAM;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String cPU) {
        CPU = cPU;
    }

    public String getGPU1() {
        return GPU1;
    }

    public void setGPU1(String gPU1) {
        GPU1 = gPU1;
    }

    public String getGPU2() {
        return GPU2;
    }

    public void setGPU2(String gPU2) {
        GPU2 = gPU2;
    }
}
