import java.util.Locale;
import java.util.Scanner;

public class StudentResultCardGenerator {
    private static class Student {
        private final String name;
        private final int[] marks;

        private Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        private double calculateAverage() {
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            return total / 3.0;
        }

        private char getGrade() {
            double average = calculateAverage();
            if (average >= 75) {
                return 'B';
            }
            if (average >= 60) {
                return 'C';
            }
            if (average >= 40) {
                return 'D';
            }
            return 'F';
        }

        private void printResult() {
            System.out.printf(Locale.US, "%s: Average %.1f, Grade %c%n", name.toUpperCase(), calculateAverage(), getGrade());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String name = scanner.next();
            int[] marks = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
            new Student(name, marks).printResult();
        }

        scanner.close();
    }
}
