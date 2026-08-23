import java.util.Scanner;

public class NumberPrinter {

    public static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer N: ");
    
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            if (n >= 1) {
                printNumbersUpToN(n);
            } else {
                System.out.println("Please enter a number greater than or equal to 1.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
        }

        scanner.close();
    }
}
