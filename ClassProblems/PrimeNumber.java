import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        boolean isPrime = true;
        if(input<=1){
            isPrime = false;
        }
        for(int i=2; input>i; i++){
            if(input%i==0){
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println(input + " is a prime number.");
        }else{
            System.out.println(input + " is not a prime number.");
        }
        scanner.close();
    }
}