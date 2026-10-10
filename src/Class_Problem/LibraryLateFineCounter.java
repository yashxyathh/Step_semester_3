import java.util.Scanner;

public class LibraryLateFineCounter {
    private static abstract class LibraryItem {
        protected final String title;
        protected final int daysLate;

        protected LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        public abstract double calculateFine();
    }

    private static class Book extends LibraryItem {
        private Book(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return daysLate * 2;
        }
    }

    private static class Dvd extends LibraryItem {
        private Dvd(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return Math.min(daysLate * 5, 50);
        }
    }

    private static class Magazine extends LibraryItem {
        private Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return daysLate;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int itemCount = scanner.nextInt();
        LibraryItem[] items = new LibraryItem[itemCount];

        for (int i = 0; i < itemCount; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            if (type.equals("BOOK")) {
                items[i] = new Book(title, daysLate);
            } else if (type.equals("DVD")) {
                items[i] = new Dvd(title, daysLate);
            } else {
                items[i] = new Magazine(title, daysLate);
            }
        }

        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
        scanner.close();
    }
}
