package ru.rsreu.nikolaev0211.view;

import ru.rsreu.nikolaev0211.controller.GameController;
import ru.rsreu.nikolaev0211.events.EventListener;
import ru.rsreu.nikolaev0211.events.EventManager;
import ru.rsreu.nikolaev0211.events.EventType;
import ru.rsreu.nikolaev0211.events.Subscriber;
import ru.rsreu.nikolaev0211.model.Game;
import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.model.GameState;
import ru.rsreu.nikolaev0211.view.notification.FinishedGameNotification;
import ru.rsreu.nikolaev0211.view.notification.NewGameNotification;
import ru.rsreu.nikolaev0211.view.notification.PausedGameNotification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.Map;

public class GameView extends JFrame implements EventListener, Runnable {
    private boolean needUpdate = false;
    private GameController gameController;
    private GameData gameData;
    private Keyboard keyboard;
    private Canvas canvas;
    private Subscriber subscriber;
    private GameScreenParameters gameScreenParameters = new GameScreenParameters();

    private Map<GameState, Renderable> notificationsScreen = new HashMap<GameState, Renderable>() {{
        put(GameState.NEW, new NewGameNotification());
        put(GameState.PAUSED, new PausedGameNotification());
        put(GameState.FINISHED, new FinishedGameNotification());
    }};


    public GameView(GameController controller, Subscriber subscriber) {
        super("Bomberman");
        this.gameController = controller;
        keyboard = new Keyboard(controller);
        this.subscriber = subscriber;
        setPreferredSize(new Dimension(600, 800));
        setBackground(Color.BLACK);
//        setResizable(false);
        initCanvas();
        subscriber.subscribe(EventType.MODEL_UPDATE, this);
        startView();
        controller.newGame();
    }

    private void initCanvas() {
        canvas = new Canvas();
        Container container = getContentPane();
        container.add(canvas);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setTitle("Bomberman");
        setVisible(true);
        initResizeListener();
        initKeyListener(keyboard);

    }

    private void initKeyListener(Keyboard keyboard) {
        this.addKeyListener(keyboard);
    }

    private void initResizeListener() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                gameScreenParameters.resized(canvas.getSize());
            }
        });
    }


    private void startView() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(GameData gameData) {
        needUpdate = true;
        this.gameData = gameData;
    }

    @Override
    public void run() {
        while (!Game.getGameState().equals(GameState.FINISHED)) {
            if (needUpdate) {
                System.out.println(gameData);
                canvas.repaint(gameData);
            }
            needUpdate = false;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Canvas extends JPanel {
        private GameData data;

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
                canvas.setBackground(Color.BLACK);
                g2.scale(gameScreenParameters.getX(), gameScreenParameters.getY());

                draw(g2, data);

                GameState gameStatus = data.getGameState();
                if (!GameState.RUNNING.equals(gameStatus)) {
                    Renderable renderable = notificationsScreen.get(gameStatus);
                    renderable.render(g2);
                }
            }
        }

        private void draw(Graphics2D g2, GameData data) {

        }

        private void setQuality(Graphics2D g2) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
        }
    }
}
