package ru.rsreu.nikolaev0211.view.object.level;

import ru.rsreu.nikolaev0211.model.level.Block;
import ru.rsreu.nikolaev0211.model.level.Wall;
import ru.rsreu.nikolaev0211.view.GameScreenParameters;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class WallView implements LevelView {
    public void render(Graphics2D graphics, Block block) {
        graphics.setColor(new Color(174, 238, 255));
        System.out.println("Render block +" + block.toString());
        float d = block.getX() * GameScreenParameters.getScaleXTest() +GameScreenParameters.getScaleXTest();
        System.out.println("Width +" + block.getX() * GameScreenParameters.getScaleXTest() + " to " + d);
        graphics.fill(new Rectangle2D.Double(
                block.getX() * GameScreenParameters.getScaleXTest(),
                block.getY() * GameScreenParameters.getScaleYTest(),
                GameScreenParameters.getScaleXTest()-1,
                GameScreenParameters.getScaleYTest()-1
        ));
    }
}
