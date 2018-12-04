package ru.rsreu.nikolaev0211.model.mob.monster.AI;

import ru.rsreu.nikolaev0211.model.level.Level;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.model.mob.Player;
import ru.rsreu.nikolaev0211.model.mob.move.MoveDirectionType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MediumAI implements AI {

    private Player player;

    private Mob mob;

    private Level level;

    public MediumAI(Player player, Level level) {
        this.player = player;
        this.level = level;
    }

    @Override
    public MoveDirectionType calculateDirection() {
        MoveDirectionType moveDirectionType;
        double dx = mob.getX() - player.getX();
        double dy = mob.getY() - player.getY();
        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx < 0) {
                moveDirectionType = MoveDirectionType.RIGHT;
            } else {
                moveDirectionType = MoveDirectionType.LEFT;
            }
        } else {
            if (dy < 0) {
                moveDirectionType = MoveDirectionType.UP;
            } else {
                moveDirectionType = MoveDirectionType.DOWN;
            }
        }
        return moveDirectionType;
    }

    public Mob getMob() {
        return mob;
    }

    public void setMob(Mob mob) {
        this.mob = mob;
    }
}
