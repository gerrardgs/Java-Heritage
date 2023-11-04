abstract class Hewan{
    String nama;
    public abstract void habitatHewan();
    public void namaHewan(){
        System.out.println("\n Method di dalam abstract class Hewan");
        System.out.println("Nama hewan : " + nama);
    }
}

class Karnivora extends Hewan{
    String habitat;
    public void habitatHewan() //pendefinisian abstract method
    {
        System.out.println("\n Method di dalam class Karnivora");
        System.out.println("Habitat hewan : "+habitat);
    }
}

public class Main {
    public static void main(String[] args){
        System.out.println("\tMENERAPKAN PENGGUNAAN ABSTRACT CLASS #1");
        Karnivora singa = new Karnivora();
        singa.nama = "Singa";
        singa.habitat = "Darat";
        singa.namaHewan();
        singa.habitatHewan();
    }
}
