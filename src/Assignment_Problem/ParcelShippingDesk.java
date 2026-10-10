import java.util.Scanner;

public class ParcelShippingDesk {
    private interface Insurable {
        double insurance();
    }

    private static abstract class Parcel {
        protected final double weight;
        protected final double declaredValue;

        protected Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        protected abstract double charge();

        protected double insurance() {
            return 0;
        }
    }

    private static class StandardParcel extends Parcel {
        private StandardParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        protected double charge() {
            return 40 + 10 * weight;
        }
    }

    private static class ExpressParcel extends Parcel implements Insurable {
        private ExpressParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        protected double charge() {
            return 80 + 15 * weight;
        }

        @Override
        public double insurance() {
            return declaredValue * 0.02;
        }
    }

    private static class FragileParcel extends Parcel implements Insurable {
        private FragileParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        protected double charge() {
            return 40 + 10 * weight + 50;
        }

        @Override
        public double insurance() {
            return declaredValue * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Parcel[] parcels = new Parcel[count];
        String[] types = new String[count];

        for (int i = 0; i < count; i++) {
            types[i] = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();
            switch (types[i]) {
                case "STANDARD":
                    parcels[i] = new StandardParcel(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcels[i] = new ExpressParcel(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcels[i] = new FragileParcel(weight, declaredValue);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid parcel type");
            }
        }

        double grandTotal = 0;
        for (int i = 0; i < count; i++) {
            double charge = parcels[i].charge();
            double insurance = parcels[i] instanceof Insurable
                    ? ((Insurable) parcels[i]).insurance()
                    : parcels[i].insurance();
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    types[i], charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
