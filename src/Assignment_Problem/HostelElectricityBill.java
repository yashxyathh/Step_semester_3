import java.util.Scanner;

public class HostelElectricityBill {
    private static abstract class Room {
        protected final int units;

        protected Room(int units) {
            this.units = units;
        }

        protected abstract double bill();
    }

    private static class SingleRoom extends Room {
        private SingleRoom(int units) {
            super(units);
        }

        @Override
        protected double bill() {
            return units * 8;
        }
    }

    private static class SharedRoom extends Room {
        private final int occupants;

        private SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        protected double bill() {
            return units * 6.0 / occupants;
        }
    }

    private static class AcRoom extends Room {
        private AcRoom(int units) {
            super(units);
        }

        @Override
        protected double bill() {
            return units * 10 + 200;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Room[] rooms = new Room[count];
        String[] types = new String[count];

        for (int i = 0; i < count; i++) {
            types[i] = scanner.next();
            int units = scanner.nextInt();
            switch (types[i]) {
                case "SINGLE" -> rooms[i] = new SingleRoom(units);
                case "SHARED" -> rooms[i] = new SharedRoom(units, scanner.nextInt());
                case "AC" -> rooms[i] = new AcRoom(units);
                default -> throw new IllegalArgumentException("Invalid room type");
            }
        }

        double total = 0;
        for (int i = 0; i < count; i++) {
            double bill = rooms[i].bill();
            total += bill;
            System.out.printf("%s: %.2f%n", types[i], bill);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
