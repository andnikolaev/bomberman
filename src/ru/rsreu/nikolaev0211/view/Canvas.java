package ru.rsreu.nikolaev0211.view;

import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.model.GameState;
import ru.rsreu.nikolaev0211.view.notification.FinishedGameNotification;
import ru.rsreu.nikolaev0211.view.notification.NewGameNotification;
import ru.rsreu.nikolaev0211.view.notification.NotificationViewType;
import ru.rsreu.nikolaev0211.view.notification.PausedGameNotification;
import ru.rsreu.nikolaev0211.view.object.ScoreView;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;

public class Canvas extends JPanel {
    private GameData data;
    private GameScreenParameters gameScreenParameters;
    private FieldView fieldView = new FieldView();
    private ScoreView scoreView = new ScoreView();

    public Canvas(GameScreenParameters gameScreenParameters) {
        super();
        this.gameScreenParameters = gameScreenParameters;
    }

    public void repaint(Object data) {
        setDoubleBuffered(true);
        this.data = (GameData) data;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (data != null) {
            Graphics2D g2 = (Graphics2D) g;
            setQuality(g2);


//            g2.scale(1, 1);
            g2.fill(new Rectangle2D.Double(0, 0, gameScreenParameters.getWidthTest(), gameScreenParameters.getHeightTest()));
            this.setBackground(Color.BLACK);
            gameScreenParameters.setColumns(data.getGameField().getWidth());
            gameScreenParameters.setRows(data.getGameField().getHeight());

            fieldView.render(g2, data, this);
            scoreView.render(g2, data, this);
            GameState gameStatus = data.getGameState();
            if (!GameState.RUNNING.equals(gameStatus)) {
                Renderable renderable = NotificationViewType.getNotificationView(gameStatus);
                renderable.render(g2, data, this);
            }
        }
    }

    private void setQuality(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
    }
}
