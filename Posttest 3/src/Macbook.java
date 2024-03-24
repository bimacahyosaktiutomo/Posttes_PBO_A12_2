import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Macbook extends Laptop{
    private String tahun = "";
    private String warna = "";
    private String chip = "";
    private String GPU = "";
    private String layar = "";
    private String RAM = "";

    static Scanner scanner = new Scanner(System.in);

    public Macbook(String nama, String harga, String stok) {
        super(nama, "Apple", harga, stok);
    }
    
    public void updateAtribut(String tahun, String warna, String chip, String gPU, String layar, String rAM) {
        this.tahun = tahun;
        this.warna = warna;
        this.chip = chip;
        this.GPU = gPU;
        this.layar = layar;
        this.RAM = rAM;
    }
    
    protected static void Tambah_Laptop() throws Exception {
        System.out.print("Masukan Nama : ");
        String nama = scanner.nextLine();
        System.out.print("Masukan Harga : ");
        String harga = scanner.nextLine();
        System.out.print("Masukan Stok : ");
        String stok = scanner.nextLine();
        App.ListLaptop.add(new Macbook(nama, harga, stok));
        System.out.println("Laptop berhasil ditambah");
        TimeUnit.SECONDS.sleep(1);
        App.Home();
    }

    protected static void Tambah_Spek(int index) throws Exception {
        String input;
        do {
            App.cls();
            Macbook UbahMacbook = (Macbook) App.ListLaptop.get(index);
            System.out.println("==================================");
            System.out.println("Nama    : " + UbahMacbook.nama);
            System.out.println("Merek   : " + UbahMacbook.merek);
            System.out.println("==================================");
            System.out.println("Pilih atribut yang ingin diubah :");
            System.out.println("1. Tahun : " + UbahMacbook.getTahun());
            System.out.println("2. Warna : " + UbahMacbook.getWarna());
            System.out.println("3. Chip  : " + UbahMacbook.getChip());
            System.out.println("4. GPU   : " + UbahMacbook.getGPU());
            System.out.println("5. RAM   : " + UbahMacbook.getRAM() + " GB");
            System.out.println("6. Layar : " + UbahMacbook.getLayar() + " inci") ;
            System.out.println("7. Ubah Semua");
            System.out.println("0. Kembali");
            System.out.println("==================================");
            System.out.print(">> ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Tahun Baru : ");
                    String Tahun = scanner.nextLine();
                    if (!Tahun.equals("batal")) {
                        UbahMacbook.setTahun(Tahun);
                    }
                    break;
                case "2":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Warna Baru : ");
                    String Warna = scanner.nextLine();
                    if (!Warna.equals("batal")) {
                        UbahMacbook.setWarna(Warna);
                    }
                    break;
                case "3":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Chip Baru : ");
                    String Chip = scanner.nextLine();
                    if (!Chip.equals("batal")) {
                        UbahMacbook.setChip(Chip);
                    }
                    break;
                case "4":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan GPU Baru : ");
                    String GPU = scanner.nextLine();
                    if (!GPU.equals("batal")) {
                        UbahMacbook.setGPU(GPU);
                    }
                    break;
                case "5":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan RAM Baru : ");
                    String RAM = scanner.nextLine();
                    if (!RAM.equals("batal")) {
                        UbahMacbook.setRAM(RAM);
                    }
                    break;
                case "6":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    System.out.print("Masukan Layar Baru : ");
                    String Layar = scanner.nextLine();
                    if (!Layar.equals("batal")) {
                        UbahMacbook.setLayar(Layar);
                    }
                    break;
                case "7":
                    System.out.println("Ketik 'batal' untuk membatalkan");
                    String[] atribut = { "Tahun", "Warna", "Chip", "GPU", "RAM", "Layar" };
                    String[] value = new String[6];
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
                        UbahMacbook.updateAtribut(value[0], value[1], value[2], value[3], value[4], value[5]);
                    }
                    break;
                default:
                    break;
            }
        } while (!input.equals("0"));
        App.Home();
    }

    protected static void display_info(int index) throws Exception {
        Macbook LihatLaptop = (Macbook) App.ListLaptop.get(index);
        System.out.println("=====================================");
        System.out.println("Nama  : " + LihatLaptop.nama);
        System.out.println("Merek : " + LihatLaptop.merek);
        System.out.println("Harga : Rp." + LihatLaptop.harga);
        System.out.println("Stok  : " + LihatLaptop.stok);
        System.out.println("=====================================");
        System.out.println("Tahun : " + LihatLaptop.getTahun());
        System.out.println("Warna : " + LihatLaptop.getWarna());
        System.out.println("Chip  : " + LihatLaptop.getChip());
        System.out.println("GPU   : " + LihatLaptop.getGPU());
        System.out.println("RAM   : " + LihatLaptop.getRAM() + " GB");
        System.out.println("Layar : " + LihatLaptop.getLayar() + " inci") ;
        System.out.println("=====================================");
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String gPU) {
        GPU = gPU;
    }

    public String getLayar() {
        return layar;
    }

    public void setLayar(String layar) {
        this.layar = layar;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String rAM) {
        RAM = rAM;
    }
}