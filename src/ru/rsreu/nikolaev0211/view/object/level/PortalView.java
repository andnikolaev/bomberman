package ru.rsreu.nikolaev0211.view.object.level;

import ru.rsreu.nikolaev0211.model.level.Block;
import ru.rsreu.nikolaev0211.view.GameScreenParameters;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class PortalView implements LevelView {
    @Override
    public void render(Graphics2D graphics, Block block) {
        graphics.setColor(new Color(6, 30, 139));
        graphics.fill(new Rectangle2D.Double(
                block.getX() * GameScreenParameters.getScaleXTest(),
                block.getY() * GameScreenParameters.getScaleYTest(),
                GameScreenParameters.getScaleXTest() - 1,
                GameScreenParameters.getScaleYTest() - 1
        ));
    }
}
