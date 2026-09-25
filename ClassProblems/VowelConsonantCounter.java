public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        
        // Convert to lowercase to make the comparison case-insensitive
        String lowerText = text.toLowerCase();
        
        // Loop through each character using length() and charAt()
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            
            // Ignore spaces
            if (ch == ' ') {
                continue;
            }
            
            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') { 
                // Since the prompt assumes only letters and spaces, any non-vowel letter is a consonant
                consonants++;
            }
        }
        
        // Print the results matching the sample output format
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        // Test with the sample input
        countVowelsAndConsonants("Java Programming");
    }
}
