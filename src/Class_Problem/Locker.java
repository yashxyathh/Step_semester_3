public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        System.out.println(locker.changeCode("1234", "5678") ? "success" : "rejected");
        System.out.println(locker.changeCode("0000", "9999") ? "success" : "rejected");
    }
}
