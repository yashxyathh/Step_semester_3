import java.util.Scanner;

public class LibraryIsbnValidator {
    public static String normalizeCode(String raw) {
        String code = raw.trim();
        if (code.length() < 3) {
            return code.toUpperCase();
        }
        return code.substring(0, 3).toUpperCase() + code.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("[").append(code.substring(0, 3)).append("] YEAR: ");
        result.append(code.substring(3, 7)).append(" | CATALOG: ");
        result.append(code.substring(7));
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = normalizeCode(scanner.nextLine());
        System.out.println(validateAndFormat(code));
        scanner.close();
    }
}
