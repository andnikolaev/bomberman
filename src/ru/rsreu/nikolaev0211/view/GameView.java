package ru.rsreu.nikolaev0211.view;

import ru.rsreu.nikolaev0211.events.EventListener;
import ru.rsreu.nikolaev0211.model.Game;
import ru.rsreu.nikolaev0211.model.GameData;

public class GameView implements EventListener, Runnable {
    private boolean needUpdate = false;

    private GameData gameData;

    @Override
    public void update(GameData gameData) {
        needUpdate = true;
        this.gameData = gameData;
    }

    @Override
    public void run() {
        while (true) {
            if (needUpdate) {
                System.out.println(gameData);
            }
            needUpdate = false;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
