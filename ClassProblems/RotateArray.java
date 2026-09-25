import java.util.Arrays;

public class RotateArray {
    
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        
        // 1. Reduce k using modulo arithmetic
        k = k % n;
        
        // 2. Create a new array of the same size
        int[] newArray = new int[n];
        
        // 3. Place each element at its new calculated position
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
        
        // 4. Return the new array
        return newArray;
    }

    public static void main(String[] args) {
        // --- Test Case 1 ---
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] result1 = rotateArray(nums1, k1);
        
        System.out.println("Test Case 1:");
        System.out.println("Input:  nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println();

        // --- Test Case 2 ---
        int[] nums2 = {1, 2};
        int k2 = 3;
        int[] result2 = rotateArray(nums2, k2);
        
        System.out.println("Test Case 2:");
        System.out.println("Input:  nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + Arrays.toString(result2));
    }
}
