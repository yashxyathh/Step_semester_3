import java.util.Scanner;

public class DigitSumNumberReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int temporary = number;
        int sum = 0;
        int reverse = 0;

        while (temporary > 0) {
            int digit = temporary % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            temporary /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
        scanner.close();
    }
}
