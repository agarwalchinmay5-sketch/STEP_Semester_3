import java.util.HashMap;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        // Map to store (prefixSum -> frequency)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred 1 time (before any elements)
        map.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // If (currentSum - k) exists in the map, it means a subarray sums to k
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            
            // Record the current prefix sum in the map
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        SubArraySum solver = new SubArraySum();

        // Sample Input 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Test Case 1 Output: " + solver.subarraySum(nums1, k1)); // Expected: 2

        // Sample Input 2
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("Test Case 2 Output: " + solver.subarraySum(nums2, k2)); // Expected: 3
    }
}
