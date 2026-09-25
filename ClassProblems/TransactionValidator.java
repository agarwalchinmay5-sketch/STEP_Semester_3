public class TransactionValidator {

    /**
     * Normalizes the reference string by trimming trailing/leading spaces
     * and converting only the first 3 characters to uppercase.
     */
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        
        // 1. Trim leading and trailing spaces
        String trimmed = raw.trim();
        
        // Safety check if the trimmed string is shorter than 3 characters
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        
        // 2. Uppercase the first 3 characters using substring() + concatenation
        String bankCodeUpper = trimmed.substring(0, 3).toUpperCase();
        String remainingBody = trimmed.substring(3);
        
        return bankCodeUpper + remainingBody;
    }

    /**
     * Validates the normalized reference structure without using regex 
     * and returns a formatted StringBuilder line or a specific failure reason.
     */
    public static String validateAndFormat(String reference) {
        // 1. Validate exactly 14 characters length
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // 2. Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters"; // Matches sample output string
            }
        }

        // 3. Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // 4. Extract segments using substring()
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9, 14);

        // 5. Build the formatted display line using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(sequence);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test Case 1: Valid mixed case with spaces
        String input1 = " hdf03022600042 ";
        String normalized1 = normalizeReference(input1);
        System.out.println("Input:  \"" + input1 + "\"");
        System.out.println("Output: " + validateAndFormat(normalized1));
        System.out.println();

        // Test Case 2: Invalid bank code containing digits
        String input2 = "12F03022600042";
        String normalized2 = normalizeReference(input2);
        System.out.println("Input:  \"" + input2 + "\"");
        System.out.println("Output: " + validateAndFormat(normalized2));
    }
}
