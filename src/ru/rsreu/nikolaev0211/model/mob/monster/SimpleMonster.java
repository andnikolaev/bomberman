package ru.rsreu.nikolaev0211.model.mob.monster;

import ru.rsreu.nikolaev0211.events.EventType;
import ru.rsreu.nikolaev0211.model.Game;
import ru.rsreu.nikolaev0211.model.GameField;
import ru.rsreu.nikolaev0211.model.GameState;
import ru.rsreu.nikolaev0211.model.UpdatableModel;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.model.mob.Player;
import ru.rsreu.nikolaev0211.model.mob.monster.AI.AI;
import ru.rsreu.nikolaev0211.model.mob.monster.AI.MediumAI;
import ru.rsreu.nikolaev0211.model.mob.move.MoveDirection;
import ru.rsreu.nikolaev0211.model.mob.move.MoveDirectionType;

public class SimpleMonster extends Mob {
    private AI ai;

    public SimpleMonster(double x, double y, double mobSpeed, UpdatableModel gameModel, AI ai, GameField gameField) {
        super(x, y, mobSpeed, gameModel, false, true, MoveDirectionType.NONE, gameField);
        this.ai = ai;
        initAi();
    }

    private void initAi() {
        if (ai instanceof MediumAI) {
            MediumAI mediumAI = (MediumAI) ai;
            mediumAI.setMob(this);
        }
    }

    @Override
    public void calculateMove() {
        this.moveDirection = ai.calculateDirection();
        this.isMoving = true;
        MoveDirection moveDirection = this.moveDirection.getMoveDirection();
        this.move(moveDirection.getX() * this.mobSpeed, moveDirection.getY() * this.mobSpeed);
        this.gameModel.update(EventType.MODEL_UPDATE);
    }

    @Override
    public void run() {
        while (this.isAlive) {
            if (GameState.RUNNING.equals(Game.getGameState())) {
                calculateMove();
            }
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public AI getAi() {
        return ai;
    }

    public void setAi(AI ai) {
        this.ai = ai;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
