public class WarehouseBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sumA = 0;
        int sumB = 0;
        
        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;

        // Loop through both arrays simultaneously since they are of equal length
        for (int i = 0; i < sectionA.length; i++) {
            // Accumulate sums
            sumA += sectionA[i];
            sumB += sectionB[i];

            // Check Section A for highest quantity
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }

            // Check Section B for highest quantity
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }

        // Determine balance status
        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        // Print output matching the exact format in the image
        // Note: Human-readable item index usually starts at 1 (index + 1)
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                sumA, sumB, status, maxQuantity, maxSection, (maxIndex + 1));
    }

    // Main method to test the sample input provided
    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}
