import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static double calculate(int a, int b) {
        double result = 0;
        try {
            result = a / (double) b;
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero!");
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Masukkan angka a: ");
                int a = scanner.nextInt();

                System.out.print("Masukkan angka b: ");
                int b = scanner.nextInt();

                double result = calculate(a, b);
                System.out.println("Result: " + result);
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter integers.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
    }
}
