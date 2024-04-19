package es.babel.ejercicioahorcado.service;

import java.util.List;

public interface IWordsService {
    List<String> generate10Words();
    String selectWord();

    String hideWord(String word);

    String revealWordCoincidences(String word, String hideWord, String userGuess);

    int updateTries(String word, String userGuess, int tries);
}
