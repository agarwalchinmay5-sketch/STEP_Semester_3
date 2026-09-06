public class TypingSpeedTest {

    public static void checkTypingAccuracy(String original, String typed) {
        // Handle edge case where lengths differ, though task states equal length strings
        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length.");
            return;
        }

        int totalCharacters = original.length();
        int matchedCount = 0;
        int firstMismatchPosition = -1;

        // Traverse the strings character by character
        for (int i = 0; i < totalCharacters; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matchedCount++;
            } else {
                // Record the 1-based position of the very first mistake
                if (firstMismatchPosition == -1) {
                    firstMismatchPosition = i + 1; 
                }
            }
        }

        // Calculate the accuracy percentage
        double accuracy = ((double) matchedCount / totalCharacters) * 100;

        // Format and print output matching the sample format
        System.out.print("Matched: " + matchedCount + "/" + totalCharacters);
        System.out.printf(" | Accuracy: %.2f%%", accuracy);

        if (firstMismatchPosition == -1) {
            System.out.println(" | No Mismatches");
        } else {
            // Retrieve characters at the index of the first mismatch
            int mismatchIdx = firstMismatchPosition - 1;
            System.out.println(" | First Mismatch at position " + firstMismatchPosition 
                               + " ('" + original.charAt(mismatchIdx) 
                               + "' vs '" + typed.charAt(mismatchIdx) + "')");
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Partial Match
        System.out.println("--- Test Case 1 ---");
        checkTypingAccuracy("hello world", "hello worlt");

        // Test Case 2: Perfect Match
        System.out.println("\n--- Test Case 2 ---");
        checkTypingAccuracy("coding", "coding");
    }
}
