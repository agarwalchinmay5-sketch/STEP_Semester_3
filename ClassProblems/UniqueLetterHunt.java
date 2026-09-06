import java.util.HashMap;

public class UniqueLetterHunt {

    // Method to find the first non-repeating character
    public static char findFirstNonRepeatingChar(String text) {
        // Step 1: Compute the frequency of every character in the string
        HashMap<Character, Integer> charCounts = new HashMap<>();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            charCounts.put(ch, charCounts.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Scan the string left to right to find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (charCounts.get(ch) == 1) {
                return ch; // Early exit as soon as we find it
            }
        }

        // Return a null character placeholder if no non-repeating character exists
        return '\0'; 
    }

    // Main method to test the sample inputs
    public static void main(String[] args) {
        String[] testInputs = {"swiss", "aabbcc"};

        for (String input : testInputs) {
            char result = findFirstNonRepeatingChar(input);
            
            // Step 3: Print the character or a clear message if none exists
            if (result != '\0') {
                System.out.println("Input: \"" + input + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("Input: \"" + input + "\" -> No Non-Repeating Character Found");
            }
        }
    }
}
