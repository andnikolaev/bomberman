package ru.rsreu.nikolaev0211.controller;

import ru.rsreu.nikolaev0211.model.Game;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void keyPressed(int keyCode) {
        MovableEventType movableEventType = MovableEventType.getMovableOperationByKeyCode(keyCode);
        if (movableEventType != null) {
            movableEventType.startMoving(game.getPlayer());
        }
        GameEventType gameEventType = GameEventType.getGameEventByKeyCode(keyCode);
        if (gameEventType != null) {
            gameEventType.startAction(game);
        }
    }

    public void keyReleased(int keyCode) {
        MovableEventType movableEventType = MovableEventType.getMovableOperationByKeyCode(keyCode);
        if (movableEventType != null) {
            movableEventType.stopMoving(game.getPlayer());
        }
    }
}
