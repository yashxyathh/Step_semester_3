import java.util.Scanner;

public class CollegeFeeCounter {
    private interface BusUser {
        double transportFee();
    }

    private static abstract class Student {
        protected final String name;

        protected Student(String name) {
            this.name = name;
        }

        protected abstract double tuition();

        protected double totalFee() {
            return tuition();
        }
    }

    private static class DayScholar extends Student implements BusUser {
        private DayScholar(String name) {
            super(name);
        }

        @Override
        protected double tuition() {
            return 40000;
        }

        @Override
        public double transportFee() {
            return 12000;
        }

        @Override
        protected double totalFee() {
            return tuition() + transportFee();
        }
    }

    private static class Hosteller extends Student {
        private Hosteller(String name) {
            super(name);
        }

        @Override
        protected double tuition() {
            return 40000;
        }

        @Override
        protected double totalFee() {
            return tuition() + 60000;
        }
    }

    private static class ScholarshipStudent extends Student implements BusUser {
        private ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        protected double tuition() {
            return 20000;
        }

        @Override
        public double transportFee() {
            return 12000;
        }

        @Override
        protected double totalFee() {
            return tuition() + transportFee();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Student[] students = new Student[count];

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String name = scanner.next();
            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    students[i] = new ScholarshipStudent(name);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }
        }

        double total = 0;
        for (Student student : students) {
            double fee = student.totalFee();
            total += fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
        scanner.close();
    }
}
