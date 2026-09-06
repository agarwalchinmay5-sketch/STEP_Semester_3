public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        // Handle edge case for null or empty array
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean duplicateFound = false;

        // Nested loop to compare each seat number against every other seat number
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                // If a match is found
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    
                    // Break the inner loop to avoid printing the same pair multiple times
                    break; 
                }
            }
        }

        // If the loop finished and no duplicates were detected
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    // Main method to test the sample inputs provided in the prompt
    public static void main(String[] args) {
        // Test Case 1: Contains duplicates
        System.out.println("--- Test Case 1 ---");
        int[] input1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(input1);

        // Test Case 2: No duplicates
        System.out.println("\n--- Test Case 2 ---");
        int[] input2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(input2);
    }
}
