import java.util.Scanner;
public class Voting{
    public static boolean isEligibility (int age){
        return age>=18;
    }
    public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       System.out.println("enter the age: ");
       int age =sc.nextInt();
       if (isEligibility(age)){
        System.out.println("Eligible to Vote");
       }else{
        System.out.println("Not Eligible");
       } sc.close();
    }
}