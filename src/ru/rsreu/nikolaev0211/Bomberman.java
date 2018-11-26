package ru.rsreu.nikolaev0211;

import ru.rsreu.nikolaev0211.controller.GameController;
import ru.rsreu.nikolaev0211.events.EventManager;
import ru.rsreu.nikolaev0211.events.EventType;
import ru.rsreu.nikolaev0211.model.Game;
import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.model.GameField;
import ru.rsreu.nikolaev0211.model.GameState;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.model.mob.Player;
import ru.rsreu.nikolaev0211.model.mob.level.Level;
import ru.rsreu.nikolaev0211.model.mob.level.LevelReader;
import ru.rsreu.nikolaev0211.model.mob.monster.AI.EasyAI;
import ru.rsreu.nikolaev0211.model.mob.monster.SimpleMonster;
import ru.rsreu.nikolaev0211.view.GameView;
import ru.rsreu.nikolaev0211.view.Keyboard;
import sun.security.krb5.internal.TGSRep;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Bomberman {
    public Bomberman() {

    }

    public static void main(String[] args) {
        Bomberman bomberman = new Bomberman();
        bomberman.startGame();
//        LevelReader levelReader = new LevelReader();
//        Level level = levelReader.readLevel("C:\\Users\\Andrey_Nikolaev\\Downloads\\bomberman-master (3)\\02-11-Nikolaev\\resources\\Level.txt");

    }

    public void startGame() {
        EventManager eventManager = new EventManager(EventType.MODEL_UPDATE);
        Game game = new Game(eventManager);
        GameController gameController = new GameController(game);
        GameView gameView = new GameView(gameController, eventManager);

//        Game.setGameState(GameState.RUNNING);


        // testGui(keyboard);
    }

    public void testGui(Keyboard keyboard) {

        // JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Bomberman");

        frame.setSize(300, 150);

        frame.addKeyListener(keyboard);

        Canvas canvas = new Canvas();

        Container cp = frame.getContentPane();
        cp.add(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
        frame.setTitle("ASDS");

        frame.createBufferStrategy(3);
        BufferStrategy bufferStrategy = frame.getBufferStrategy();
        // Get a new graphics context every time through the loop
        // to make sure the strategy is validated
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(Color.red);
        graphics.drawString("asd", 100, 100);
        graphics.dispose();
        // Dispose the graphics
//                graphics.dispose();

        // Repeat the rendering if the drawing buffer contents
        // were restored
        bufferStrategy.show();

        // Display the buffer
    }

    private class Canvas extends JPanel {
        public void repaint(Object data) {
            setDoubleBuffered(true);
            repaint();
        }
    }
}
