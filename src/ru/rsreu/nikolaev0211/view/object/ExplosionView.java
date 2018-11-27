package ru.rsreu.nikolaev0211.view.object;

import ru.rsreu.nikolaev0211.model.bomb.Bomb;
import ru.rsreu.nikolaev0211.model.bomb.Explosion;
import ru.rsreu.nikolaev0211.view.GameScreenParameters;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ExplosionView {
    public void render(Graphics2D graphics, Explosion explosion) {
        graphics.setColor(new Color(255, 252, 0));
        graphics.fill(new Ellipse2D.Double(
                explosion.getX() * GameScreenParameters.getScaleXTest(),
                explosion.getY() * GameScreenParameters.getScaleYTest(),
                GameScreenParameters.getScaleXTest() - 1,
                GameScreenParameters.getScaleYTest() - 1
        ));
    }

}
