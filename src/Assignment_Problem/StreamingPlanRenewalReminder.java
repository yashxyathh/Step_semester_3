import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {
    private static abstract class Plan {
        protected final String name;
        protected final LocalDate startDate;

        protected Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        protected abstract LocalDate renewalDate();
    }

    private static class BasicPlan extends Plan {
        private BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        protected LocalDate renewalDate() {
            return startDate.plusDays(30);
        }
    }

    private static class StandardPlan extends Plan {
        private StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        protected LocalDate renewalDate() {
            return startDate.plusDays(90);
        }
    }

    private static class PremiumPlan extends Plan {
        private PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        protected LocalDate renewalDate() {
            return startDate.plusDays(365);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Plan[] plans = new Plan[count];

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());
            switch (type) {
                case "BASIC" -> plans[i] = new BasicPlan(name, startDate);
                case "STANDARD" -> plans[i] = new StandardPlan(name, startDate);
                case "PREMIUM" -> plans[i] = new PremiumPlan(name, startDate);
                default -> throw new IllegalArgumentException("Invalid plan type");
            }
        }

        for (Plan plan : plans) {
            System.out.printf("%s: %s%n", plan.name, plan.renewalDate());
        }
        scanner.close();
    }
}
