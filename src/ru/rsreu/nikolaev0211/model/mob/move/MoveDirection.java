package ru.rsreu.nikolaev0211.model.mob.move;

public class MoveDirection {
    private int x;
    private int y;

    private MoveDirection() {
    }

    public MoveDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
