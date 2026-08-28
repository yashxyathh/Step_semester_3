import java.util.Scanner;
public class SumOfNaturalNumber {
    static void sumOfNaturalNumbers(int n){
        int i=1,sum=0;
        while (i<=n) {
            sum=sum+i;
            i++;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number: ");
        int n=sc.nextInt();
        sumOfNaturalNumbers(n);
        sc.close();

    }
    
}
