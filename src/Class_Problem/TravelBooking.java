import java.util.Scanner;

public class TravelBooking {
    private static abstract class Booking {
        private static final double BOOKING_FEE = 50;
        protected final double distanceKm;

        protected Booking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        protected abstract double calculateBaseFare();

        public final double calculateTotal() {
            return calculateBaseFare() + BOOKING_FEE;
        }
    }

    private static class BusBooking extends Booking {
        private BusBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        protected double calculateBaseFare() {
            return distanceKm * 2;
        }
    }

    private static class TrainBooking extends Booking {
        private TrainBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        protected double calculateBaseFare() {
            return distanceKm * 1.5;
        }
    }

    private static class FlightBooking extends Booking {
        private FlightBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        protected double calculateBaseFare() {
            return 2500 + distanceKm * 4;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookingCount = scanner.nextInt();
        Booking[] bookings = new Booking[bookingCount];
        String[] modes = new String[bookingCount];

        for (int i = 0; i < bookingCount; i++) {
            modes[i] = scanner.next();
            double distanceKm = scanner.nextDouble();

            if (modes[i].equals("BUS")) {
                bookings[i] = new BusBooking(distanceKm);
            } else if (modes[i].equals("TRAIN")) {
                bookings[i] = new TrainBooking(distanceKm);
            } else {
                bookings[i] = new FlightBooking(distanceKm);
            }
        }

        for (int i = 0; i < bookings.length; i++) {
            System.out.printf("%s: %.2f%n", modes[i], bookings[i].calculateTotal());
        }
        scanner.close();
    }
}
