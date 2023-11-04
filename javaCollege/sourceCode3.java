import java.util.Scanner;
import java.util.ArrayList;

class Mahasiswa{
    private String nama;
    private String NIM;
    private String jurusan;

    public Mahasiswa(String nama, String NIM, String jurusan){
        this.nama = nama;
        this.NIM = NIM;
        this.jurusan = jurusan;
    }

    public String getNama(){
        return this.nama;
    }

    public String getNIM(){
        return this.NIM;
    }

    public String getJurusan(){
        return this.jurusan;
    }

    public void setNama(){
        this.nama = nama;
    }

    public void setNIM(){
        this.NIM = NIM;
    }

    public void setJurusan(){
        this.jurusan = jurusan;
    }
}

public class Week2{
    public static void main(String[] args) {
        System.out.println("~DATABASE MAHASISWA~");

        Scanner newStudent = new Scanner(System.in);
        ArrayList<Mahasiswa> studentNew = new ArrayList<>();

        System.out.println("\nInput Jumlah Data Mahasiswa (Angka) : ");
        Integer dataMahasiswa = Integer.parseInt(newStudent.nextLine());
        for (int i = 0; i < dataMahasiswa; i++){
            System.out.println("\nData Mahasiswa Ke- " + ( i + 1 ) + ":");

            System.out.println("\nNama : ");
            String nama = newStudent.nextLine();

            System.out.println("\nNIM : ");
            String NIM = newStudent.nextLine();

            System.out.println("\nJurusan : ");
            String jurusan = newStudent.nextLine();

            Mahasiswa Campus = new Mahasiswa(nama, NIM, jurusan);
            studentNew.add(Campus);
        }

        for (Mahasiswa Campus : studentNew){
            System.out.println("\nREKAP DATA");
            System.out.println("Nama : " + Campus.getNama());
            System.out.println("NIM: " + Campus.getNIM());
            System.out.println("Jurusan : " + Campus.getJurusan());
        }
        if (dataMahasiswa == 0){
            System.out.println("\nData Kosong.");
        } else{
            System.out.println("\nData Berhasil Direkap.");
        }
    }
}
