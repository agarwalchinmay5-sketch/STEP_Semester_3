public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        // Find the index of the last dot '.'
        int lastDotIndex = filename.lastIndexOf('.');
        
        // If no dot is found, it has no extension and is rejected
        if (lastDotIndex == -1) {
            return "Rejected - invalid file type";
        }
        
        // Extract the extension following the last dot
        String extension = filename.substring(lastDotIndex + 1);
        
        // Compare case-insensitively against the accepted list
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected - invalid file type";
        }
    }

    public static void main(String[] args) {
        // Test with sample inputs
        String input1 = "Assignment1.PDF";
        String input2 = "notes.txt";

        System.out.println("Input: " + input1 + " -> Output: " + validateFileExtension(input1));
        System.out.println("Input: " + input2 + " -> Output: " + validateFileExtension(input2));
    }
}
