package ru.rsreu.nikolaev0211.view.notification;

import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.view.Canvas;
import ru.rsreu.nikolaev0211.view.Renderable;

import java.awt.*;


public class NewGameNotification implements Renderable {
    private static final int X_POSITION = 20;
    private static final int Y_POSITION = 90;
    private static final int FONT_SIZE = 68;
    private static final String NEW_GAME = "Press Enter for start game";
    private static final String FONT_TYPE = "TimesRoman";

    @Override
    public void render(Graphics2D graphics, GameData gameData, Canvas canvas) {
        graphics.setFont(new Font(FONT_TYPE, Font.PLAIN, FONT_SIZE));
        graphics.setColor(Color.WHITE);
        graphics.drawString(
                NEW_GAME,
                X_POSITION,
                canvas.getHeight() / 2 - Y_POSITION
        );
    }
}
