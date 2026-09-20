import java.util.Scanner;
public class TwoSum{
    static int[] twosum(int[] nums,int target){
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};

    }
    public static void main(String[] args) {
        java.util.Scanner sc=new Scanner(System.in);
        System.out.println("Enter the total size of items: ");
        int n=sc.nextInt();
        int[] array=new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();

        }
        System.out.println("enter the budget: ");
        int target=sc.nextInt();
        int[]result= twosum(array, target);
        if (result[0] != -1) {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No pair found");
        }
        sc.close();
    }
}