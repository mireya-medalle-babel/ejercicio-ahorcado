package es.babel.ejercicioahorcado.service;

import org.springframework.stereotype.Service;


public interface IOutputService {
    void showMenu();
    void showSelectionError();
    void showTriesLeft(int triesLeft);
    void showByeMessage ();

    void showInstructions();

    void showHiddenWord(String hiddenWord);
}
