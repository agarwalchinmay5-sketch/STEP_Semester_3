public class LibraryISBNValidator {

    /**
     * Normalizes the raw input string by trimming spaces and 
     * converting only the first 3 characters to uppercase.
     */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        
        // 1. Trim leading and trailing spaces
        String trimmed = raw.trim();
        
        // Ensure there are at least 3 characters to uppercase safely
        if (trimmed.length() >= 3) {
            String firstThree = trimmed.substring(0, 3).toUpperCase();
            String rest = trimmed.substring(3);
            return firstThree + rest;
        }
        
        return trimmed.toUpperCase();
    }

    /**
     * Validates the normalized code using traditional loops and character checks.
     * If valid, returns a formatted string; otherwise, returns the specific invalid reason.
     */
    public static String validateAndFormat(String code) {
        // 1. Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // 2. Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // 3. Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // 4. Build the formatted display line using StringBuilder
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ");
        sb.append("YEAR: ").append(year).append(" | ");
        sb.append("CATALOG: ").append(catalog);

        return sb.toString();
    }

    // Main method to test the functionality with the sample cases
    public static void main(String[] args) {
        // Test Case 1: Valid mixed case with stray spaces
        String input1 = "  pen2026004251 ";
        String normalized1 = normalizeCode(input1);
        System.out.println("Output 1: " + validateAndFormat(normalized1));

        // Test Case 2: Invalid publisher code (contains digits instead of letters)
        String input2 = "12N2026004251";
        String normalized2 = normalizeCode(input2);
        System.out.println("Output 2: " + validateAndFormat(normalized2));
    }
}
