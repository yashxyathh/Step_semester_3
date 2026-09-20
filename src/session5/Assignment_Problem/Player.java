import java.util.Arrays;

public class Player implements Comparable<Player> {
    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, battingAverage);
    }

    public static String draftAndRank(Player[] players) {
        int draftableCount = 0;

        for (Player player : players) {
            if (isDraftable(player.matchesPlayed) || isDraftable(player.matchesPlayed, player.injured)) {
                draftableCount++;
            }
        }

        Player[] draftablePlayers = new Player[draftableCount];
        int index = 0;

        for (Player player : players) {
            if (isDraftable(player.matchesPlayed) || isDraftable(player.matchesPlayed, player.injured)) {
                draftablePlayers[index++] = player;
            }
        }

        Arrays.sort(draftablePlayers);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftablePlayers.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(draftablePlayers[i].name);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
