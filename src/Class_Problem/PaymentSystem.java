import java.util.Scanner;

public class PaymentSystem {
    private static abstract class Payment {
        protected final double amount;

        protected Payment(double amount) {
            this.amount = amount;
        }

        public abstract double calculateFinalAmount();
    }

    private static class CardPayment extends Payment {
        private CardPayment(double amount) {
            super(amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount * 1.02;
        }
    }

    private static class WalletPayment extends Payment {
        private WalletPayment(double amount) {
            super(amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount * 1.01;
        }
    }

    private static class BankTransferPayment extends Payment {
        private BankTransferPayment(double amount) {
            super(amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int transactionCount = scanner.nextInt();
        Payment[] payments = new Payment[transactionCount];
        String[] types = new String[transactionCount];

        for (int i = 0; i < transactionCount; i++) {
            types[i] = scanner.next();
            double amount = scanner.nextDouble();

            if (types[i].equals("CARD")) {
                payments[i] = new CardPayment(amount);
            } else if (types[i].equals("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } else {
                payments[i] = new BankTransferPayment(amount);
            }
        }

        double total = 0;
        for (int i = 0; i < payments.length; i++) {
            double adjustedAmount = payments[i].calculateFinalAmount();
            total += adjustedAmount;
            System.out.printf("%s: %.2f%n", types[i], adjustedAmount);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
