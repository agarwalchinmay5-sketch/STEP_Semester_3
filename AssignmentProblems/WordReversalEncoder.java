public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        // Split the sentence into words using a single space
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversedWord = new StringBuilder();
            
            // Build the reverse of the word using a loop
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }
            
            // Append the reversed word to the final result
            result.append(reversedWord);
            
            // Append a space if it is not the last word
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Input
        String input = "hello club";
        String output = reverseEachWord(input);
        
        // Print the result
        System.out.println(output); // Output: olleh bulc
    }
}
