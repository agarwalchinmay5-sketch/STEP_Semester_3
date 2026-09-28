import java.util.Scanner;

public class MatchDayAnalyzer {

    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";
            
            result.append("Match ").append(i).append(": ").append(status);
            
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get the number of matches (rows)
        System.out.print("Enter the number of matches: ");
        int numMatches = scanner.nextInt();

        // Initialize the 2D array with the specified number of rows
        int[][] runsPerOver = new int[numMatches][];

        // 2. Get the overs for each match dynamically (supports ragged rows)
        for (int i = 0; i < numMatches; i++) {
            System.out.print("Enter the number of overs recorded for Match " + i + ": ");
            int numOvers = scanner.nextInt();
            
            runsPerOver[i] = new int[numOvers];
            System.out.print("Enter the runs scored in each over (separated by spaces): ");
            for (int j = 0; j < numOvers; j++) {
                runsPerOver[i][j] = scanner.nextInt();
            }
        }

        // 3. Get the classification threshold
        System.out.print("Enter the Power Surge threshold: ");
        int threshold = scanner.nextInt();

        // 4. Run the classification algorithm and print the final output string
        String analysisResult = classifyMatches(runsPerOver, threshold);
        System.out.println("\nOutput:");
        System.out.println(analysisResult);

        scanner.close();
    }
}
