class Human{
    String nama;
    String warnaRambut;
    String warnaKulit;
    int Umur;

    public void berjalan(){
        System.out.println(nama + " Sedang berjalan dengan santai.");
    }

    public boolean isDead(){
        if (Umur >= 100){
            System.out.println("Tua");
            return true;
        } else{
            System.out.println("Muda");
            return false;
        }
    }

    int tampilkanUmur(){
        return Umur;
    }

    void tampilkanCiri(){
        System.out.println("Nama : " + nama);
        System.out.println("Warna Kulit : " + warnaKulit);
        System.out.println("Warna Rambut " + warnaRambut);
        System.out.println("Umur : " + tampilkanUmur());
    }
}

public class Main1 {
    public static void main(String[] args) {
        Human Manusia1 = new Human();
        Human Manusia2 = new Human();

        Manusia1.nama = "Gerrard";
        Manusia1.warnaKulit = "Putih Bening";
        Manusia1.warnaRambut = "Hitam";
        Manusia1.Umur = 18;

        Manusia2.nama = "Ferry";
        Manusia2.warnaRambut = "Hitam";
        Manusia2.warnaKulit = "Sawo Matang";
        Manusia2.Umur = 101;

        Manusia1.tampilkanCiri();
        Manusia2.tampilkanCiri();

        Manusia1.berjalan();
        Manusia2.berjalan();

        Manusia1.isDead();
        Manusia2.isDead();
    }
}
