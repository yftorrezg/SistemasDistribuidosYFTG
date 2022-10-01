// scanner
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // fibonacci
        System.out.println("Enter the number of terms: ");
        int n = sc.nextInt();
        int a = 0, b = 1, c = 0;
        System.out.println("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
        // cerrar scanner
        sc.close();
    }
}
