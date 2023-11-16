import java.security.spec.ECField;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
                System.out.println("Masukkan Bilangan Bulat : ");

                try {
                    int bilanganBulat = scanner.nextInt();
                    scanner.nextLine();

                    if (bilanganBulat == 0){
                        System.out.println("Bilangan Bulat Tidak Valid, Masukkan Kembali Bilangan Bulat");
                    } else if (bilanganBulat %2 == 1){
                        System.out.println("\n" + bilanganBulat + " Adalah bilangan Ganjil.");
                    } else{
                        System.out.println("\n" + bilanganBulat + " Adalah Bilangan Bulat Genap");
                    }
                }catch (NumberFormatException e){
                    System.out.println("Bilangan Bulat Tidak Valid, Masukkan Kembali Bilangan Bulat : ");
                } catch (InputMismatchException e){
                    System.out.println("Bilangan Bulat Tidak Valid, Masukkan Kembali Bilangan Bulat : ");
                    scanner.nextLine();
                }
        }
    }
}
