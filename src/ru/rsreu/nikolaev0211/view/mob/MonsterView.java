package ru.rsreu.nikolaev0211.view.mob;

import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.model.mob.monster.AI.EasyAI;
import ru.rsreu.nikolaev0211.model.mob.monster.AI.MediumAI;
import ru.rsreu.nikolaev0211.model.mob.monster.SimpleMonster;
import ru.rsreu.nikolaev0211.view.GameScreenParameters;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MonsterView implements MobView {

    @Override
    public void render(Graphics2D graphics, Mob mob) {
        Color color = new Color(255, 0, 18);
        if (mob instanceof SimpleMonster) {
            SimpleMonster simpleMonster = (SimpleMonster) mob;
            if (simpleMonster.getAi() instanceof EasyAI) {
                color = new Color(42, 255, 255);
            }
            if (simpleMonster.getAi() instanceof MediumAI) {
                color = new Color(48, 155, 255);
            }
        }
        graphics.setColor(color);
        graphics.fill(new Ellipse2D.Double(
                mob.getX() * GameScreenParameters.getScaleXTest(),
                mob.getY() * GameScreenParameters.getScaleYTest(),
                GameScreenParameters.getScaleXTest() - 1,
                GameScreenParameters.getScaleYTest() - 1
        ));
    }
}
