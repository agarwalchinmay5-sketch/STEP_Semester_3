public class WordLengthProfiler {

    public static void classifyWordLengths(String review) {
        // Step 1: Handle null or empty inputs gracefully
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Counters for each category
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        // Step 2: Split the review string into words using spaces
        String[] words = review.split("\\s+");

        // Step 3: Loop through each word and classify by length
        for (String word : words) {
            // Optional: Remove trailing punctuation (like periods or commas) to get an accurate letter count
            word = word.replaceAll("[^a-zA-Z0-9]", "");
            
            if (word.isEmpty()) {
                continue;
            }

            int length = word.length();

            // Conditional logic based on assignment criteria
            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        // Step 4: Print the final counts in the specified format
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    // Main method to test the functionality with the sample input
    public static void main(String[] args) {
        String sampleInput = "This movie was absolutely fantastic and thrilling";
        
        System.out.println("Input: \"" + sampleInput + "\"");
        System.out.print("Output: ");
        classifyWordLengths(sampleInput);
    }
}
