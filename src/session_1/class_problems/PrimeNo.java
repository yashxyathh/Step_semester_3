import java.util.Scanner;

public class PrimeNo {
    public static void main(String[] args) {

        boolean isPrime = true;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer");
        int n = sc.nextInt();

        if (n <= 1) {
            isPrime = false;
        } 
        else if (n == 2) {
            isPrime = true;
        } 
        else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime == true) {
            System.out.println(n + " is a prime number");
        } else {
            System.out.println(n + " is not a prime number");
        }

        sc.close();
    }
}