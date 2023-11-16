import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Masukkan angka a: ");
                int a = scanner.nextInt();

                System.out.println("Masukkan angka b: ");
                int b = scanner.nextInt();

                double result = a / b;
                System.out.println("Result: " + result);
            } catch (InputMismatchException error) {
                scanner.nextLine();
                System.out.println("Dilihat lagi tipe data inputannya ya kak");
            } catch (ArithmeticException error) {
                System.out.println("Dilihat lagi pembaginya ya kak (tidak boleh nol)");
            }
        }
    }
}
