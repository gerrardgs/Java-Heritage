class HP{
    String merkHP;
    String pemilikHP;
    String ramHP;
    String romHP;
    String hargaHP;
    String umurHP;
    String ukuranLayar;

    String handphoneHidup(){
        return "HP Hidup";
    }

    String handphoneMati(){
        return "HP Mati";
    }
}

class User{
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }


}

public class Main2 {

    public static void main(String[] args){
        HP handphoneFerry = new HP();

        handphoneFerry.pemilikHP = "Ferry";
        handphoneFerry.merkHP = "Infinix";
        handphoneFerry.hargaHP = "1.000.000,00-";
        handphoneFerry.ramHP = "8 GB";
        handphoneFerry.romHP = "64 GB";
        handphoneFerry.ukuranLayar = "6.0' (Inch)";
        handphoneFerry.umurHP = "5 Tahun";

        System.out.println("Nama Pemilik : " + handphoneFerry.pemilikHP);
        System.out.println("Merk HP : " + handphoneFerry.merkHP);
        System.out.println("Harga HP : " + handphoneFerry.hargaHP);
        System.out.println("RAM HP : " + handphoneFerry.ramHP);
        System.out.println("ROM HP : " + handphoneFerry.romHP);
        System.out.println("Ukuran Layar : " + handphoneFerry.ukuranLayar);
        System.out.println("Umur HP : " + handphoneFerry.umurHP);
        System.out.println("\n" + handphoneFerry.handphoneHidup());
        System.out.println(handphoneFerry.handphoneMati());
    }
}
