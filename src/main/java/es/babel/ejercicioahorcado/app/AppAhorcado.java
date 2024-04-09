package es.babel.ejercicioahorcado.app;

import es.babel.ejercicioahorcado.config.Config;
import es.babel.ejercicioahorcado.service.IWordsService;
import es.babel.ejercicioahorcado.service.IInputService;
import es.babel.ejercicioahorcado.service.IOutputService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppAhorcado {
    private final IOutputService outputService;
    private final IInputService inputService;
    private final IWordsService wordsService;

    public AppAhorcado(IOutputService outputService, IInputService inputService, IWordsService wordsService) {
        this.outputService = outputService;
        this.inputService = inputService;
        this.wordsService = wordsService;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        Config config = new Config();
        int tries = config.getDefaultTries();
        int chosenOption;
        outputService.showMenu();
        boolean continueGame = true;
        String hiddenWord = "";

        while (continueGame) {
            try {
                chosenOption = inputService.chosenOption(sc);

                if (chosenOption == 1) {
                    String word = wordsService.selectWord().toLowerCase();
                    hiddenWord = wordsService.hideWord(word);
                    System.out.println(hiddenWord);
                    sc.nextLine();

                    while (tries > 0 && hiddenWord.contains("_")) {
                        outputService.showTriesLeft(tries);
                        System.out.println("Palabra: "+word);
                        outputService.showInstructions();
                        String userGuess = inputService.userGuess(sc);
                        hiddenWord = wordsService.revealWordCoincidences(word, hiddenWord, userGuess);
                        tries = wordsService.updateTries(word, userGuess, tries);
                        outputService.showHiddenWord(hiddenWord);
                    }
                    outputService.showMenu();

                } else if (chosenOption == 2) {
                    continueGame = false;
                    outputService.showByeMessage();
                } else {
                    outputService.showSelectionError();
                    outputService.showMenu();
                }
            } catch (Exception e) {
                outputService.showSelectionError();
                outputService.showMenu();
                sc.nextLine();
            }
        }
    }



}
