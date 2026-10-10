import java.util.Scanner;

public class MovieTicketCounter {
    private static abstract class Ticket {
        private static final double CONVENIENCE_FEE = 20;
        private final int count;

        protected Ticket(int count) {
            this.count = count;
        }

        protected abstract double price();

        protected double amount() {
            return count * (price() + CONVENIENCE_FEE);
        }
    }

    private static class RegularTicket extends Ticket {
        private RegularTicket(int count) {
            super(count);
        }

        @Override
        protected double price() {
            return 150;
        }
    }

    private static class PremiumTicket extends Ticket {
        private PremiumTicket(int count) {
            super(count);
        }

        @Override
        protected double price() {
            return 250;
        }
    }

    private static class ReclinerTicket extends Ticket {
        private ReclinerTicket(int count) {
            super(count);
        }

        @Override
        protected double price() {
            return 400;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Ticket[] tickets = new Ticket[count];
        String[] seats = new String[count];

        for (int i = 0; i < count; i++) {
            seats[i] = scanner.next();
            int ticketCount = scanner.nextInt();
            switch (seats[i]) {
                case "REGULAR":
                    tickets[i] = new RegularTicket(ticketCount);
                    break;
                case "PREMIUM":
                    tickets[i] = new PremiumTicket(ticketCount);
                    break;
                case "RECLINER":
                    tickets[i] = new ReclinerTicket(ticketCount);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid seat type");
            }
        }

        double total = 0;
        for (int i = 0; i < count; i++) {
            double amount = tickets[i].amount();
            total += amount;
            System.out.printf("%s: %.2f%n", seats[i], amount);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
