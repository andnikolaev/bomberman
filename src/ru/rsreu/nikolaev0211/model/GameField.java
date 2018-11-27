package ru.rsreu.nikolaev0211.model;

import ru.rsreu.nikolaev0211.Settings;
import ru.rsreu.nikolaev0211.model.bomb.Bomb;
import ru.rsreu.nikolaev0211.model.bomb.Explosion;
import ru.rsreu.nikolaev0211.model.level.Block;
import ru.rsreu.nikolaev0211.model.level.Brick;
import ru.rsreu.nikolaev0211.model.level.Wall;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.model.mob.Player;
import ru.rsreu.nikolaev0211.model.level.Level;
import ru.rsreu.nikolaev0211.model.mob.monster.AI.EasyAI;
import ru.rsreu.nikolaev0211.model.mob.monster.AI.MediumAI;
import ru.rsreu.nikolaev0211.model.mob.monster.SimpleMonster;

import java.util.*;

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
    private List<Explosion> explosionList;

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
        explosionList = new ArrayList<Explosion>();
    }

    private Player initPlayer() {
        Player player = null;
        char[][] levelChars = level.getLevel();
        for (int i = 0; i < levelChars.length; i++) {
            for (int j = 0; j < levelChars[i].length; j++) {
                if (levelChars[i][j] == 'p') {
                    player = new Player(j, i, Settings.PLAYER_SPEED, updatableModel, this);
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
                    mobs.add(new SimpleMonster(j, i, Settings.EASY_MOB_SPEED, updatableModel, new EasyAI(), this));
                }
                if (levelChars[i][j] == '2') {
                    mobs.add(new SimpleMonster(j, i, Settings.MEDIUM_MOB_SPEED, updatableModel, new MediumAI(), this));
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

    public boolean checkCellOnExplosion(int x, int y) {
        if (!level.explosionCell(x, y)) {
            return false;
        }
        explosionBlock(x, y);
        explosionEnemy(x, y);
        return true;
    }

    private void explosionEnemy(int x, int y) {
        Iterator<Mob> iterator = mobs.iterator();
        while (iterator.hasNext()) {
            Mob mob = iterator.next();
            if (((int) Math.floor(mob.getX()) == x && (int) Math.floor(mob.getY()) == y)
                    || ((int) Math.floor(mob.getX() + 0.95) == x && (int) Math.floor(mob.getY() + 0.95) == y)) {
                iterator.remove();
            }
        }
    }

    private void explosionBlock(int x, int y) {
        Iterator<Block> iterator = blocks.iterator();
        while (iterator.hasNext()) {
            Block block = iterator.next();
            if (block.getX() == x && block.getY() == y) {
                iterator.remove();
            }
        }
    }

    public boolean checkCell(int x, int y) {
        if (!level.checkCell(x, y)) {
            return false;
        }

//        if (bombs != null) {
//            for (Bomb bomb : bombs) {
//                if (bomb.getX() == x || bomb.getY() == y) {
//                    return false;
//                }
//            }
//        }
        return true;

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

    public List<Explosion> getExplosionList() {
        return explosionList;
    }

    public void setExplosionList(List<Explosion> explosionList) {
        this.explosionList = explosionList;
    }


}

