package es.babel.ejercicioahorcado.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWordsService {
    List<String> generate10Words();
    String selectWord();

    String hideWord(String word);

    String revealWordCoincidences(String word, String hideWord, String userGuess);

    int updateTries(String word, String userGuess, int tries);
}
