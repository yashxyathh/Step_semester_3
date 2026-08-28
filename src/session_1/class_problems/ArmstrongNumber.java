import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter an integer: ");
        int number =sc.nextInt();
        int origNumber=number;
        int sum=0;
        while (number>0) {
            int digit=number%10;
            sum= sum+(digit*digit*digit);
            number =number/10;

        }
        if (sum== origNumber){
            System.out.println(origNumber+" is an Armstrong Number.");

        }else{
            System.out.println(origNumber+" is not an Armstrong Number.");
        }sc.close();
    } 
}
