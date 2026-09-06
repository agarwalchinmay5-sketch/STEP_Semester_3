public class TrafficSignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        // Handle edge case for empty or null input string
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No traffic logs available.");
            return;
        }

        // Variables to keep track of the maximum streak found so far
        char maxColor = signalLog.charAt(0);
        int maxStreak = 1;

        // Variables to keep track of the current active streak
        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        // Traverse through the string starting from the second character
        for (int i = 1; i < signalLog.length(); i++) {
            char code = signalLog.charAt(i);

            if (code == currentColor) {
                // If it matches the current streak color, increment the count
                currentStreak++;
            } else {
                // Check if the completed streak is the longest so far
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxColor = currentColor;
                }
                // Reset tracker for the new streak
                currentColor = code;
                currentStreak = 1;
            }
        }

        // Final check after loop ends to catch the very last streak
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxColor = currentColor;
        }

        // Print the result exactly as requested by the sample output
        System.out.println("Longest Streak: '" + maxColor + "' repeated " + maxStreak + " times");
    }

    // Main method to test the sample scenarios
    public static void main(String[] args) {
        System.out.print("Test 1 Input: \"RRGGGYRR\" -> Output: ");
        findLongestStreak("RRGGGYRR");

        System.out.print("Test 2 Input: \"RRRRYYGG\" -> Output: ");
        findLongestStreak("RRRRYYGG");
    }
}
