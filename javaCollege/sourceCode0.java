// First Meet

class NamaClass{
    int nomor1;
    int nomor2;
    char huruf;
    String kalimat;
    float pecahan;

    int tambahkanNomor(){
        return nomor1 + nomor2;
    }

    public void tampilkanNomor(){
    System.out.println("Nomor 1 : " + nomor1);
    System.out.println("Nomor 2 : " + nomor2);
    }
}

public class Main{
    public static void main(String[] args){
        NamaClass namaObject = new NamaClass();

        namaObject.nomor1 = 10;
        namaObject.nomor2 = 20;

        namaObject.tambahkanNomor();
        int result = namaObject.tambahkanNomor();
        System.out.println("Hasil: " + result);

        namaObject.tampilkanNomor();

        //namaObject.nomor1 = 1;
        //namaObject.huruf = 'a';
        //namaObject.kalimat = "ini nilai";
        //namaObject.pecahan = 2.1f;
    }
}
