import java.util.Scanner;

public class DeliveryFeeCalculator {
    private static abstract class Delivery {
        protected final double weight;
        protected final double distance;

        protected Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public abstract double calculateFee();
    }

    private static class StandardDelivery extends Delivery {
        private StandardDelivery(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        public double calculateFee() {
            return 5 + 0.5 * weight + 0.1 * distance;
        }
    }

    private static class ExpressDelivery extends Delivery {
        private ExpressDelivery(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        public double calculateFee() {
            return 15 + weight + 0.2 * distance;
        }
    }

    private static class InternationalDelivery extends Delivery {
        private final double customsFee;

        private InternationalDelivery(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        public double calculateFee() {
            return 25 + 2 * weight + 0.5 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int deliveryCount = scanner.nextInt();
        Delivery[] deliveries = new Delivery[deliveryCount];
        String[] types = new String[deliveryCount];

        for (int i = 0; i < deliveryCount; i++) {
            types[i] = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();

            if (types[i].equals("STANDARD")) {
                deliveries[i] = new StandardDelivery(weight, distance);
            } else if (types[i].equals("EXPRESS")) {
                deliveries[i] = new ExpressDelivery(weight, distance);
            } else {
                double customsFee = scanner.nextDouble();
                deliveries[i] = new InternationalDelivery(weight, distance, customsFee);
            }
        }

        double total = 0;
        for (int i = 0; i < deliveries.length; i++) {
            double fee = deliveries[i].calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", types[i], fee);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
