package ru.rsreu.nikolaev0211.view;

import java.awt.*;

import static ru.rsreu.nikolaev0211.Settings.*;

public class GameScreenParameters {
    private static final double SCALE_X = ORIGINAL_WIDTH / ORIGINAL_BLOCK_SIZE; // 28
    private static final double SCALE_Y = ORIGINAL_HEIGHT / ORIGINAL_BLOCK_SIZE; // 31

    private double x = 1;
    private double y = 1;

    private double width;
    private double height;

    public void resized(Dimension dimension) {
        calcScale(dimension);

        this.x = this.width / ORIGINAL_WIDTH;
        this.y = this.height / ORIGINAL_HEIGHT;
    }

    private void calcScale(Dimension dimension) {
        double canvasWidth = dimension.getWidth();
        this.height = dimension.getHeight();
        this.width = calculateWidth(this.height);

        if (this.width > canvasWidth) {
            this.width = canvasWidth;
            this.height = calculateHeight(this.width);
        }
    }

    /**
     * Подсчет ширины для сохранения пропорций
     *
     * @param height Высота канвы
     * @return высота с сохранением пропорций
     */
    private double calculateWidth(double height) {
        return (SCALE_X * height / SCALE_Y);
    }

    /**
     * Подсчет высоты для сохранения пропорций
     *
     * @param width Ширина канфы
     * @return ширина с сохранением пропорций
     */
    private double calculateHeight(double width) {
        return (SCALE_Y * width / SCALE_X);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
