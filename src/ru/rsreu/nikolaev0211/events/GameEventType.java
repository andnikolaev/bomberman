package ru.rsreu.nikolaev0211.controller;

import ru.rsreu.nikolaev0211.model.GamableAction;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

public enum GameEventType {

    PAUSE(Arrays.asList(KeyEvent.VK_P, KeyEvent.VK_O)) {
        @Override
        void startAction(GamableAction game) {
            game.pause(!game.isPaused());
        }
    },
    BOMB(Arrays.asList(KeyEvent.VK_SPACE, KeyEvent.VK_ALT)) {
        @Override
        void startAction(GamableAction game) {
            game.placeBomb();
        }
    };

    private final List<Integer> keyCodes;

    GameEventType(List<Integer> keyCode) {
        this.keyCodes = keyCode;
    }

    public static GameEventType getGameEventByKeyCode(int keyCode) {
        GameEventType result = null;
        for (GameEventType eventType : GameEventType.values()) {
            if (eventType.getKeyCode().contains(keyCode)) {
                result = eventType;
                break;
            }
        }
        return result;
    }

    public List<Integer> getKeyCode() {
        return keyCodes;
    }

    abstract void startAction(GamableAction game);
}
