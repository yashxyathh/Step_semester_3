public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        }
        if (password.length() < 10) {
            return "Medium";
        }
        return "Strong";
    }

    public static void main(String[] args) {
        PasswordChecker firstPassword = new PasswordChecker("abcd");
        PasswordChecker secondPassword = new PasswordChecker("abcdefghij");

        System.out.println(firstPassword.getStrength());
        System.out.println(secondPassword.getStrength());
    }
}
