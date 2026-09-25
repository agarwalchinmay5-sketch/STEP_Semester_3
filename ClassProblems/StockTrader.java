public class StockTrader {

    public static int maxProfit(int[] prices) {
        // Handle empty or invalid edge cases
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Initialize minPrice with the first day's price
        int minPrice = prices[0];
        int maxProfit = 0;

        // Walk through the array once starting from day 2 (index 1)
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // Update the lowest price seen so far
                minPrice = prices[i];
            } else {
                // Calculate potential profit and update running record
                int currentProfit = prices[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: [7, 1, 5, 3, 6, 4]");
        System.out.println("Output: " + maxProfit(prices1)); // Expected: 5
        System.out.println();

        // Sample Input 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Input: [7, 6, 4, 3, 1]");
        System.out.println("Output: " + maxProfit(prices2)); // Expected: 0
    }
}
