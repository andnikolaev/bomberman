package ru.rsreu.nikolaev0211.view.object.level;

import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.model.level.Block;
import ru.rsreu.nikolaev0211.model.level.Brick;
import ru.rsreu.nikolaev0211.model.level.Wall;
import ru.rsreu.nikolaev0211.view.Renderable;

import java.awt.*;

public class BlockView implements LevelView {

    public void render(Graphics2D graphics, Block block) {
        WallView wallView = new WallView();
        BrickView brickView = new BrickView();
        if (block instanceof Wall) {
            wallView.render(graphics, block);
        }
        if (block instanceof Brick) {
            brickView.render(graphics, block);
        }
    }
}
