package ru.rsreu.nikolaev0211.model;

public interface BombermanAction {
    void placeBomb();

    void pause(boolean isPaused);

    boolean isPaused();

    void start();
}
