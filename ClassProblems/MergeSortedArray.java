import java.util.Arrays;

public class MergeSortedArray {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        
        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for result array
        
        // Compare elements from both arrays and copy the smaller one
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements from arr1, if any
        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        
        // Copy remaining elements from arr2, if any
        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard overlapping arrays
        int[] arr1_case1 = {1, 3, 5};
        int[] arr2_case1 = {2, 4, 6};
        int[] result1 = mergeSortedArrays(arr1_case1, arr2_case1);
        System.out.println("Test Case 1 Output: " + Arrays.toString(result1));
        
        // Test Case 2: One empty array
        int[] arr1_case2 = {};
        int[] arr2_case2 = {1, 2, 3};
        int[] result2 = mergeSortedArrays(arr1_case2, arr2_case2);
        System.out.println("Test Case 2 Output: " + Arrays.toString(result2));
    }
}
