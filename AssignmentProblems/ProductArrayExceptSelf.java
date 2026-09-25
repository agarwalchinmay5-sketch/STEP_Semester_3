import java.util.Arrays;

public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Forward pass: calculate prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Backward pass: multiply by suffix products
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffixProduct;
            suffixProduct *= nums[i];
        }
        
        return answer;
    }

    public static void main(String[] args) {
        ProductArrayExceptSelf sol = new ProductArrayExceptSelf();

        // Sample Case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = sol.productExceptSelf(nums1);
        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [24, 12, 8, 6]
        System.out.println();

        // Sample Case 2 (with zero handling)
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = sol.productExceptSelf(nums2);
        System.out.println("Input:  " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [0, 0, 9, 0, 0]
    }
}
