package ru.rsreu.nikolaev0211.model.mob.level;

public class Level {
    private int number;
    private char[][] level;

    public Level(int number, char[][] level) {
        this.number = number;
        this.level = level;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public char[][] getLevel() {
        return level;
    }

    public void setLevel(char[][] level) {
        this.level = level;
    }
}
