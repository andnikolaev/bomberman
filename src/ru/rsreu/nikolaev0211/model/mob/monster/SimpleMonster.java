package ru.rsreu.nikolaev0211.model.mob.monster;

import ru.rsreu.nikolaev0211.events.EventManager;
import ru.rsreu.nikolaev0211.model.Game;
import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.model.UpdatableModel;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.model.mob.monster.AI.AI;
import ru.rsreu.nikolaev0211.model.mob.move.MoveDirectionType;

public class SimpleMonster extends Mob {
    private AI ai;

    public SimpleMonster(double x, double y, double mobSpeed, UpdatableModel gameModel, AI ai) {
        super(x, y, mobSpeed, gameModel, false, true, MoveDirectionType.NONE);
        this.ai = ai;
    }

    //TODO: выбор направления движения и движение
    @Override
    public void calculateMove() {
        ai.calculateDirection();
    }

    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void moveUp(boolean isMove) {

    }

    @Override
    public void moveDown(boolean isMove) {

    }

    @Override
    public void moveLeft(boolean isMove) {

    }

    @Override
    public void moveRight(boolean isMove) {

    }
}
