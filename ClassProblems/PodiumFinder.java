import java.util.Scanner;

public class PodiumFinder {

    public static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of scores (minimum 3): ");
        int n = scanner.nextInt();

        // Enforce the problem constraint
        if (n < 3) {
            System.out.println("Error: Must enter at least 3 scores.");
            return;
        }

        int[] scores = new int[n];
        System.out.println("Enter the " + n + " scores separated by spaces or newlines:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        int[] result = findTopThreeScores(scores);

        System.out.println("Top 3 scores: [" + result[0] + ", " + result[1] + ", " + result[2] + "]");
        
        scanner.close();
    }
}
