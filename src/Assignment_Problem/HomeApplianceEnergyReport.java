import java.util.Scanner;

public class HomeApplianceEnergyReport {
    private interface SaverMode {
        boolean supportsSaverMode();
    }

    private static abstract class Appliance {
        protected final double hours;

        protected Appliance(double hours) {
            this.hours = hours;
        }

        protected abstract double power();

        protected double units() {
            return power() * hours / 1000;
        }

        protected double cost() {
            return units() * 8;
        }
    }

    private static class Fridge extends Appliance implements SaverMode {
        private Fridge(double hours) {
            super(hours);
        }

        @Override
        protected double power() {
            return 150;
        }

        @Override
        public boolean supportsSaverMode() {
            return false;
        }
    }

    private static class AirConditioner extends Appliance implements SaverMode {
        private final boolean saver;

        private AirConditioner(double hours, boolean saver) {
            super(hours);
            this.saver = saver;
        }

        @Override
        protected double power() {
            return 1500;
        }

        @Override
        protected double units() {
            return saver ? super.units() * 0.75 : super.units();
        }

        @Override
        public boolean supportsSaverMode() {
            return true;
        }
    }

    private static class Tv extends Appliance implements SaverMode {
        private Tv(double hours) {
            super(hours);
        }

        @Override
        protected double power() {
            return 100;
        }

        @Override
        public boolean supportsSaverMode() {
            return false;
        }
    }

    private static class Washer extends Appliance implements SaverMode {
        private final boolean saver;

        private Washer(double hours, boolean saver) {
            super(hours);
            this.saver = saver;
        }

        @Override
        protected double power() {
            return 500;
        }

        @Override
        protected double units() {
            return saver ? super.units() * 0.75 : super.units();
        }

        @Override
        public boolean supportsSaverMode() {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Appliance[] appliances = new Appliance[count];
        String[] names = new String[count];
        boolean[] saverRequested = new boolean[count];

        for (int i = 0; i < count; i++) {
            names[i] = scanner.next();
            double hours = scanner.nextDouble();
            saverRequested[i] = scanner.hasNext("SAVER");
            if (saverRequested[i]) {
                scanner.next();
            }

            switch (names[i]) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;
                case "AC":
                    appliances[i] = new AirConditioner(hours, saverRequested[i]);
                    break;
                case "TV":
                    appliances[i] = new Tv(hours);
                    break;
                case "WASHER":
                    appliances[i] = new Washer(hours, saverRequested[i]);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid appliance type");
            }
        }

        double total = 0;
        for (int i = 0; i < count; i++) {
            if (saverRequested[i] && !((SaverMode) appliances[i]).supportsSaverMode()) {
                System.out.printf("%s: saver mode not supported%n", names[i]);
                continue;
            }

            double units = appliances[i].units();
            double cost = appliances[i].cost();
            total += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", names[i], units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", total);
        scanner.close();
    }
}
