import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    
    public int[][] threeSum(int[] nums) {
        // Step 1: Sort the array to enable the two-pointer approach and easy duplicate skipping
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();
        
        // Step 2: Iterate through the array, fixing the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element to avoid identical triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Initialize two pointers for the remaining subarray
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a valid unique triplet
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});
                    
                    // Advance pointers and skip duplicate values for left and right
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, move the left pointer forward to increase the sum
                    left++;
                } else {
                    // Sum is too large, move the right pointer backward to decrease the sum
                    right--;
                }
            }
        }
        
        // Convert the dynamic list into the required 2D primitive int array return format
        return resultList.toArray(new int[resultList.size()][]);
    }

    // Main method to run and test sample inputs
    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();

        // Sample Input 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        int[][] result1 = solver.threeSum(nums1);
        System.out.print("Test Case 1 Output: ");
        System.out.println(Arrays.deepToString(result1)); 
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        System.out.println();

        // Sample Input 2
        int[] nums2 = {0, 0, 0};
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        int[][] result2 = solver.threeSum(nums2);
        System.out.print("Test Case 2 Output: ");
        System.out.println(Arrays.deepToString(result2)); 
        // Expected: [[0, 0, 0]]
    }
}
