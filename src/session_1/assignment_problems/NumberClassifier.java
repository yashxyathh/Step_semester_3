import java.util.Scanner;
public class NumberClassifier{ 
    public static void classifyNumber(int number){
        if (number>0){
            System.out.println("Positive");

        }
        else if(number==0){
            System.out.println("Zero");
        }
        else{
            System.out.println("Negative");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int number =sc.nextInt();
        classifyNumber(number);
        sc.close();
    }
}
