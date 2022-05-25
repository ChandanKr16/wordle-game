package com.chandankumar;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;

public class Main {
    private static Scanner sc;
    private static Set<String> wordsSet;
    private static IWordle wordleGame;
    private static final int MAX_TRIES = 6;

    private static void init() throws IOException {
        sc = new Scanner(System.in);
        wordsSet = WordleDataset.getWordsSet();
        wordleGame = new Wordle(wordsSet);
        wordleGame.play();
    }

    private static void print(String userGuessedWord, String position) {
        System.out.println("=====");
        System.out.println(userGuessedWord);
        System.out.println(position);
        System.out.println("=====");
    }

    private static String join(List<Character> positions){
        StringJoiner stringJoiner = new StringJoiner("");
        positions.forEach((charPosition) -> {
                    stringJoiner.add("" + charPosition);
                });

        return stringJoiner.toString();
    }

    public static void main(String[] args) throws IOException {

        init();

        while (wordleGame.getCounter() < MAX_TRIES) {

            System.out.println("Enter a 5 char word which is guessed by computer: ");
            String userGuessedWord = sc.next();

            if (wordleGame.isGuessedWordAvailableInDataSource(userGuessedWord)) {
                if (wordleGame.isGuessedWordCorrect(userGuessedWord)) {
                    System.out.println("You have guessed the word in " + wordleGame.getCounter() + " trie.");
                    System.out.println("Good bye");
                    System.exit(0);
                } else {
                    String position = join(wordleGame.getPositions(userGuessedWord));
                    print(userGuessedWord, position);
                }
            } else {
                System.out.println("Word not available in data source");
            }
        }

        System.out.println("Correct word is : " + wordleGame.getComputerGuessedWord());

    }

}
