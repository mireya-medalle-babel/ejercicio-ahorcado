package es.babel.ejercicioahorcado.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordsService implements IWordsService {
    @Override
    public List<String> generate10Words() {
        String word1 = "Palabra";
        String word2 = "Lobo";
        String word3 = "Sempiterno";
        String word4 = "Esclarecer";
        String word5 = "Misterio";
        String word6 = "Bruma";
        String word7 = "Tenedor";
        String word8 = "Alcohol";
        String word9 = "Calavera";
        String word10 = "Iracundo";

        List<String> words = new ArrayList<>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        words.add(word5);
        words.add(word6);
        words.add(word7);
        words.add(word8);
        words.add(word9);
        words.add(word10);

        return words;
    }

    @Override
    public String selectWord() {
        List<String> allWords = generate10Words();
        int randomWordPosition = (int)(Math.random()*10);
        return allWords.get(randomWordPosition);
    }

    @Override
    public String hideWord(String word) {
        String hiddenWord = "";

        for (int i = 0; i < word.length(); i++) {
            hiddenWord+="_";
        }

        return hiddenWord;
    }

    @Override
    public String revealWordCoincidences(String word, String hiddenWord, String userGuess) {
        String resultOfGuess = "";
        
        if (userGuess.length() <= 1) {
            resultOfGuess = getResultOfGuessLetter(word, hiddenWord, userGuess);
        } else {
            resultOfGuess = getResultOfGuessWord(word, hiddenWord, userGuess);
        }

        return resultOfGuess;
    }

    private static String getResultOfGuessWord(String word, String hiddenWord, String userGuess) {
        String resultOfGuess = "";

        if (word.equalsIgnoreCase(userGuess)) {
            resultOfGuess = userGuess;
        } else {
            resultOfGuess = hiddenWord;
        }

        return resultOfGuess;
    }

    private static String getResultOfGuessLetter(String word, String hiddenWord, String userGuess) {
        String resultOfGuess = "";

        for (int i = 0; i < word.length(); i++) {
            char charFromWord = word.charAt(i);
            if (userGuess.charAt(0) == charFromWord) {
                resultOfGuess += userGuess.charAt(0);
            } else {
                resultOfGuess += hiddenWord.charAt(i);
            }
        }
        return resultOfGuess;
    }

    @Override
    public int updateTries(String word, String userGuess, int tries) {
        int newTries = tries;

        boolean updateTries = true;

        if (userGuess.length() <=1) {
            for (int i = 0; i < word.length(); i++) {
                char charFromWord = word.charAt(i);
                if (userGuess.charAt(0) == charFromWord) {
                    updateTries = false;
                    break;
                }
            }
        } else {
            if (userGuess.equalsIgnoreCase(word)){
                updateTries = false;
            }
        }

        if (updateTries) {
            newTries--;
        }

        return newTries;
    }




}
