package com.chandankumar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WordleDataset {
    private static final String filePath = "C:\\Users\\Chandan Kumar\\Documents\\VIT Java Programs\\src\\com\\chandankumar\\words.txt";


    public static Set<String> getWordsSet() throws IOException {
        Set<String> wordsSet = new HashSet<>();

        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null)
            wordsSet.add(line);

        return wordsSet;
    }
}
