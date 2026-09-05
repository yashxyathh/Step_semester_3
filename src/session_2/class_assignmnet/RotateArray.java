import java.util.Scanner;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {

        k = k % nums.length;

        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int newPosition = (i + k) % nums.length;

            newArray[newPosition] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter k:");
        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.println("Rotated Array:");

        for (int value : result) {
            System.out.print(value + " ");
        }

        sc.close();
    }
}
