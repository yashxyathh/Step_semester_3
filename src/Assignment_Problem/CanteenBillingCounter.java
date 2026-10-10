import java.util.Scanner;

public class CanteenBillingCounter {
    private static abstract class Bill {
        protected final double amount;

        protected Bill(double amount) {
            this.amount = amount;
        }

        protected abstract double finalAmount();
    }

    private static class StudentBill extends Bill {
        private StudentBill(double amount) {
            super(amount);
        }

        @Override
        protected double finalAmount() {
            return amount * 0.90;
        }
    }

    private static class StaffBill extends Bill {
        private StaffBill(double amount) {
            super(amount);
        }

        @Override
        protected double finalAmount() {
            return amount * 0.95;
        }
    }

    private static class GuestBill extends Bill {
        private GuestBill(double amount) {
            super(amount);
        }

        @Override
        protected double finalAmount() {
            return amount + 10;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Bill[] bills = new Bill[count];
        String[] types = new String[count];

        for (int i = 0; i < count; i++) {
            types[i] = scanner.next();
            double amount = scanner.nextDouble();
            switch (types[i]) {
                case "STUDENT" -> bills[i] = new StudentBill(amount);
                case "STAFF" -> bills[i] = new StaffBill(amount);
                case "GUEST" -> bills[i] = new GuestBill(amount);
                default -> throw new IllegalArgumentException("Invalid customer type");
            }
        }

        double total = 0;
        for (int i = 0; i < count; i++) {
            double finalAmount = bills[i].finalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", types[i], finalAmount);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
