import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Outer loop iterates through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Inner loop iterates through the subsequent elements to find a pair
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the sum of the pair matches the target
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // Return an empty array if no pair is found
        return new int[]{};
    }

    public static void main(String[] args) {
        // --- Sample Input 1 ---
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Test Case 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1) + "\n");

        // --- Sample Input 2 ---
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Test Case 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2));
    }
}
