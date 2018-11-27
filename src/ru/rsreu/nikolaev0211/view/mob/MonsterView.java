package ru.rsreu.nikolaev0211.view.mob;

import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.view.GameScreenParameters;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MonsterView implements MobView {
    @Override
    public void render(Graphics2D graphics, Mob mob) {
        graphics.setColor(new Color(255, 0, 18));
        graphics.fill(new Ellipse2D.Double(
                mob.getX() * GameScreenParameters.getScaleXTest(),
                mob.getY() * GameScreenParameters.getScaleYTest(),
                GameScreenParameters.getScaleXTest() - 1,
                GameScreenParameters.getScaleYTest() - 1
        ));
    }
}
