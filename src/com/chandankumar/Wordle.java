package com.chandankumar;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Wordle implements IWordle {

    private Set<String> wordsSet;
    private String computerGuessedWord;
    private int counter;

    public Wordle(Set<String> wordsSet){
        this.wordsSet = wordsSet;
        this.counter = 0;
    }

    @Override
    public boolean isGuessedWordAvailableInDataSource(String userGuessedWord) {
        if(wordsSet.contains(userGuessedWord)){
            ++counter;
            return true;
        }
        return false;
    }

    @Override
    public boolean isGuessedWordCorrect(String userGuessedWord) {
        return userGuessedWord.equals(computerGuessedWord);
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public String getComputerGuessedWord() {
        return computerGuessedWord;
    }

    @Override
    public List<Character> getPositions(String userGuessedWord) {
        List<Character> positions = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder(computerGuessedWord);
        //hello
        //hypes

        for(int i = 0; i < userGuessedWord.length(); i++){
            if(isUserCharAndComputerCharEqualAt(userGuessedWord, i)){
                stringBuilder.setCharAt(i, FLAG);
                positions.add(CORRECT_POSITION);
            }
            else {
                boolean isFound = false;
                int k = -1;
                for(int j = 0; j < userGuessedWord.length(); j++){
                    if(userGuessedWord.charAt(i) == stringBuilder.charAt(j)){
                        isFound = true;
                        k = j;
                        break;
                    }
                }
                if(isFound){
                    stringBuilder.setCharAt(k, FLAG);
                    positions.add(INCORRECT_POSITION);
                }
                else {
                    stringBuilder.setCharAt(i, FLAG);
                    positions.add(NOT_AVAILABLE);
                }
            }
        }

        return positions;
    }

    @Override
    public void play() {
        setComputerGuessedWord();
    }

    private boolean isUserCharAndComputerCharEqualAt(String userGuessedWord, int index){
        return userGuessedWord.charAt(index) == computerGuessedWord.charAt(index);
    }

    private String getRandomComputerGuessedWord(){
        return wordsSet.stream().toList().get(getRandomNumber());
    }

    private int getRandomNumber(){
        return  (int) (Math.random()*wordsSet.size());
    }

    private void setComputerGuessedWord(){
        this.computerGuessedWord = getRandomComputerGuessedWord();
    }
}
