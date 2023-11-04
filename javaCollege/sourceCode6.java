public class Kendaraan{
    String nomor_plat;
    String kapasitas_bahan_bakar;

      public Kendaraan(String nomor_plat, String kapasitas_bahan_bakar){
        this.nomor_plat = nomor_plat;
        this.kapasitas_bahan_bakar = kapasitas_bahan_bakar;
    }

    public Float hitung_jarak_tempuh(){
          Float kbb = Float.parseFloat(kapasitas_bahan_bakar);
          return kbb;
    }

    public void display(){
        System.out.println("Nomor Plat : " + nomor_plat);
        System.out.println("Kapasitas Bahan Bakar (Dalam Liter) : " + kapasitas_bahan_bakar);
    }
}

public class Mobil extends Kendaraan{

    String merk;

    String konsumsi_bbm;

    public Mobil(String nomor_plat, String kapasitas_bahan_bakar, String merk, String konsumsi_bbm){
        super(nomor_plat, kapasitas_bahan_bakar);
        this.merk = merk;
        this.konsumsi_bbm = konsumsi_bbm;
    }

    public Float hitung_jarak_tempuh(){
        Float kbb = Float.parseFloat(kapasitas_bahan_bakar);
        Float kbbm = Float.parseFloat(konsumsi_bbm);
        return kbb * kbbm;
    }

    public void display(){
        System.out.println("Merk Mobil: " + merk);
        System.out.println("Konsumsi BBM (Dalam Nilai KM per Liter) : " + konsumsi_bbm);
        System.out.println("Jarak Tempuh Maximum : " + hitung_jarak_tempuh() + "KM/L");
    }
}

public class Motor extends Kendaraan{

    String tipe;

    int tahun_pembuatan;

    public Motor(String nomor_plat, String kapasitas_bahan_bakar, String tipe, int tahun_pembuatan){
        super(nomor_plat, kapasitas_bahan_bakar);
        this.tipe = tipe;
        this.tahun_pembuatan = tahun_pembuatan;
    }
    // matic = 50
    // bebek = 40
    // kopling = 100

    public Float hitung_jarak_tempuh(){
        Float kbb = Float.parseFloat(kapasitas_bahan_bakar);
        return kbb * 42; // motor gwejh sendiri ~ Yamaha XSR155
    }

    public void display(){
        System.out.println("Tipe Motor : " + tipe);
        System.out.println("Tahun Pembuatan Motor : " + tahun_pembuatan);
        System.out.println("Jarak Tempuh Maximum : " + hitung_jarak_tempuh() + "KM/L");
    }
}

public class Sepeda extends Kendaraan{

    String jenis_sepeda;

    String warna;

    public Sepeda(String nomor_plat, String kapasitas_bahan_bakar, String jenis_sepeda, String warna){
        super(nomor_plat, kapasitas_bahan_bakar);
        this.jenis_sepeda = jenis_sepeda;
        this.warna = warna;
    }

    public Float hitung_jarak_tempuh(){
        return 0.0f;
    }

    public void display(){
        System.out.println("Jenis Sepeda : " + jenis_sepeda);
        System.out.println("Warna Sepeda : " + warna);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void cetak_inventaris(List<Kendaraan> kendaraanList){
        for (Kendaraan kendaraan : kendaraanList){
            System.out.println("Nomor Plat : " + kendaraan.nomor_plat);
            System.out.println("Kapasitas Bahan Bakar (Dalam Liter) : " + kendaraan.kapasitas_bahan_bakar);
            if (kendaraan instanceof Mobil){
                Mobil mobil = (Mobil) kendaraan;
                System.out.println("Merk Mobil : " + mobil.merk);
                System.out.println("Konsumsi BBM (Dalam Nilai KM per Liter) : " + mobil.konsumsi_bbm);
                System.out.println("Jarak Tempuh Mobil : " + mobil.hitung_jarak_tempuh());
                System.out.println();
            } else if (kendaraan instanceof Sepeda){
                Sepeda sepeda = (Sepeda) kendaraan;
                System.out.println("Jenis Sepeda : " + sepeda.jenis_sepeda);
                System.out.println("Warna Sepeda : " + sepeda.warna);
                System.out.println("Jarak Tempuh Sepeda : " + sepeda.hitung_jarak_tempuh());
                System.out.println();
            } else if (kendaraan instanceof Motor){
                Motor motor = (Motor) kendaraan;
                System.out.println("Tipe Motor: " + motor.tipe);
                System.out.println("Tahun Pembuatan Motor : " + motor.tahun_pembuatan);
                System.out.println("Jarak Tempuh Motor : " + motor.hitung_jarak_tempuh());
                System.out.println();
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        List<Kendaraan> kendaraanList = List.of(
                new Mobil("B 2633 SFM", "40", "Honda H-RV", "10"),
                new Sepeda("0", "0", "Wimcycle", "Merah-Putih"),
                new Motor("AD 3235 YS", "10.4", "Yamaha XSR",2021));
        cetak_inventaris(kendaraanList);
    }
}
