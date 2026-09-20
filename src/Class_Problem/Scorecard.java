public class Scorecard {
    private final boolean[] results;
    private int recordedAnswers;
    private int score;

    public Scorecard(int questionCount) {
        results = new boolean[questionCount];
    }

    public void recordAnswer(boolean correct) {
        if (recordedAnswers < results.length) {
            results[recordedAnswers] = correct;
            recordedAnswers++;
            if (correct) {
                score++;
            }
        }
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        Scorecard scorecard = new Scorecard(4);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(false);
        scorecard.recordAnswer(true);
        System.out.println(scorecard.getScore());
    }
}
