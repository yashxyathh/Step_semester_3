public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        int total = 0;
        for (int runs : row) {
            total += runs;
        }
        return (double) total / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }

            result.append("Match ").append(i).append(": ");
            if (rowAverage(runsPerOver[i]) >= threshold) {
                result.append("Power Surge");
            } else {
                result.append("Normal");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        System.out.println(classifyMatches(runsPerOver, 8));
    }
}
