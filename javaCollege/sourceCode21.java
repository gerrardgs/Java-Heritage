import java.security.spec.ECField;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Masukkan Usia/Umur Anda: ");
                int umur = scanner.nextInt();

                if (umur < 0 || umur > 120){
                    throw new IllegalArgumentException("Umur Tidak Valid");
                }

                System.out.println("Umur Tercatat Dalam Sistem.");

            } catch (InputMismatchException e){
                System.out.println("Input Tidak Valid, Masukkan Kembali Data Berupa Umur/Usia Anda");
                scanner.nextLine();
            } catch (IllegalArgumentException e){
                System.out.println(e.toString());
            } catch (Exception e){
                System.out.println("Another Fatal Error Detected, Database-Input Restarted.");
            }
        }
    }
}
