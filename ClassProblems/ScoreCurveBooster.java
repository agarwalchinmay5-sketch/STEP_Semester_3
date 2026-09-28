import java.util.Arrays;
import java.util.Scanner;

public class ScoreCurveBooster {
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get the size of the scoreboard
        System.out.print("Enter the number of teams: ");
        int numTeams = scanner.nextInt();

        // 2. Initialize and populate the array
        int[] scores = new int[numTeams];
        System.out.println("Enter the scores for each team:");
        for (int i = 0; i < numTeams; i++) {
            System.out.print("Team " + (i + 1) + " score: ");
            scores[i] = scanner.nextInt();
        }

        // 3. Get the flat bonus value
        System.out.print("Enter the flat bonus amount: ");
        int bonus = scanner.nextInt();

        // 4. Process and print the result
        curveScores(scores, bonus);
        System.out.println("\nFinal Leaderboard:");
        System.out.println(Arrays.toString(scores));

        scanner.close();
    }
}
