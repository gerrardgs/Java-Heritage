public abstract class Hewan{
    public String nama;
    public String habitat;
    public abstract void berkembangBiak();
    public abstract void bernafas();
    }

public class Ikan extends Hewan{
    public Ikan(String nama, String habitat){
        this.nama = nama;
        this.habitat = habitat;
    }
    @Override
    public void berkembangBiak(){
        System.out.println("Ikan Berkembang Biak Dengan Cara Berburu Sesama Ikan Yang Lain");
    }

    @Override
    public void bernafas(){
        System.out.println("Ikan Bernafas Menggunakan Insang");
    }
}

public class Kucing extends Hewan{
    public Kucing(String nama, String habitat){
        this.nama = nama;
        this.habitat = habitat;
    }
    @Override
    public void berkembangBiak(){
        System.out.println("Kucing Berkembang Biak Dengan Cara Memburu Makanan Manusia Ataupun Berburu Hewan Yang Lain");
    }

    @Override
    public void bernafas(){
        System.out.println("Kucing Bernafas Menggunakan Paru-Paru");
    }

}

public class Main{
    public static void main(String[] args){
        Kucing kucing = new Kucing("Persia", "Darat");
        kucing.bernafas();
        kucing.berkembangBiak();
        System.out.println("Nama Kucing: " + kucing.nama);
        System.out.println("Habitat Kucing: " + kucing.habitat);

        System.out.println();

        Ikan ikan = new Ikan("Paus", "Laut");
        ikan.bernafas();
        ikan.berkembangBiak();
        System.out.println("Nama Ikan: " + ikan.nama);
        System.out.println("Habitat Ikan: " + ikan.habitat);
        }
    }
