import java.util.Scanner;

public class FactorialCalculation {
    public static long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            System.out.println(factorial(scanner.nextInt()));
        }

        scanner.close();
    }
}
