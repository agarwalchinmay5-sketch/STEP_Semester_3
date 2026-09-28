import java.util.Scanner;

public class PlayerPickChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of players (up to 11): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline
        
        String[] playerNames = new String[n];
        System.out.println("Enter the player names one by one:");
        for (int i = 0; i < n; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            playerNames[i] = scanner.nextLine();
        }
        
        String result = findDuplicatePick(playerNames);
        System.out.println("\nResult: " + result);
        
        scanner.close();
    }

    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
}
