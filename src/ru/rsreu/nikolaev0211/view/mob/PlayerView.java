package ru.rsreu.nikolaev0211.view.mob;

import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.view.GameScreenParameters;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class PlayerView implements MobView {
    @Override
    public void render(Graphics2D graphics, Mob mob) {
        graphics.setColor(new Color(180, 255, 45));
        graphics.fill(new Ellipse2D.Double(
                mob.getX() * GameScreenParameters.getScaleXTest(),
                mob.getY() * GameScreenParameters.getScaleYTest(),
                GameScreenParameters.getScaleXTest() - 1,
                GameScreenParameters.getScaleYTest() - 1
        ));
    }
}
