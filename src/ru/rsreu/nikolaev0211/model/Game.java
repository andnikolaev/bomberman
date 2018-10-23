package ru.rsreu.nikolaev0211.model;

import ru.rsreu.nikolaev0211.events.EventManager;
import ru.rsreu.nikolaev0211.events.EventType;
import ru.rsreu.nikolaev0211.model.bomb.Bomb;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.model.mob.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game implements UpdatableModel, GamableAction {
    private volatile static GameState gameState;
    private GameField gameField;
    private List<Mob> monsters;
    private Player player;
    private EventManager eventManager;
    private List<Bomb> bombs;

    public Game(EventManager eventManager) {
        Game.gameState = GameState.PAUSED;
        this.eventManager = eventManager;
    }

    @Override
    public void update(EventType eventType) {
        if (EventType.BOMB_UPDATE.equals(eventType)) {
            clearBomb();
        }
        eventManager.notify(EventType.MODEL_UPDATE, new GameData(gameField, monsters, player, bombs, gameState));
    }

    private void clearBomb() {
        Iterator<Bomb> iterator = bombs.iterator();

        while (iterator.hasNext()) {
            Bomb element = iterator.next();
            if (!element.isAlive()) {
                iterator.remove();
            }
        }
    }

    @Override
    public void placeBomb() {
        Bomb bomb = new Bomb(player.getX(), player.getY(), this);
        if (bombs == null) {
            bombs = new ArrayList<Bomb>();
        }
        bombs.add(bomb);
        Thread thread = new Thread(bomb);
        thread.start();
        update(EventType.MODEL_UPDATE);
    }

    @Override
    public void pause(boolean isPaused) {
        if (isPaused) {
            gameState = GameState.PAUSED;
        } else {
            gameState = GameState.RUNNING;
        }
        update(EventType.MODEL_UPDATE);
    }

    @Override
    public boolean isPaused() {
        boolean isPaused;
        isPaused = GameState.PAUSED.equals(gameState);
        return isPaused;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
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
