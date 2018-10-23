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
import ru.rsreu.nikolaev0211.model.mob.monster.AI.EasyAI;
import ru.rsreu.nikolaev0211.model.mob.monster.SimpleMonster;
import ru.rsreu.nikolaev0211.view.GameView;
import ru.rsreu.nikolaev0211.view.Keyboard;
import sun.security.krb5.internal.TGSRep;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Bomberman {
    public Bomberman() {

    }

    public static void main(String[] args) {
        Bomberman bomberman = new Bomberman();
        bomberman.startGame();
    }

    public void startGame() {
        GameView gameView = new GameView();
        EventManager eventManager = new EventManager(EventType.MODEL_UPDATE);
        Game game = new Game(eventManager);
        Player player = new Player(0, 0, 1, game);
        List<Mob> monsterList = new ArrayList<Mob>();
        monsterList.add(new SimpleMonster(0, 0, 1, game, new EasyAI()));
        monsterList.add(new SimpleMonster(0, 0, 1, game, new EasyAI()));

        GameField gameField = new GameField();
        game.setGameField(gameField);
        game.setMonsters(monsterList);
        game.setPlayer(player);

        GameController gameController = new GameController(game);
        Keyboard keyboard = new Keyboard(gameController);

        Game.setGameState(GameState.RUNNING);
        game.getEventManager().subscribe(EventType.MODEL_UPDATE, gameView);
        Thread thread = new Thread(player);
        thread.start();
        for (Mob mob : monsterList) {
            thread = new Thread(mob);
            thread.start();
        }
        thread = new Thread(gameView);
        thread.start();
        testGui(keyboard);
    }

    public void testGui(Keyboard keyboard) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("KeyListener Example");
        frame.setSize(300, 150);

        final JLabel label = new JLabel();
        frame.add(label);

        frame.addKeyListener(keyboard);

        frame.setVisible(true);
    }
}
