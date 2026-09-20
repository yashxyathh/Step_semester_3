public class Student {
    private String name;
    private double attendance;
    private static String collegeName = "SRM Institute of Science and Technology";
    private static int studentCount;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new Student("Ravi", 92.5);
        new Student("Anitha", 88.0);
        Student.printCollegeInfo();
    }
}
