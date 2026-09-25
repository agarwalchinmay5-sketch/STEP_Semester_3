public class StudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        // Split the CSV string by comma
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            // Print the formatted student record with trimmed whitespace
            System.out.println("Name: " + fields[0].trim() + " | Roll No: " + fields[1].trim() + " | Dept: " + fields[2].trim());
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Valid input from the sample
        System.out.println("--- Test Case 1 ---");
        String test1 = "Ananya Verma,RA2211003010123,CSE";
        parseStudentRecord(test1);

        // Test Case 2: Invalid input from the sample (Missing Roll Number)
        System.out.println("\n--- Test Case 2 ---");
        String test2 = "Ananya Verma,CSE";
        parseStudentRecord(test2);

        // Test Case 3: Extra fields (Invalid)
        System.out.println("\n--- Test Case 3 ---");
        String test3 = "Ananya Verma,RA2211003010123,CSE,AdditionalField";
        parseStudentRecord(test3);
    }
}