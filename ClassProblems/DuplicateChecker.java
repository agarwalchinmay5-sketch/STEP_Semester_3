public class DuplicateChecker {

    // Method to check for duplicates using nested loops
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Early exit if duplicate found
                }
            }
        }
        return false; // No duplicates found
    }

    public static void main(String[] args) {
        // Test Case 1: Contains duplicates
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input: [1, 2, 3, 1]");
        System.out.println("Output: " + containsDuplicate(nums1)); // Expected: true
        
        System.out.println(); // Blank line for readability

        // Test Case 2: All distinct elements
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Input: [1, 2, 3, 4]");
        System.out.println("Output: " + containsDuplicate(nums2)); // Expected: false
    }
}
