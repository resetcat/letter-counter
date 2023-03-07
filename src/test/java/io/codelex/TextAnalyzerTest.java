package io.codelex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TextAnalyzerTest {

    private TextAnalyzer textAnalyzer;

    @Before
    public void setup() {
        String filePath = "src/test/resources/testfile.txt";
        textAnalyzer = new TextAnalyzer(filePath);
    }

    @Test
    public void testFrequencyCounter() {
        Map<Character, Long> expectedFrequency = Map.of(
                'A', 3L,
                'B', 2L,
                'C', 1L,
                'D', 1L,
                'E', 2L,
                'F', 1L,
                'G', 1L
        );
        Map<Character, Long> actualFrequency = textAnalyzer.frequencyCounter("AAABBCDEEFG");
        Assert.assertEquals(expectedFrequency, actualFrequency);
    }

    @Test
    public void testCreateStringFromFile() {
        String expectedText = "HELLOHELLOHELLO";
        String actualText = textAnalyzer.createStringFromFile("src/test/resources/testfile.txt");
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testCreateStringFromFileWithEmptyFile() throws IOException {
        File tempFile = File.createTempFile("empty", "file");
        String filePath = tempFile.getAbsolutePath();
        String expectedText = "";
        String actualText = textAnalyzer.createStringFromFile(filePath);
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testCreateStringFromFileWithMissingFile() {
        String expectedText = "";
        String actualText = textAnalyzer.createStringFromFile("nonexistentfile.txt");
        Assert.assertEquals(expectedText, actualText);
    }


    @Test
    public void testCreateStringFromFileWithInvalidFilePath() {
        String expectedText = "";
        String actualText = textAnalyzer.createStringFromFile("invalidpath:/file.txt");
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testCreateStringFromFileWithDirectory() {
        String expectedText = "";
        String actualText = textAnalyzer.createStringFromFile("src/test/resources");
        Assert.assertEquals(expectedText, actualText);
    }
}
