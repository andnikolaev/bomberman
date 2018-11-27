package ru.rsreu.nikolaev0211.model.mob;

import ru.rsreu.nikolaev0211.model.GameField;
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
    protected GameField gameField;

    public Mob(double x, double y, double mobSpeed, UpdatableModel gameModel, boolean isMoving, boolean isAlive, MoveDirectionType moveDirection, GameField gameField) {
        this.x = x;
        this.y = y;
        this.mobSpeed = mobSpeed;
        this.gameModel = gameModel;
        this.isMoving = isMoving;
        this.isAlive = isAlive;
        this.moveDirection = moveDirection;
        this.gameField = gameField;
    }

    public abstract void calculateMove();

    private boolean canMove(double x, double y) {
        boolean result = false;

        //For all corner of mob
        if (x == 0 && y != 0) {
            if (y > 0) {
                int dy = (int) Math.ceil(this.y + y - 0.05);
                int dx = (int) (this.x + 0.95);
                int xx = (int) (this.x + 0.05);
                if (gameField.checkCell(xx, dy) && gameField.checkCell(dx, dy)) {
                    result = true;
                }
            } else {
                int dy = (int) Math.floor(this.y + y + 0.05);
                int dx = (int) (this.x + 0.95);
                int xx = (int) (this.x + 0.05);
                if (gameField.checkCell(xx, dy) && gameField.checkCell(dx, dy)) {
                    result = true;
                }
            }
        }

        if (x != 0 && y == 0) {
            if (x > 0) {
                int dy = (int) (this.y + 0.95);
                int dx = (int) Math.ceil(this.x + x - 0.05);
                int yy = (int) (this.y + 0.05);
                if (gameField.checkCell(dx, yy) && gameField.checkCell(dx, dy)) {
                    result = true;
                }
            } else {
                int dy = (int) (this.y + 0.95);
                int dx = (int) Math.floor(this.x + x + 0.05);
                int yy = (int) (this.y + 0.05);
                if (gameField.checkCell(dx, yy) && gameField.checkCell(dx, dy)) {
                    result = true;
                }
            }
        }

        return result;
    }

    protected void move(double x, double y) {
        if (canMove(0, y)) {
            this.y += y;
        }

        if (canMove(x, 0)) {
            this.x += x;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
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
