import java.util.Scanner;

public class PublicTransportFareCalculator {
    private static abstract class Transport {
        protected final double distance;

        protected Transport(double distance) {
            this.distance = distance;
        }

        public abstract double calculateFare();
    }

    private static class Bus extends Transport {
        private Bus(double distance) {
            super(distance);
        }

        @Override
        public double calculateFare() {
            return Math.min(10, 2 + 0.1 * distance);
        }
    }

    private static class Train extends Transport {
        private Train(double distance) {
            super(distance);
        }

        @Override
        public double calculateFare() {
            return 3 + 0.15 * distance;
        }
    }

    private static class Metro extends Transport {
        private final double peakHourFactor;

        private Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        public double calculateFare() {
            return (1.5 + 0.2 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int journeyCount = scanner.nextInt();
        Transport[] transports = new Transport[journeyCount];
        String[] types = new String[journeyCount];

        for (int i = 0; i < journeyCount; i++) {
            types[i] = scanner.next();
            double distance = scanner.nextDouble();

            if (types[i].equals("BUS")) {
                transports[i] = new Bus(distance);
            } else if (types[i].equals("TRAIN")) {
                transports[i] = new Train(distance);
            } else {
                transports[i] = new Metro(distance, scanner.nextDouble());
            }
        }

        double total = 0;
        for (int i = 0; i < transports.length; i++) {
            double fare = transports[i].calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", types[i], fare);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
