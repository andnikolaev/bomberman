package ru.rsreu.nikolaev0211.model;

import ru.rsreu.nikolaev0211.model.mob.Mob;

import java.util.List;

public class GameData {
    private GameField gameField;
    private List<Mob> monsters;
    private Mob player;

    public GameData() {
    }

    public GameData(GameField gameField, List<Mob> monsters, Mob player) {
        this.gameField = gameField;
        this.monsters = monsters;
        this.player = player;
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

    @Override
    public String toString() {
        return "GameData{" +
                "gameField=" + gameField +
                ", monsters=" + monsters +
                ", player=" + player +
                '}';
    }
}
