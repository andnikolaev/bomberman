package ru.rsreu.nikolaev0211.view;

import java.awt.*;

import static ru.rsreu.nikolaev0211.Settings.*;

public class GameScreenParameters {
    private static int ScaleXTest;
    private static int ScaleYTest;

    private static final double SCALE_X = ORIGINAL_WIDTH / 1; // 28
    private static final double SCALE_Y = ORIGINAL_HEIGHT / 1; // 31

    private double x = 1;
    private double y = 1;

    private double width;
    private double height;

    public double getWidthTest() {
        return widthTest;
    }

    public double getHeightTest() {
        return heightTest;
    }

    private double widthTest;
    private double heightTest;

    private int rows;
    private int columns;

    public void resize(Dimension dimension) {
        this.widthTest = dimension.getWidth();
        this.heightTest = dimension.getHeight();

        calcScale(dimension);

        this.x = this.width / ORIGINAL_WIDTH;
        this.y = this.height / ORIGINAL_HEIGHT;
    }

    private void calcScale(Dimension dimension) {
        double canvasWidth = dimension.getWidth();
        this.height = dimension.getHeight();
        this.width = calculateWidth(this.height);
        calculateScale();
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

    public int getColumns() {
        return columns;
    }

    private void calculateScale() {
        if (columns != 0 && rows != 0) {
            GameScreenParameters.ScaleXTest = (int) widthTest / columns;
            GameScreenParameters.ScaleYTest = (int) heightTest / rows;
        }
    }

    public void setColumns(int columns) {
        this.columns = columns;
        calculateScale();
    }

    public static int getScaleXTest() {
        return ScaleXTest;
    }


    public static int getScaleYTest() {
        return ScaleYTest;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
        calculateScale();
    }
}
