package com.chandankumar;


import java.util.List;

public interface IWordle {
    char CORRECT_POSITION = 'C';
    char INCORRECT_POSITION = 'A';
    char NOT_AVAILABLE = 'N';
    char FLAG = '0';

    boolean isGuessedWordAvailableInDataSource(String userGuessedWord);

    boolean isGuessedWordCorrect(String userGuessedWord);

    int getCounter();

    String getComputerGuessedWord();

    List<Character> getPositions(String userGuessedWord);

    void play();

}
