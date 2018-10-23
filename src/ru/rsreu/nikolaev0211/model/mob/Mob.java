package ru.rsreu.nikolaev0211.model.mob;

import ru.rsreu.nikolaev0211.model.UpdatableModel;
import ru.rsreu.nikolaev0211.model.mob.move.MoveDirectionType;

public abstract class Mob implements Runnable {
    protected double x;
    protected double y;
    protected double mobSpeed;
    protected UpdatableModel gameModel;
    protected boolean isMoving = false;
    protected boolean isAlive = true;
    protected MoveDirectionType moveDirection;

    public Mob(double x, double y, double mobSpeed, UpdatableModel gameModel, boolean isMoving, boolean isAlive, MoveDirectionType moveDirection) {
        this.x = x;
        this.y = y;
        this.mobSpeed = mobSpeed;
        this.gameModel = gameModel;
        this.isMoving = isMoving;
        this.isAlive = isAlive;
        this.moveDirection = moveDirection;
    }

    public abstract void calculateMove();

    private boolean canMove(double x, double y) {
        //For all corner of mob
        for (int c = 0; c < 4; c++) {

        }

        return true;
    }

    protected void move(double x, double y) {
        if (canMove(0, y)) {
            this.y += y;
        }

        if (canMove(x, 0)) {
            this.x += x;
        }
    }

    @Override
    public String toString() {
        return "Mob{" +
                "x=" + x +
                ", y=" + y +
                ", isMoving=" + isMoving +
                ", isAlive=" + isAlive +
                ", moveDirection=" + moveDirection +
                '}';
    }
}
