package ru.rsreu.nikolaev0211.view.object;


import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.view.Canvas;
import ru.rsreu.nikolaev0211.view.Renderable;

import java.awt.*;

public class ScoreView implements Renderable {
    private static final int X_POSITION_PADDING = 240;
    private static final int Y_POSITION = 40;
    private static final int FONT_SIZE = 18;
    private static final String SCORE = "Score: %s";

    @Override
    public void render(Graphics2D graphics, GameData gameData, Canvas canvas) {
        graphics.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        graphics.setColor(Color.WHITE);

        graphics.drawString(
                String.format(SCORE, gameData.getScore()),
                canvas.getWidth() - X_POSITION_PADDING,
                Y_POSITION
        );
    }
}
