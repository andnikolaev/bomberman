package ru.rsreu.nikolaev0211.view.notification;

import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.view.Renderable;

import java.awt.*;

public class PausedGameNotification implements Renderable {
    private static final int X_POSITION = 20;
    private static final int Y_POSITION = 90;
    private static final int Y_OFFSET = 15;
    private static final int WIDTH = 160;
    private static final int HEIGHT = 20;

    private static final Color COLOR = new Color(47, 0, 18);

    @Override
    public void render(Graphics2D graphics, GameData gameData) {
        graphics.setColor(COLOR);
        graphics.fillRect(
                X_POSITION,
                Y_POSITION - Y_OFFSET,
                WIDTH,
                HEIGHT
        );
        graphics.setColor(Color.WHITE);
        graphics.drawString(
                "PAUSED, press SPACE",
                X_POSITION,
                Y_POSITION
        );
    }
}
