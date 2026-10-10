import java.util.Scanner;

public class CampusParkingChargeCalculator {
    private static abstract class Vehicle {
        protected final int hours;

        protected Vehicle(int hours) {
            this.hours = hours;
        }

        protected abstract double charge();
    }

    private static class Bike extends Vehicle {
        private Bike(int hours) {
            super(hours);
        }

        @Override
        protected double charge() {
            return hours * 10;
        }
    }

    private static class Car extends Vehicle {
        private Car(int hours) {
            super(hours);
        }

        @Override
        protected double charge() {
            return 30 + (hours - 1) * 20;
        }
    }

    private static class Truck extends Vehicle {
        private Truck(int hours) {
            super(hours);
        }

        @Override
        protected double charge() {
            return Math.max(100, hours * 50);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Vehicle[] vehicles = new Vehicle[count];
        String[] types = new String[count];

        for (int i = 0; i < count; i++) {
            types[i] = scanner.next();
            int hours = scanner.nextInt();
            switch (types[i]) {
                case "BIKE" -> vehicles[i] = new Bike(hours);
                case "CAR" -> vehicles[i] = new Car(hours);
                case "TRUCK" -> vehicles[i] = new Truck(hours);
                default -> throw new IllegalArgumentException("Invalid vehicle type");
            }
        }

        double total = 0;
        for (int i = 0; i < count; i++) {
            double charge = vehicles[i].charge();
            total += charge;
            System.out.printf("%s: %.2f%n", types[i], charge);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
