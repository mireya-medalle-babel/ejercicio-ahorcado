package es.babel.ejercicioahorcado.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class InputService implements IInputService{

    @Override
    public int chosenOption(Scanner sc) {
        return sc.nextInt();
    }

    @Override
    public String userGuess(Scanner sc) {
        return sc.nextLine().toLowerCase();
    }
}
