import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan N: ");
        int N = scanner.nextInt();

        System.out.print("Masukkan a: ");
        int a = scanner.nextInt();

        System.out.print("Masukkan b: ");
        int b = scanner.nextInt();

        System.out.println("\nHasil:");
        for (int i = a; i < b; i++) {
            System.out.println(N + "/" + i + " = " + N / i);
        }

        scanner.close();
    }
}
