import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double result = 0;
        while (true) {
            try {
                System.out.println("Masukkan angka a: ");
                int a = scanner.nextInt();

                System.out.println("Masukkan angka b: ");
                int b = scanner.nextInt();

                result = a / b;
            } catch (InputMismatchException error) {
                scanner.nextLine();
                System.out.println("Dilihat lagi tipe data inputannya ya kak");
            } catch (ArithmeticException error) {
                result = Double.NaN;
                System.out.println("Dilihat lagi pembaginya ya kak (tidak boleh nol)");
            } finally {
                System.out.println("NOTE! Kode akan diulang.");
            }
        }
    }
}
