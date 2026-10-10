import java.util.Scanner;

public class WeeklyStaffPay {
    private static abstract class Staff {
        protected final String name;

        protected Staff(String name) {
            this.name = name;
        }

        public abstract double calculatePay();
    }

    private static class FullTimeStaff extends Staff {
        private final double weeklySalary;

        private FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        public double calculatePay() {
            return weeklySalary;
        }
    }

    private static class HourlyStaff extends Staff {
        private final double hours;
        private final double rate;

        private HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        public double calculatePay() {
            if (hours <= 40) {
                return hours * rate;
            }
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }

    private static class Intern extends Staff {
        private final double stipend;

        private Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        public double calculatePay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int staffCount = scanner.nextInt();
        Staff[] staffMembers = new Staff[staffCount];

        for (int i = 0; i < staffCount; i++) {
            String type = scanner.next();
            String name = scanner.next();

            if (type.equals("FULLTIME")) {
                staffMembers[i] = new FullTimeStaff(name, scanner.nextDouble());
            } else if (type.equals("HOURLY")) {
                staffMembers[i] = new HourlyStaff(name, scanner.nextDouble(), scanner.nextDouble());
            } else {
                staffMembers[i] = new Intern(name, scanner.nextDouble());
            }
        }

        double totalPayroll = 0;
        for (Staff staff : staffMembers) {
            double pay = staff.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", staff.name, pay);
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        scanner.close();
    }
}
