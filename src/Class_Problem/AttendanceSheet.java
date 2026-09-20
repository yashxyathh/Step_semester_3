public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maximumClassSize) {
        presentStudents = new String[maximumClassSize];
    }

    public void markPresent(String name) {
        if (presentCount < presentStudents.length && !isPresent(name)) {
            presentStudents[presentCount] = name;
            presentCount++;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}
