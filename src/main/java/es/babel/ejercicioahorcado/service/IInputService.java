package es.babel.ejercicioahorcado.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

public interface IInputService {
    int chosenOption(Scanner sc);
    String userGuess(Scanner sc);

}
