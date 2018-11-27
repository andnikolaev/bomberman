package ru.rsreu.nikolaev0211.model;

import ru.rsreu.nikolaev0211.events.EventManager;
import ru.rsreu.nikolaev0211.events.EventType;
import ru.rsreu.nikolaev0211.model.bomb.Bomb;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.model.mob.level.Level;
import ru.rsreu.nikolaev0211.model.mob.level.LevelReader;

import java.util.ArrayList;
import java.util.Iterator;

public class Game implements UpdatableModel, BombermanAction {
    private volatile static GameState gameState = GameState.NEW;
    private GameField gameField;
    private EventManager eventManager;

    public Game(EventManager eventManager) {
        this.eventManager = eventManager;
        initModel();
        startModel();
    }

    private void initModel() {
        LevelReader levelReader = new LevelReader();
        Level level = levelReader.readLevel("C:\\Users\\Andrey_Nikolaev\\Downloads\\bomberman-master (3)\\02-11-Nikolaev\\resources\\Level.txt");

        GameField gameField = new GameField(this, level);
        setGameField(gameField);
    }

    private void startModel() {
        Thread thread = new Thread(gameField.getPlayer());
        thread.start();
        for (Mob mob : gameField.getMobs()) {
            thread = new Thread(mob);
            thread.start();
        }
    }

    public void newGame() {
        eventManager.notify(EventType.MODEL_UPDATE, createGameData());
    }

    @Override
    public void start() {
        gameState = GameState.RUNNING;
        eventManager.notify(EventType.MODEL_UPDATE, createGameData());
    }

    @Override
    public void update(EventType eventType) {
        if (EventType.BOMB_UPDATE.equals(eventType)) {
            clearBomb();
        }
        eventManager.notify(EventType.MODEL_UPDATE, createGameData());
    }

    private void clearBomb() {
        Iterator<Bomb> iterator = gameField.getBombs().iterator();

        while (iterator.hasNext()) {
            Bomb element = iterator.next();
            if (!element.isAlive()) {
                iterator.remove();
            }
        }
    }

    @Override
    public void placeBomb() {
        Bomb bomb = new Bomb(gameField.getPlayer().getX(), gameField.getPlayer().getY(), this);
        if (gameField.getBombs() == null) {
            gameField.setBombs(new ArrayList<Bomb>());
        }
        gameField.getBombs().add(bomb);
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

    private GameData createGameData() {
        return new GameData(gameField, gameField.getMobs(), gameField.getPlayer(), gameField.getBombs(), gameState);
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
