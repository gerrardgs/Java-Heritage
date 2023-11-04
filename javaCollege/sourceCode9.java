public class Menu{
    public String namaMakanan;
    public int harga;

    public Menu(String namaMakanan, int harga) {
        this.namaMakanan = namaMakanan;
        this.harga = harga;
    }

    public void invoice() {
        System.out.println("- Nama Makanan = " + namaMakanan);
        System.out.println("- Harga = " + harga + " IDR");
    }

    //Overloading
    public void invoice(String infoTambahan) {
        invoice();
        System.out.println("- Informasi Tambahan = " + infoTambahan);
    }
}

public class Makanan extends Menu{
    public String varian;

    public Makanan(String namaMakanan, int harga, String varian) {
        super(namaMakanan, harga);
        this.varian = varian;
    }

    @Override
    public void invoice() {
        super.invoice();
        System.out.println("- Varian = " + varian);
    }
}

public class Kue extends Menu{
    public String varian;

    public Kue(String namaMakanan, int harga, String varian) {
        super(namaMakanan, harga);
        this.varian = varian;
    }

    @Override
    public void invoice() {
        super.invoice();
        System.out.println("- Varian = " + varian);
    }
}

public class Minuman extends Menu{
    public String ukuran;

    public Minuman(String namaMakanan, int harga, String ukuran) {
        super(namaMakanan, harga);
        this.ukuran = ukuran;
    }

    @Override
    public void invoice() {
        super.invoice();
        System.out.println("- Ukuran = " + ukuran);
    }
}

public class Kopi extends Menu{
    public String gula;

    public Kopi(String namaMakanan, int harga, String gula) {
        super(namaMakanan, harga);
        this.gula = gula;
    }

    @Override
    public void invoice() {
        super.invoice();
        System.out.println("- Pilihan Gula = " + gula);
    }
}

public class MakananPenutup extends Menu{
    public String toping;

    public MakananPenutup(String namaMakanan, int harga, String toping) {
        super(namaMakanan, harga);
        this.toping = toping;
    }

    @Override
    public void invoice() {
        super.invoice();
        System.out.println("- Toping = " + toping);
    }
}

public class ProgramRestoran {
    public static void main(String[] args) {
        Makanan makanan = new Makanan("Nasi Goreng", 25000, "Seafood");
        Minuman minuman = new Minuman("Es Teh", 10000, "Besar");
        Kopi kopi = new Kopi("Arabicca", 20000, "Tanpa Gula");
        MakananPenutup makananPenutup = new MakananPenutup("Puding", 10000, "Vanila");
        Kue kue = new Kue("Brownies", 12000, "Coklat Kacang");

        System.out.println("MENU MAKANAN :");
        makanan.invoice("Untuk nasi goreng bisa request porsi");
        System.out.println("------------------------");
        System.out.println("MENU MINUMAN :");
        minuman.invoice();
        System.out.println("------------------------");
        System.out.println("MENU KOPI :");
        kopi.invoice("Kopi Robusta dan Americano belum tersedia");
        System.out.println("------------------------");
        System.out.println("MENU MAKANAN PENUTUP :");
        makananPenutup.invoice();
        System.out.println("------------------------");
        System.out.println("MENU KUE :");
        kue.invoice("Beli 2 gratis 1 semua varian dibawah 10000 IDR");
    }
}
