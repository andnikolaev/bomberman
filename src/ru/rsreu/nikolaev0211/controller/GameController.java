package ru.rsreu.nikolaev0211.controller;

import ru.rsreu.nikolaev0211.model.Game;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void keyPressed(int keyCode) {
        MovableEventType eventType = MovableEventType.getMovableOperationByKeyCode(keyCode);
        if (eventType != null) {
            System.out.println("Controller");
            eventType.startMoving(game.getPlayer());
        }
    }

    public void keyReleased(int keyCode) {
        MovableEventType eventType = MovableEventType.getMovableOperationByKeyCode(keyCode);
        if (eventType != null) {
            eventType.stopMoving(game.getPlayer());
        }
    }
}
