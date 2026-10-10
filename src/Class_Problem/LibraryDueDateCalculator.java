import java.time.LocalDate;
import java.util.Scanner;

public class LibraryDueDateCalculator {
    private static abstract class LibraryItem {
        protected final String title;

        protected LibraryItem(String title) {
            this.title = title;
        }

        public abstract LocalDate getDueDate(LocalDate currentDate);
    }

    private static class Book extends LibraryItem {
        private Book(String title) {
            super(title);
        }

        @Override
        public LocalDate getDueDate(LocalDate currentDate) {
            return currentDate.plusDays(14);
        }
    }

    private static class Dvd extends LibraryItem {
        private Dvd(String title) {
            super(title);
        }

        @Override
        public LocalDate getDueDate(LocalDate currentDate) {
            return currentDate.plusDays(7);
        }
    }

    private static class Magazine extends LibraryItem {
        private Magazine(String title) {
            super(title);
        }

        @Override
        public LocalDate getDueDate(LocalDate currentDate) {
            return currentDate.plusDays(3);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int itemCount = Integer.parseInt(scanner.nextLine().trim());
        LibraryItem[] items = new LibraryItem[itemCount];
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < itemCount; i++) {
            String line = scanner.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf(' ') + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equals("DVD")) {
                items[i] = new Dvd(title);
            } else {
                items[i] = new Magazine(title);
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.getDueDate(currentDate));
        }
        scanner.close();
    }
}
