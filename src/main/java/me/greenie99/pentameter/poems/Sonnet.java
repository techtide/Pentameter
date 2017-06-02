package me.greenie99.pentameter.poems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Greenie
 * @github techtide
 */

public final class Sonnet {
    
    private final File file;
    private final int wordCount;
    private final SonnetStyle style;
    private final StringBuilder fullText;
    private final List<String> textByLine;
    
    public Sonnet(File sonnetText, SonnetStyle sonnetStyle) throws FileNotFoundException, IOException {
        this.textByLine = getTextByLine(sonnetText);
        this.file = sonnetText;
        this.fullText = setText(sonnetText);
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
    
    private StringBuilder setText(File textFile) throws IOException {
        InputStream stream = new FileInputStream(file.getPath());
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        StringBuilder superficialBuilder = new StringBuilder();
        
        while((line = reader.readLine()) != null) {
            superficialBuilder.append(line);
        }
        
        return superficialBuilder;
    }
    
    private List<String> setTextByLine(File textFile) throws IOException {
        List<String> x = new ArrayList<>();
        
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(textFile.getName()));
            x = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
        }
        
        return x;
    }
    
        
    public static enum SonnetStyle {
        ITALIAN,
        ENGLISH
    }

    public File getFile() {
        return file;
    }

    public int getWordCount() {
        return wordCount;
    }

    public SonnetStyle getStyle() {
        return style;
    }

    public StringBuilder getFullText() {
        return fullText;
    }

    public List<String> getTextByLine(File sonnetText) {
        return this.textByLine;
    }
    
}