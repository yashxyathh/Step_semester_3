public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        color = "RED";
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight("TL-9");
        System.out.println(trafficLight.getColor());
        trafficLight.next();
        System.out.println(trafficLight.getColor());
        trafficLight.next();
        System.out.println(trafficLight.getColor());
        trafficLight.next();
        System.out.println(trafficLight.getColor());
    }
}
