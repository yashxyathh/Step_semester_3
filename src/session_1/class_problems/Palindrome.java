import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        int n,origNumber,reversedNumber=0;
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the number: ");
        n=sc.nextInt();
        origNumber=n;

        while(n!=0){
            int digit =n%10;
            reversedNumber=reversedNumber*10+digit;
            n=n/10;

        }
        if (origNumber==reversedNumber){
            System.out.println(origNumber+" is a palindrome");

        }
        else{
            System.out.println(origNumber+" is not a palindrome");

        }
        sc.close();

    }
    
}