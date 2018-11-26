package ru.rsreu.nikolaev0211.events;

import ru.rsreu.nikolaev0211.model.mob.move.Movable;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

public enum MovableEventType {
    UP(Arrays.asList(KeyEvent.VK_UP, KeyEvent.VK_W)) {
        @Override
        public void startMoving(Movable entity) {
            entity.moveUp(true);
        }

        @Override
        public void stopMoving(Movable entity) {
            entity.moveUp(false);
        }
    },
    LEFT(Arrays.asList(KeyEvent.VK_LEFT, KeyEvent.VK_A)) {
        @Override
        public void startMoving(Movable entity) {
            entity.moveLeft(true);
        }

        @Override
        public void stopMoving(Movable entity) {
            entity.moveLeft(false);
        }
    },
    DOWN(Arrays.asList(KeyEvent.VK_DOWN, KeyEvent.VK_S)) {
        @Override
        public void startMoving(Movable entity) {
            entity.moveDown(true);
        }

        @Override
        public void stopMoving(Movable entity) {
            entity.moveDown(false);
        }
    },
    RIGHT(Arrays.asList(KeyEvent.VK_RIGHT, KeyEvent.VK_D)) {
        @Override
        public void startMoving(Movable entity) {
            entity.moveRight(true);
        }

        @Override
        public void stopMoving(Movable entity) {
            entity.moveRight(false);
        }
    };

    private final List<Integer> keyCodes;

    MovableEventType(List<Integer> keyCode) {
        this.keyCodes = keyCode;
    }

    public static MovableEventType getMovableOperationByKeyCode(int keyCode) {
        MovableEventType result = null;
        for (MovableEventType eventType : MovableEventType.values()) {
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

    public abstract void startMoving(Movable entity);

    public abstract void stopMoving(Movable entity);
}
