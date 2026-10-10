import java.util.Scanner;

public class CityCabFareMeter {
    private interface NightService {
        boolean availableAtNight();
    }

    private static abstract class Cab {
        protected final double kilometres;

        protected Cab(double kilometres) {
            this.kilometres = kilometres;
        }

        protected abstract double rate();

        protected double fare() {
            return Math.max(100, kilometres * rate());
        }
    }

    private static class Mini extends Cab implements NightService {
        private Mini(double kilometres) {
            super(kilometres);
        }

        @Override
        protected double rate() {
            return 10;
        }

        @Override
        public boolean availableAtNight() {
            return false;
        }
    }

    private static class Sedan extends Cab implements NightService {
        private Sedan(double kilometres) {
            super(kilometres);
        }

        @Override
        protected double rate() {
            return 14;
        }

        @Override
        public boolean availableAtNight() {
            return true;
        }
    }

    private static class Suv extends Cab implements NightService {
        private Suv(double kilometres) {
            super(kilometres);
        }

        @Override
        protected double rate() {
            return 18;
        }

        @Override
        public boolean availableAtNight() {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Cab[] cabs = new Cab[count];
        String[] types = new String[count];
        String[] times = new String[count];

        for (int i = 0; i < count; i++) {
            types[i] = scanner.next();
            double kilometres = scanner.nextDouble();
            times[i] = scanner.next();
            switch (types[i]) {
                case "MINI":
                    cabs[i] = new Mini(kilometres);
                    break;
                case "SEDAN":
                    cabs[i] = new Sedan(kilometres);
                    break;
                case "SUV":
                    cabs[i] = new Suv(kilometres);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }
        }

        double total = 0;
        for (int i = 0; i < count; i++) {
            boolean rejected = "NIGHT".equals(times[i])
                    && !((NightService) cabs[i]).availableAtNight();
            if (rejected) {
                System.out.printf("%s: night service not available%n", types[i]);
                continue;
            }

            double fare = cabs[i].fare();
            if ("NIGHT".equals(times[i])) {
                fare *= 1.20;
            }
            total += fare;
            System.out.printf("%s: %.2f%n", types[i], fare);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
