package ru.rsreu.nikolaev0211.controller;

import ru.rsreu.nikolaev0211.events.GameEventType;
import ru.rsreu.nikolaev0211.events.MovableEventType;
import ru.rsreu.nikolaev0211.model.Game;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }


    public void startMoving(MovableEventType movableEventType) {
        movableEventType.startMoving(game.getPlayer());
    }

    public void stopMoving(MovableEventType movableEventType) {
        movableEventType.stopMoving(game.getPlayer());
    }

    public void startAction(GameEventType gameEventType) {
        gameEventType.startAction(game);
    }

    public void newGame() {
        game.newGame();
    }
    
}
