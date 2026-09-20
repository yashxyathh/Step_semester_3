public final class NameTag {
    private final String firstName;
    private final char lastInitial;

    public NameTag(String fullName) {
        String[] nameParts = fullName.split(" ");
        firstName = nameParts[0];
        lastInitial = nameParts[1].charAt(0);
    }

    public String getNickname() {
        return firstName + " " + lastInitial + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
