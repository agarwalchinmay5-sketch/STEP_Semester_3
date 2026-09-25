public class PhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        // Validate that it is not null, exactly 10 characters long, and entirely numeric
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            return "Invalid phone number";
        }

        // Build the masked string using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(phone.substring(6)); // Get the last 4 digits (indices 6 to 9)

        // Insert a "-" between the mask and the last 4 digits
        sb.insert(6, "-");

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(maskPhoneNumber("9876543210")); // Output: XXXXXX-3210
        System.out.println(maskPhoneNumber("98765"));      // Output: Invalid phone number
    }
}
