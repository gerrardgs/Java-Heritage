public abstract class Animal{
    public abstract int age();
    public abstract String gender();
}

public interface onEarth{
    public abstract void isMammal();
    public abstract void mate();
}

public class Duck extends Animal implements onEarth{
    private String beakColor;

    public int age(){
        return 2;
    }
     public String gender(){
         return "Laki-Laki";
     }
     public void isMammal(){
         System.out.println("Dia Merupakan Hewan Mamalia");
     }
     public void mate(){
         System.out.println("Dia Memiliki Banyak Kawanan");
     }
     public void setBeakColor(String beakColor){
        this.beakColor = beakColor;
     }

    public String getBeakColor() {
        return this.beakColor;
    }
    public void swim(){
        System.out.println("Dia Berenang Menggunakan Kaki");
    }
    public void quack(){
        System.out.println("Dia Bersuara");
    }
}

public class Fish extends Animal implements onEarth{
    private int sizeInFT;
    private boolean canEat;

    public int age(){
        return 3;
    }
    public String gender(){
        return "Perempuan";
    }
    public void isMammal(){
        System.out.println("Dia Merupakan Hewan Mamalia");
    }
    public void mate(){
        System.out.println("Dia Memiliki Banyak Kawanan");
    }

    public void setSizeInFT(int sizeInFT){
        this.sizeInFT = sizeInFT;
    }
    public int getSizeInFT(){
        return this.sizeInFT;
    }
    public boolean isCanEat(){
        return true;
    }

    public void swim(){
        System.out.println("Dia Berenang Menggunakan Sirip");
    }
}
public class Zebra extends Animal implements onEarth{
    private boolean Is_wild;

    public int age(){
        return 2;
    }
    public String gender(){
        return "Laki-Laki";
    }
    public void isMammal(){
        System.out.println("Dia Bukan Merupakan Hewan Mamalia");
    }
    public void mate(){
        System.out.println("Dia Memiliki Banyak Kawanan");
    }

    public boolean isIs_wild(){
        return false;
    }

    public void run(){
        System.out.println("Dia Tidak Bisa Berlari");
    }
}
public class Main {
    public static void main(String[] args){
        System.out.println("BEBEK");
        Duck bebek = new Duck();
        Duck bebek1 = (Duck) bebek;
        bebek1.setBeakColor("Yellow");
        System.out.println("Warna Bebek : " + bebek1.getBeakColor());
        System.out.println("Umur Bebek : " + bebek1.age() + " Tahun");
        System.out.println("Jenis kelamin : " + bebek1.gender());
        bebek1.isMammal();
        bebek1.mate();
        bebek1.swim();
        bebek1.quack();

        System.out.println();

        System.out.println("IKAN");
        Fish ikan = new Fish();
        Fish ikan1 = (Fish) ikan;
        ikan1.setSizeInFT(10);
        System.out.println("Ukuran Ikan : " + ikan1.getSizeInFT());
        System.out.println("Jenis Kelamin : " + ikan.gender());
        System.out.println("Umur Ikan : " + ikan1.age() + " Tahun");
        System.out.println("Ikan Bisa Makan = " + ikan1.isCanEat());
        ikan1.isMammal();
        ikan1.mate();
        ikan1.swim();

        System.out.println();

        System.out.println("ZEBRA");
        Zebra zebra = new Zebra();
        Zebra zebra1 = (Zebra) zebra;
        System.out.println("Zebra Liar = " + zebra1.isIs_wild());
        System.out.println("Umur Zebra : " + zebra1.age() + " Tahun");
        System.out.println("Jenis Kelamin : " + zebra1.gender());
        zebra1.isMammal();
        zebra1.mate();
        zebra1.run();
    }
}
