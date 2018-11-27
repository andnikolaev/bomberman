package ru.rsreu.nikolaev0211.model;

import ru.rsreu.nikolaev0211.model.bomb.Bomb;
import ru.rsreu.nikolaev0211.model.level.Block;
import ru.rsreu.nikolaev0211.model.level.Brick;
import ru.rsreu.nikolaev0211.model.level.Wall;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.model.mob.Player;
import ru.rsreu.nikolaev0211.model.mob.level.Level;
import ru.rsreu.nikolaev0211.model.mob.monster.AI.EasyAI;
import ru.rsreu.nikolaev0211.model.mob.monster.AI.MediumAI;
import ru.rsreu.nikolaev0211.model.mob.monster.SimpleMonster;

import java.util.LinkedList;
import java.util.List;

public class GameField {
    private UpdatableModel updatableModel;
    private int width;
    private int height;
    private GameState gameState;
    private Level level;
    private Player player;
    private List<Mob> mobs;
    private List<Block> blocks;
    private List<Bomb> bombs;

    public GameField(UpdatableModel updatableModel, Level level) {
        this.level = level;
        this.updatableModel = updatableModel;
        initGameObjects();
    }

    private void initGameObjects() {
        this.width = level.getColumns();
        this.height = level.getRows();
        player = initPlayer();
        mobs = initMobs();
        blocks = initBlocks();
    }

    private Player initPlayer() {
        Player player = null;
        char[][] levelChars = level.getLevel();
        for (int i = 0; i < levelChars.length; i++) {
            for (int j = 0; j < levelChars[i].length; j++) {
                if (levelChars[i][j] == 'p') {
                    //TODO вынести скорость
                    player = new Player(j, i, 0.25, updatableModel);
                }
            }
        }
        return player;
    }

    private List<Mob> initMobs() {
        List<Mob> mobs = new LinkedList<Mob>();
        char[][] levelChars = level.getLevel();
        for (int i = 0; i < levelChars.length; i++) {
            for (int j = 0; j < levelChars[i].length; j++) {
                if (levelChars[i][j] == '1') {
                    mobs.add(new SimpleMonster(j, i, 0.25, updatableModel, new EasyAI()));
                    //TODO вынести скорость
                }
                if (levelChars[i][j] == '2') {
                    mobs.add(new SimpleMonster(j, i, 0.25, updatableModel, new MediumAI()));
                    //TODO вынести скорость
                }
            }
        }
        return mobs;
    }

    private List<Block> initBlocks() {
        List<Block> blocks = new LinkedList<Block>();
        char[][] levelChars = level.getLevel();
        for (int i = 0; i < levelChars.length; i++) {
            for (int j = 0; j < levelChars[i].length; j++) {
                if (levelChars[i][j] == '#') {
                    blocks.add(new Wall(j, i));
                }
                if (levelChars[i][j] == '*') {
                    blocks.add(new Brick(j, i));
                }
            }
        }
        return blocks;
    }

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Mob> getMobs() {
        return mobs;
    }

    public void setMobs(List<Mob> mobs) {
        this.mobs = mobs;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }
}

