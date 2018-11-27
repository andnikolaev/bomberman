package ru.rsreu.nikolaev0211.view.object.level;

import ru.rsreu.nikolaev0211.model.level.Block;

import java.awt.*;

public interface LevelView {
    void render(Graphics2D graphics, Block block);
}
