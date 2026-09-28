import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public static String draftAndRank(Player[] players) {
        List<Player> draftableList = new ArrayList<>();

        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftableList.add(p);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            result.append(i + 1).append(". ").append(draftableArray[i].name);
            if (i < draftableArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    // Main method to capture interactive user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players to evaluate: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Clear newline buffer

        Player[] inputPlayers = new Player[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Entering details for Player #" + (i + 1) + " ---");
            
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter matches played: ");
            int matches = scanner.nextInt();

            System.out.print("Enter batting average: ");
            double average = scanner.nextDouble();

            System.out.print("Is the player injured? (true/false): ");
            boolean injured = scanner.nextBoolean();
            scanner.nextLine(); // Clear buffer

            inputPlayers[i] = new Player(name, matches, average, injured);
        }

        System.out.println("\n--- Final Draft Ranking ---");
        String finalRanking = draftAndRank(inputPlayers);
        
        if (finalRanking.isEmpty()) {
            System.out.println("No players qualified for the draft.");
        } else {
            System.out.println(finalRanking);
        }

        scanner.close();
    }
}
