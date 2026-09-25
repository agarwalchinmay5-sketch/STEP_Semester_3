import java.util.Arrays;

public class MinRotatedArrayFinder {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search to find the minimum element
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the rightmost element,
            // the minimum must be in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, the minimum is either at mid or in the left half.
            else {
                right = mid;
            }
        }

        // 'left' will point to the minimum element
        return nums[left];
    }

    public static void main(String[] args) {
        MinRotatedArrayFinder solver = new MinRotatedArrayFinder();

        // Sample Input 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input:  nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + solver.findMin(nums1)); // Expected: 1
        System.out.println();

        // Sample Input 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Input:  nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + solver.findMin(nums2)); // Expected: 0
        System.out.println();

        // Sample Input 3 (No rotation)
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Input:  nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + solver.findMin(nums3)); // Expected: 11
    }
}
