package ru.rsreu.nikolaev0211.view.notification;

import ru.rsreu.nikolaev0211.model.GameState;
import ru.rsreu.nikolaev0211.view.Renderable;

public enum NotificationViewType {

    NEW(GameState.NEW, new NewGameNotification()),
    PAUSED(GameState.PAUSED, new PausedGameNotification()),
    FINISHED(GameState.FINISHED, new FinishedGameNotification());

    private final Renderable notificationView;
    private final GameState gameState;

    NotificationViewType(GameState gameState, Renderable notificationView1) {
        this.notificationView = notificationView1;
        this.gameState = gameState;
    }

    public static Renderable getNotificationView(GameState gameState) {
        NotificationViewType notificationViewType = null;
        for (NotificationViewType notificationType : NotificationViewType.values()) {
            if (notificationType.getGameState().equals(gameState)) {
                notificationViewType = notificationType;
                break;
            }
        }
        return notificationViewType.getNotificationView();
    }

    public GameState getGameState() {
        return gameState;
    }

    public Renderable getNotificationView() {
        return notificationView;
    }
}
