package es.babel.ejercicioahorcado.service;

import org.springframework.stereotype.Service;

@Service
public class OutputService implements IOutputService{

    @Override
    public void showMenu() {
        System.out.println("======= JUEGO DEL AHORCADO =========" +
                "\n1. Nuevo Juego" +
                "\n2. Salir");
    }

    @Override
    public void showSelectionError() {
        System.out.println("ERROR: Elija 1 o 2");
    }

    @Override
    public void showTriesLeft(int triesLeft) {
        System.out.println("Quedan "+triesLeft+" intentos");
    }

    @Override
    public void showByeMessage() {
        System.out.println("Ha salido del juego");
    }

    @Override
    public void showInstructions() {
        System.out.println("Introduzca letra");
    }

    @Override
    public void showHiddenWord(String hiddenWord) {
        System.out.println(hiddenWord);
    }
}
