import java.util.Scanner;

public class ElectricityConnectionBilling {
    private static abstract class Connection {
        protected final int units;

        protected Connection(int units) {
            this.units = units;
        }

        public abstract double calculateBill();
    }

    private static class Home extends Connection {
        private Home(int units) {
            super(units);
        }

        @Override
        public double calculateBill() {
            if (units <= 100) {
                return units * 5;
            }
            return 100 * 5 + (units - 100) * 7;
        }
    }

    private static class Shop extends Connection {
        private Shop(int units) {
            super(units);
        }

        @Override
        public double calculateBill() {
            return units * 8 + 100;
        }
    }

    private static class Factory extends Connection {
        private Factory(int units) {
            super(units);
        }

        @Override
        public double calculateBill() {
            return Math.max(1000, units * 6);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int connectionCount = scanner.nextInt();
        Connection[] connections = new Connection[connectionCount];
        String[] types = new String[connectionCount];

        for (int i = 0; i < connectionCount; i++) {
            types[i] = scanner.next();
            int units = scanner.nextInt();

            if (types[i].equals("HOME")) {
                connections[i] = new Home(units);
            } else if (types[i].equals("SHOP")) {
                connections[i] = new Shop(units);
            } else {
                connections[i] = new Factory(units);
            }
        }

        double total = 0;
        for (int i = 0; i < connections.length; i++) {
            double bill = connections[i].calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", types[i], bill);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
