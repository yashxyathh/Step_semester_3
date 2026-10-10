import java.util.Scanner;

public class GardenPlotAreaReport {
    private static abstract class Plot {
        protected final String owner;

        protected Plot(String owner) {
            this.owner = owner;
        }

        public abstract double getArea();
    }

    private static class Circle extends Plot {
        private final double radius;

        private Circle(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    private static class Rectangle extends Plot {
        private final double length;
        private final double width;

        private Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return length * width;
        }
    }

    private static class Triangle extends Plot {
        private final double base;
        private final double height;

        private Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        @Override
        public double getArea() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plotCount = scanner.nextInt();
        Plot[] plots = new Plot[plotCount];
        String[] shapes = new String[plotCount];

        for (int i = 0; i < plotCount; i++) {
            shapes[i] = scanner.next();
            String owner = scanner.next();

            if (shapes[i].equals("CIRCLE")) {
                plots[i] = new Circle(owner, scanner.nextDouble());
            } else if (shapes[i].equals("RECTANGLE")) {
                plots[i] = new Rectangle(owner, scanner.nextDouble(), scanner.nextDouble());
            } else {
                plots[i] = new Triangle(owner, scanner.nextDouble(), scanner.nextDouble());
            }
        }

        double totalArea = 0;
        for (int i = 0; i < plots.length; i++) {
            double area = plots[i].getArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", plots[i].owner, shapes[i], area);
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
        scanner.close();
    }
}
