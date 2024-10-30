// AutoCarRPL.java
public class AutoCarRPL implements Transportasi {
    private String bahanBakar;
    private int kecepatan;
    private Roda[] roda;
    private Setir setir;
    private Mesin mesin;

    // Constructor
    public AutoCarRPL(String bahanBakar, int kecepatan) {
        this.bahanBakar = bahanBakar;
        this.kecepatan = kecepatan;
        this.roda = new Roda[4]; // 4 wheels
        for (int i = 0; i < 4; i++) {
            this.roda[i] = new Roda();
        }
        this.setir = new Setir();
        this.mesin = new Mesin();
    }

    // Implementing interface methods
    @Override
    public void bahanBakar() {
        System.out.println("Bahan bakar yang digunakan: " + bahanBakar);
    }

    @Override
    public int kecepatan() {
        return kecepatan;
    }

    // Methods in AutoCarRPL
    public void start() {
        System.out.println("Mobil mulai...");
        mesin.startMesin();
    }

    public void drive() {
        System.out.println("Mobil bergerak dengan kecepatan " + kecepatan + " km/h");
    }
}
