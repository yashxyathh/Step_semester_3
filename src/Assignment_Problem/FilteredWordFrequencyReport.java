import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class FilteredWordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>();
        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        String cleanedFeedback = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleanedFeedback.trim().split("\\s+");
        Map<String, Integer> frequencies = new HashMap<>();

        for (String word : words) {
            if (!stopWords.contains(word)) {
                frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencies.entrySet());
        entries.sort((first, second) -> second.getValue() - first.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printFilteredWordFrequency(scanner.nextLine());
        scanner.close();
    }
}
