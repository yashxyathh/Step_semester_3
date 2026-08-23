import java.util.Scanner;
public class GCD {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int number1,number2;
        System.out.println("enter the first number: ");
        number1=sc.nextInt();
        System.out.println("enter the second number: ");
        number2=sc.nextInt();
        while (number2!=0){
            int remainder=number1%number2;
            number1=number2;
            number2=remainder;
        }
        System.out.println("GCD= "+number1);
        sc.close();
    }
}
