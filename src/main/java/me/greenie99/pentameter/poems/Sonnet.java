package me.greenie99.pentameter.poems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Greenie
 * @github techtide
 */
public class Sonnet {
    
    public static enum SonnetStyle {
        ITALIAN,
        ENGLISH
    }
    
    private final File file;
    private final int wordCount;
    private final SonnetStyle style;
    private final StringBuilder text;
    
    public Sonnet(File sonnetText, SonnetStyle sonnetStyle) throws FileNotFoundException, IOException {
        this.file = sonnetText;
        this.text = getText(sonnetText);
        this.style = sonnetStyle;
        this.wordCount = calculateWordCount(sonnetText);
    }
    
    private int calculateWordCount(File textFile) throws FileNotFoundException, IOException {
        InputStream stream = new FileInputStream(file.getPath());
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        int currentWordCount = 0;
        
        while((line = reader.readLine()) != null) {
            currentWordCount += 1;
        }
        
        return currentWordCount;
    }
    
    private StringBuilder getText(File textFile) throws IOException {
        InputStream stream = new FileInputStream(file.getPath());
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        StringBuilder superficialBuilder = new StringBuilder();
        
        while((line = reader.readLine()) != null) {
            superficialBuilder.append(line);
        }
        
        return superficialBuilder;
    }
    
}