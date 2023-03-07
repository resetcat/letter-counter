package io.codelex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class TextAnalyzer {
    private final String text;

    public TextAnalyzer(String filePath) {
        this.text = createStringFromFile(filePath);
    }

    public void analyze() {
        Map<Character, Long> frequency = frequencyCounter(text);
        System.out.println(frequency);
    }

    public Map<Character, Long> frequencyCounter(String text) {
        return text.chars()
                   .mapToObj(a -> (char) a)
                   .collect(Collectors.groupingBy(b -> b, Collectors.counting()));
    }

    public String createStringFromFile(String directory) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(directory))) {
            String line;
            while ((line = in.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return "";
        }
        return text.toString().toUpperCase().replaceAll("[^A-Z]", "");
    }
}
