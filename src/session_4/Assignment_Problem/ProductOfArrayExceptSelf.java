import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = product;
            product *= nums[i];
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= product;
            product *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(productExceptSelf(nums)));
        scanner.close();
    }
}
