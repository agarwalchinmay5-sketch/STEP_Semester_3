import java.util.Arrays;
import java.util.Scanner;

public class TeamScoreMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get the size of the array
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();

        // 2. Initialize and populate the scores array
        double[] scores = new double[numPlayers];
        System.out.println("Enter the score for each player:");
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Player " + i + " score: ");
            scores[i] = scanner.nextDouble();
        }

        // 3. Get the captain and vice-captain indices
        System.out.print("Enter Captain index: ");
        int captainIndex = scanner.nextInt();

        System.out.print("Enter Vice-Captain index: ");
        int viceCaptainIndex = scanner.nextInt();

        // 4. Display array before modification
        System.out.println("\nOriginal scores: " + Arrays.toString(scores));

        // 5. Apply the multipliers in-place
        applyMultipliers(scores, captainIndex, viceCaptainIndex);

        // 6. Display the final modified array
        System.out.println("Boosted scores:  " + Arrays.toString(scores));

        scanner.close();
    }

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }
}
