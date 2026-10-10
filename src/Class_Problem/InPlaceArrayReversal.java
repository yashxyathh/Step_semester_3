import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void reverse(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int temporary = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temporary;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        reverse(numbers);
        System.out.println(Arrays.toString(numbers));
        scanner.close();
    }
}
