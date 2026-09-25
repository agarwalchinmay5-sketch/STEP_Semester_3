import java.util.*;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        // 1. Define the set of stop words to filter out
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));
        
        // 2. Normalize: convert to lowercase and strip periods and commas using replace()
        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");
        
        // Handle empty or whitespace-only input safely
        if (cleanedText.trim().isEmpty()) {
            return;
        }

        // 3. Split the cleaned text into individual words using the whitespace pattern
        String[] words = cleanedText.split("\\s+");
        
        // 4 & 5. Filter out stop words and count frequencies using a HashMap
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        // 6. Sort the entries by frequency in descending order
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        // Print each unique word with its count
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Test with the sample input provided in the prompt
        String input = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(input);
    }
}
