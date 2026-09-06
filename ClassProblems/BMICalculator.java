
public class BMICalculator {

    // Method to determine BMI status
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Method to calculate and print the wellness report
    static void printWellnessReport(double[] heights, double[] weights) {

        System.out.printf("%-10s %-12s %-12s %-10s %-15s%n",
                "Person", "Height(m)", "Weight(kg)", "BMI", "Status");

        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            String status = getBmiStatus(bmi);

            System.out.printf("%-10d %-12.2f %-12.2f %-10.2f %-15s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {

        // Height and weight of 10 people
        double[] heights = {
            1.75, 1.60, 1.80, 1.65, 1.70,
            1.72, 1.68, 1.78, 1.62, 1.74
        };

        double[] weights = {
            70, 90, 75, 60, 85,
            68, 80, 72, 95, 65
        };

        // Display report
        printWellnessReport(heights, weights);
    }
}