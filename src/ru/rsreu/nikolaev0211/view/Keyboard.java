package ru.rsreu.nikolaev0211.view;

import ru.rsreu.nikolaev0211.controller.GameController;
import ru.rsreu.nikolaev0211.events.GameEventType;
import ru.rsreu.nikolaev0211.events.MovableEventType;

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
        MovableEventType movableEventType = MovableEventType.getMovableOperationByKeyCode(e.getKeyCode());
        if (movableEventType != null) {
            gameController.startMoving(movableEventType);
        }
        GameEventType gameEventType = GameEventType.getGameEventByKeyCode(e.getKeyCode());
        if (gameEventType != null) {
            gameController.startAction(gameEventType);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        MovableEventType movableEventType = MovableEventType.getMovableOperationByKeyCode(e.getKeyCode());
        if (movableEventType != null) {
            gameController.stopMoving(movableEventType);
        }
    }
}
