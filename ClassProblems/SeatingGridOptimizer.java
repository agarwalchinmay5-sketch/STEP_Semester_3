import java.util.Scanner;

public class SeatingGridOptimizer {

    // Computes the average of a single row, handling jagged rows of varying lengths
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    // Classifies all rows based on the computed average and the given threshold
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";
            
            sb.append("Row ").append(i).append(": ").append(zone);
            
            // Append the separator for all but the last item
            if (i < seatingScores.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int numRows = scanner.nextInt();
        
        int[][] seatingScores = new int[numRows][];
        
        for (int i = 0; i < numRows; i++) {
            System.out.print("Enter the number of seats in row " + i + ": ");
            int numSeats = scanner.nextInt();
            seatingScores[i] = new int[numSeats];
            
            System.out.print("Enter " + numSeats + " scores for row " + i + ": ");
            for (int j = 0; j < numSeats; j++) {
                seatingScores[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();
        
        String result = classifyRows(seatingScores, threshold);
        System.out.println("\nOutput:\n" + result);
        
        scanner.close();
    }
}
