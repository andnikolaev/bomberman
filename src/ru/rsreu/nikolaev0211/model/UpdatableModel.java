package ru.rsreu.nikolaev0211.model;

import ru.rsreu.nikolaev0211.events.EventType;

public interface UpdatableModel {
    void update(EventType eventType);
}
