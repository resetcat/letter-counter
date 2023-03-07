package io.codelex;

public class Main {
    public static void main(String[] args) {
        TextAnalyzer analyzer = new TextAnalyzer("src/main/resources/text.txt");
        analyzer.analyze();
    }
}

