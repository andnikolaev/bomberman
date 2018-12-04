package ru.rsreu.nikolaev0211.model.mob;

import ru.rsreu.nikolaev0211.events.EventType;
import ru.rsreu.nikolaev0211.model.Game;
import ru.rsreu.nikolaev0211.model.GameField;
import ru.rsreu.nikolaev0211.model.GameState;
import ru.rsreu.nikolaev0211.model.UpdatableModel;
import ru.rsreu.nikolaev0211.model.mob.move.Movable;
import ru.rsreu.nikolaev0211.model.mob.move.MoveDirection;
import ru.rsreu.nikolaev0211.model.mob.move.MoveDirectionType;

public class Player extends Mob implements Movable {

    public Player(double x, double y, double mobSpeed, UpdatableModel gameModel, GameField gameField) {
        super(x, y, mobSpeed, gameModel, false, true, MoveDirectionType.NONE, gameField);
    }

    @Override
    public void moveUp(boolean isMove) {
        this.isMoving = isMove;
        this.moveDirection = MoveDirectionType.DOWN;
    }

    @Override
    public void moveDown(boolean isMove) {
        this.isMoving = isMove;
        this.moveDirection = MoveDirectionType.UP;
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
        this.move(moveDirection.getX() * this.mobSpeed, moveDirection.getY() * this.mobSpeed);
        this.checkCellForAction(x,y);
        this.checkCellForPortal(x,y);
        this.gameModel.update(EventType.MODEL_UPDATE);
    }

    @Override
    public void run() {
        while (this.isAlive) {
            if (this.isMoving && GameState.RUNNING.equals(Game.getGameState())) {
                calculateMove();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public double getX() {
        return super.x;
    }

    public double getY() {
        return super.y;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
