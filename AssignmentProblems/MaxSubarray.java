public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        // Initialize tracking variables with the first element
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide to extend the current subarray or start fresh from the current element
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            
            // Update the global maximum sum found so far
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSubarray solver = new MaxSubarray();

        // Sample Input 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input 1: [-2, 1, -3, 4, -1, 2, 1, -5, 4]");
        System.out.println("Expected Output: 6");
        System.out.println("Actual Output:   " + solver.maxSubArray(nums1));
        System.out.println();

        // Sample Input 2 (All negative numbers)
        int[] nums2 = {-3, -1, -2};
        System.out.println("Input 2: [-3, -1, -2]");
        System.out.println("Expected Output: -1");
        System.out.println("Actual Output:   " + solver.maxSubArray(nums2));
    }
}
