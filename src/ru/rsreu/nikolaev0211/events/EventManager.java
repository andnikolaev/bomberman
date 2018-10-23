package ru.rsreu.nikolaev0211.events;

import ru.rsreu.nikolaev0211.model.GameData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, List<EventListener>> listeners = new HashMap<String, List<EventListener>>();

    public EventManager(EventType... operations) {
        for (EventType operation : operations) {
            this.listeners.put(operation.name(), new ArrayList<EventListener>());
        }
    }

    public void subscribe(EventType eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType.name());
        users.add(listener);
    }

    public void unsubscribe(EventType eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType.name());
        int index = users.indexOf(listener);
        users.remove(index);
    }

    public void notify(EventType eventType, GameData gameData) {
        List<EventListener> users = listeners.get(eventType.name());
        for (EventListener listener : users) {
            listener.update(gameData);
        }
    }
}
