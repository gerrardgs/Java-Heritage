import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan N : ");
        int N = scanner.nextInt();

        System.out.println("Masukkan a : ");
        int a = scanner.nextInt();

        System.out.println("Masukkan b : ");
        int b = scanner.nextInt();

        System.out.println("\nHasil : ");
        for (int i = a; i < b; i++){
            try {
                System.out.println(N + "/" + i + "=" + N / i);
            } catch (ArithmeticException error){
                System.out.println("Error Detected " + error.toString());
            }
        }
        scanner.close();
    }
}
