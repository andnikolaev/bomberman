package ru.rsreu.nikolaev0211.view;

import ru.rsreu.nikolaev0211.controller.GameController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private GameController gameController;

    public Keyboard(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed");
        gameController.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameController.keyReleased(e.getKeyCode());
    }
}
