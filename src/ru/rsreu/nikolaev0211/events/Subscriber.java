package ru.rsreu.nikolaev0211.events;

public interface Subscriber {
    void subscribe(EventType eventType, EventListener listener);

    void unsubscribe(EventType eventType, EventListener listener);
}
