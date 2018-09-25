package ru.rsreu.nikolaev0211.model.mob;

import ru.rsreu.nikolaev0211.events.EventManager;
import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.model.UpdatableModel;
import ru.rsreu.nikolaev0211.model.mob.move.Movable;
import ru.rsreu.nikolaev0211.model.mob.move.MoveDirectionType;

public abstract class Mob implements Runnable, Movable {
    protected double x;
    protected double y;
    protected double mobSpeed;
    protected UpdatableModel gameModel;
    protected boolean isMoving = false;
    protected boolean isAlive = true;
    protected MoveDirectionType moveDirection = MoveDirectionType.NONE;

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
