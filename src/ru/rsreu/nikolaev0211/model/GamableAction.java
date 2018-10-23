package ru.rsreu.nikolaev0211.model;

public interface GamableAction {
    void placeBomb();

    void pause(boolean isPaused);

    boolean isPaused();
}
