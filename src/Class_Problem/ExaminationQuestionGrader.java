import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExaminationQuestionGrader {
    private static abstract class Question {
        protected final String type;
        protected final String correctAnswer;
        protected final String studentAnswer;
        protected final double points;

        protected Question(String type, String correctAnswer, String studentAnswer, double points) {
            this.type = type;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public abstract double grade();
    }

    private static class ObjectiveQuestion extends Question {
        private ObjectiveQuestion(String type, String correctAnswer, String studentAnswer, double points) {
            super(type, correctAnswer, studentAnswer, points);
        }

        @Override
        public double grade() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }
    }

    private static class EssayQuestion extends Question {
        private EssayQuestion(String correctAnswer, String studentAnswer, double points) {
            super("ESSAY", correctAnswer, studentAnswer, points);
        }

        @Override
        public double grade() {
            int matchedKeywords = 0;
            String answer = studentAnswer.toLowerCase();
            String[] keywords = correctAnswer.split(",");

            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase())) {
                    matchedKeywords++;
                }
            }

            if (matchedKeywords >= 2) {
                return points * 0.75;
            }
            if (matchedKeywords == 1) {
                return points * 0.5;
            }
            return 0;
        }
    }

    private static List<String> readQuotedFields(String line) {
        List<String> fields = new ArrayList<>();
        int index = 0;

        while (index < line.length()) {
            while (index < line.length() && line.charAt(index) == ' ') {
                index++;
            }

            if (index < line.length() && line.charAt(index) == '"') {
                int end = line.indexOf('"', index + 1);
                fields.add(line.substring(index + 1, end));
                index = end + 1;
            } else {
                int end = index;
                while (end < line.length() && line.charAt(end) != ' ') {
                    end++;
                }
                fields.add(line.substring(index, end));
                index = end;
            }
        }

        return fields;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int questionCount = Integer.parseInt(scanner.nextLine().trim());
        Question[] questions = new Question[questionCount];

        for (int i = 0; i < questionCount; i++) {
            List<String> fields = readQuotedFields(scanner.nextLine().trim());
            String type = fields.get(0);
            String correctAnswer = fields.get(2);
            String studentAnswer = fields.get(3);
            double points = Double.parseDouble(fields.get(4));

            if (type.equals("ESSAY")) {
                questions[i] = new EssayQuestion(correctAnswer, studentAnswer, points);
            } else {
                questions[i] = new ObjectiveQuestion(type, correctAnswer, studentAnswer, points);
            }
        }

        double totalScore = 0;
        for (Question question : questions) {
            double score = question.grade();
            totalScore += score;
            System.out.printf("%s: %.2f%n", question.type, score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
        scanner.close();
    }
}
