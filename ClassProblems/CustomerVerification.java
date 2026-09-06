public class CustomerVerification {

    // Method to reverse the given customer name
    public static String reverseCustomerName(String customerName) {
        // Create a StringBuilder to reconstruct the string efficiently
        StringBuilder reversed = new StringBuilder();
        
        // Traverse the original string from the last character to the first
        for (int i = customerName.length() - 1; i >= 0; i--) {
            reversed.append(customerName.charAt(i));
        }
        
        return reversed.toString();
    }

    public static void main(String[] args) {
        // Sample Input
        String inputName = "Sunil";
        
        // Call the method to get the reversed version
        String reversedName = reverseCustomerName(inputName);
        
        // Print both the original and reversed names as required
        System.out.println("Original Name: " + inputName);
        System.out.println("Reversed Name: " + reversedName);
    }
}
