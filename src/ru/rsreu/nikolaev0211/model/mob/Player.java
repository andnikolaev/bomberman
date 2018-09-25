package ru.rsreu.nikolaev0211.model.mob;

import ru.rsreu.nikolaev0211.events.EventManager;
import ru.rsreu.nikolaev0211.events.EventType;
import ru.rsreu.nikolaev0211.model.Game;
import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.model.GameState;
import ru.rsreu.nikolaev0211.model.UpdatableModel;
import ru.rsreu.nikolaev0211.model.mob.move.Movable;
import ru.rsreu.nikolaev0211.model.mob.move.MoveDirection;
import ru.rsreu.nikolaev0211.model.mob.move.MoveDirectionType;

public class Player extends Mob implements Movable {
    public Player(double x, double y, double mobSpeed, UpdatableModel gameModel) {
        super(x, y, mobSpeed, gameModel, false, true, MoveDirectionType.NONE);
    }

    @Override
    public void moveUp(boolean isMove) {
        this.isMoving = isMove;
        this.moveDirection = MoveDirectionType.UP;
    }

    @Override
    public void moveDown(boolean isMove) {
        this.isMoving = isMove;
        this.moveDirection = MoveDirectionType.DOWN;
    }

    @Override
    public void moveLeft(boolean isMove) {
        this.isMoving = isMove;
        this.moveDirection = MoveDirectionType.LEFT;
    }

    @Override
    public void moveRight(boolean isMove) {
        this.isMoving = isMove;
        this.moveDirection = MoveDirectionType.RIGHT;
    }

    @Override
    public void calculateMove() {
        MoveDirection moveDirection = this.moveDirection.getMoveDirection();
        move(moveDirection.getX() * this.mobSpeed, moveDirection.getY() * this.mobSpeed);
        this.gameModel.update();
    }

    public boolean canMove(double x, double y) {
        //For all corner of mob
        for (int c = 0; c < 4; c++) {

        }

        return true;
    }

    public void move(double x, double y) {
        if (canMove(0, y)) {
            this.y += y;
        }

        if (canMove(x, 0)) {
            this.x += x;
        }
    }

    @Override
    public void run() {
        while (this.isAlive) {
            if (this.isMoving && GameState.RUNNING.equals(Game.getGameState())) {
                calculateMove();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
