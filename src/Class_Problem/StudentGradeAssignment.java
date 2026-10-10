import java.util.Scanner;

public class StudentGradeAssignment {
    public static char getGrade(int marks) {
        if (marks >= 90) {
            return 'A';
        }
        if (marks >= 75) {
            return 'B';
        }
        if (marks >= 60) {
            return 'C';
        }
        if (marks >= 40) {
            return 'D';
        }
        return 'F';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            System.out.println("Grade " + getGrade(scanner.nextInt()));
        }

        scanner.close();
    }
}
