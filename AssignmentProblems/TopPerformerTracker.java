import java.util.Scanner;

public class TopPerformerTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of scores (minimum 2): ");
        int n = scanner.nextInt();

        // Enforce the problem's constraint that length is at least 2
        if (n < 2) {
            System.out.println("Invalid input. The array must contain at least 2 elements.");
            return;
        }

        int[] scores = new int[n];
        System.out.println("Enter " + n + " space-separated scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        // Call the method and print the result
        String result = findMinMaxSpread(scores);
        System.out.println("\nResult:");
        System.out.println(result);

        scanner.close();
    }

    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }
}
