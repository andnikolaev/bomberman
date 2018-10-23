package ru.rsreu.nikolaev0211.model;

import ru.rsreu.nikolaev0211.model.bomb.Bomb;
import ru.rsreu.nikolaev0211.model.mob.Mob;

import java.util.List;

public class GameData {
    private GameField gameField;
    private List<Mob> monsters;
    private Mob player;
    private GameState gameState;
    private List<Bomb> bomb;

    public GameData() {
    }

    public GameData(GameField gameField, List<Mob> monsters, Mob player, List<Bomb> bomb, GameState gameState) {
        this.gameField = gameField;
        this.monsters = monsters;
        this.player = player;
        this.gameState = gameState;
        this.bomb = bomb;
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

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Bomb> getBomb() {
        return bomb;
    }

    public void setBomb(List<Bomb> bomb) {
        this.bomb = bomb;
    }

    @Override
    public String toString() {
        return "GameData{" +
                "\ngameField=" + gameField +
                ",\n monsters=" + monsters +
                ",\n player=" + player +
                ",\n gameState=" + gameState +
                ",\n bomb=" + bomb +
                '}';
    }
}
