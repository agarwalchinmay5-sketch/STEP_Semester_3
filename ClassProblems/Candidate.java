import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
    public int getCodingScore() { return codingScore; }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 8.0;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 7.0 && codingScore >= 45;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + codingScore; 
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted.add(c);
            }
        }

        Candidate[] shortlistArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistArray.length; i++) {
            Candidate c = shortlistArray[i];
            sb.append((i + 1))
              .append(". ")
              .append(c.getName())
              .append(" (")
              .append(c.getCompositeScore())
              .append(")");
            if (i < shortlistArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    // Main driver method to handle user input processing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of candidates: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline left behind by nextInt()

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Candidate " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("CGPA (0.0 - 10.0): ");
            double cgpa = scanner.nextDouble();

            System.out.print("Coding Score (0 - 100): ");
            int codingScore = scanner.nextInt();
            scanner.nextLine(); // Consume newline left behind by nextInt()

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println("\n--- Shortlist & Rank Results ---");
        String result = shortlistAndRank(candidates);
        System.out.println(result.isEmpty() ? "No candidates qualified for the drive." : result);

        scanner.close();
    }
}