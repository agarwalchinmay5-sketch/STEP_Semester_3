import java.util.Scanner;
public class GCD{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = s.nextInt();
        System.out.println("Enter second number: ");
        int num2 = s.nextInt();
        while(num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        System.out.println("GCD: " + num1);
        s.close();
    }
}