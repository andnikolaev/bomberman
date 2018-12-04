package ru.rsreu.nikolaev0211.view.object;


import ru.rsreu.nikolaev0211.view.Canvas;

import java.awt.*;

public class ScoreView {
    private static final int X_POSITION_PADDING = 240;
    private static final int Y_POSITION = 40;
    private static final int FONT_SIZE = 18;
    private static final String SCORE = "Score: %s";

    public void render(Graphics2D graphics, int score, Canvas canvas) {
        graphics.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        graphics.setColor(Color.WHITE);

        graphics.drawString(
                String.format(SCORE, score),
                canvas.getWidth() - X_POSITION_PADDING,
                Y_POSITION
        );
    }
}
