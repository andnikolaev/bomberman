package ru.rsreu.nikolaev0211.model;

import ru.rsreu.nikolaev0211.Settings;
import ru.rsreu.nikolaev0211.events.EventManager;
import ru.rsreu.nikolaev0211.events.EventType;
import ru.rsreu.nikolaev0211.model.bomb.Bomb;
import ru.rsreu.nikolaev0211.model.bomb.Explosion;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.model.level.Level;
import ru.rsreu.nikolaev0211.model.level.LevelReader;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

public class Game implements UpdatableModel, BombermanAction {
    private volatile static GameState gameState = GameState.NEW;
    private GameField gameField;
    private EventManager eventManager;
    private int bombCount;

    public Game(EventManager eventManager) {
        this.eventManager = eventManager;
        initModel();
        startModel();
    }

    private void initModel() {
        LevelReader levelReader = new LevelReader();
        Level level = levelReader.readLevel("resources/Level.txt");

        GameField gameField = new GameField(this, level);
        setGameField(gameField);
        bombCount = (int) Settings.BOMB_COUNT;
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
      // initModel();
        gameState = GameState.RUNNING;
        eventManager.notify(EventType.MODEL_UPDATE, createGameData());
    }

    @Override
    public void update(EventType eventType) {
        if (EventType.BOMB_UPDATE.equals(eventType)) {
            clearBomb();
        }
        if (EventType.EXPLOSION_UPDATE.equals(eventType)) {
            clearExplosions();
        }
        eventManager.notify(EventType.MODEL_UPDATE, createGameData());
    }

    private void explosion(Bomb bomb) {
        int x = bomb.getX();
        int y = bomb.getY();
        for (int i = 1; i <= Settings.EXPLOSION_STRANGE; i++) {
            if (gameField.checkCellOnExplosion(x + i, y)) {
                createExplosion(x + i, y);
            } else {
                break;
            }
        }
        for (int i = 1; i <= Settings.EXPLOSION_STRANGE; i++) {
            if (gameField.checkCellOnExplosion(x, y + i)) {
                createExplosion(x, y + i);
            } else {
                break;
            }
        }
        for (int i = 1; i <= Settings.EXPLOSION_STRANGE; i++) {
            if (gameField.checkCellOnExplosion(x - i, y)) {
                createExplosion(x - i, y);
            } else {
                break;
            }
        }
        for (int i = 1; i <= Settings.EXPLOSION_STRANGE; i++) {
            if (gameField.checkCellOnExplosion(x, y - i)) {
                createExplosion(x, y - i);
            } else {
                break;
            }
        }
        createExplosion(x, y);
        update(EventType.MODEL_UPDATE);
    }

    private void createExplosion(int x, int i2) {
        Explosion explosion = new Explosion(x, i2, this);
        gameField.getExplosionList().add(explosion);
        Thread thread = new Thread(explosion);
        thread.start();
    }

    private synchronized void clearExplosions() {
        Iterator<Explosion> iterator = gameField.getExplosionList().iterator();

        while (iterator.hasNext()) {
            Explosion explosion = iterator.next();
            if (!explosion.isAlive()) {
                iterator.remove();
            }
        }
    }

    private void clearBomb() {
        Iterator<Bomb> iterator = gameField.getBombs().iterator();

        while (iterator.hasNext()) {
            Bomb bomb = iterator.next();
            if (!bomb.isAlive()) {
                explosion(bomb);
                iterator.remove();
                bombCount++;
            }
        }
    }

    @Override
    public void placeBomb() {
        if (bombCount != 0) {
            bombCount--;
            int x = (int) Math.floor(gameField.getPlayer().getX() + 0.5);
            int y = (int) Math.floor(gameField.getPlayer().getY() + 0.5);
            Bomb bomb = new Bomb(x, y, this);
            if (gameField.getBombs() == null) {
                gameField.setBombs(new ArrayList<Bomb>());
            }
            gameField.getBombs().add(bomb);
            Thread thread = new Thread(bomb);
            thread.start();
            update(EventType.MODEL_UPDATE);
        }
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
        return new GameData(gameField, gameField.getMobs(), gameField.getPlayer(), gameField.getBombs(), gameState, gameField.getScore());
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
