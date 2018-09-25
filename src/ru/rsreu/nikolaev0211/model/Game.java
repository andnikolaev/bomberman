package ru.rsreu.nikolaev0211.model;

import ru.rsreu.nikolaev0211.events.EventManager;
import ru.rsreu.nikolaev0211.events.EventType;
import ru.rsreu.nikolaev0211.model.mob.Mob;

import java.util.List;

public class Game implements UpdatableModel {
    private static GameState gameState;
    private GameField gameField;
    private List<Mob> monsters;
    private Mob player;
    private EventManager eventManager;

    public Game(EventManager eventManager) {
        Game.gameState = GameState.PAUSED;
        this.eventManager = eventManager;
    }

    @Override
    public void update() {
        eventManager.notify(EventType.MODEL_UPDATE, new GameData(gameField, monsters, player));
    }


    public EventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public List<Mob> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Mob> monsters) {
        this.monsters = monsters;
    }

    public Mob getPlayer() {
        return player;
    }

    public void setPlayer(Mob player) {
        this.player = player;
    }

    public static GameState getGameState() {
        return Game.gameState;
    }

    public static void setGameState(GameState gameState) {
        Game.gameState = gameState;
    }

    @Override
    public String toString() {
        return "Game{" +
                ", gameState=" + gameState +
                '}';
    }


}
