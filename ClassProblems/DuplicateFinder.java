import java.util.Scanner;

public class DuplicateFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of teams: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character

        String[] teams = new String[count];
        System.out.println("Enter the team names one by one:");
        for (int i = 0; i < count; i++) {
            System.out.print("Team " + (i + 1) + ": ");
            teams[i] = scanner.nextLine();
        }

        // Call the method and print the result
        String result = findDuplicateTeam(teams);
        System.out.println("\n" + result);

        scanner.close();
    }

    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
}
