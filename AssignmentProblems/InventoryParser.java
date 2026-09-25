public class InventoryParser {

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 (Valid Input) ---");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");

        System.out.println("\n--- Test Case 2 (Invalid Input) ---");
        parseInventoryRecord("Wireless Mouse,150");
    }

    public static void parseInventoryRecord(String csvLine) {
        // Break the CSV line into fields using a comma delimiter
        String[] fields = csvLine.split(",");
        
        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            // Print the formatted record using array indices, [1], and [2]
            System.out.println("Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2]);
        }
    }
}