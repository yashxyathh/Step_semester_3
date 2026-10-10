import java.util.Scanner;

public class FestivalBonusCalculator {
    private static abstract class Employee {
        protected final String name;
        protected final double monthlySalary;

        protected Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        protected abstract double bonus();
    }

    private static class FullTimeEmployee extends Employee {
        private FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        protected double bonus() {
            return monthlySalary * 0.10;
        }
    }

    private static class PartTimeEmployee extends Employee {
        private PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        protected double bonus() {
            return monthlySalary * 0.05;
        }
    }

    private static class Intern extends Employee {
        private Intern(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        protected double bonus() {
            return 2000;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Employee[] employees = new Employee[count];

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            switch (type) {
                case "FULLTIME" -> employees[i] = new FullTimeEmployee(name, salary);
                case "PARTTIME" -> employees[i] = new PartTimeEmployee(name, salary);
                case "INTERN" -> employees[i] = new Intern(name, salary);
                default -> throw new IllegalArgumentException("Invalid employee type");
            }
        }

        double total = 0;
        for (Employee employee : employees) {
            double bonus = employee.bonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        scanner.close();
    }
}
