package ru.rsreu.nikolaev0211.view;

import ru.rsreu.nikolaev0211.model.GameData;

import java.awt.*;


public interface Renderable {
    void render(Graphics2D graphics, GameData gameData, Canvas canvas);
}
